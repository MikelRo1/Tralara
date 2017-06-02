package server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.data.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	//private List<Usuario> usuariosCache;
	private PersistenceManagerFactory pmf;
	

	public UsuarioDAO ()
	{
		//this.usuariosCache = new ArrayList<>();
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public void storeUsario(Usuario usu) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an user: " + usu.getNombreUsuario());
	       pm.makePersistent(usu);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an usuario: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	    
	}

	
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Usuario> usu = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Usuarios.");
			
			tx.begin();
			System.out.println("estamos en UsuarioDAO y  hemos hecho begin");
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			System.out.println("estamos en UsuarioDAO y  hemos hecho getExtent");
			for (Usuario product : extent) {
				usu.add(product);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage() );
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return usu;
	}
	
	public Usuario getUsu(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usu = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE usuario == '" + name + "'");
	    	query.setUnique(true);
	    	usu = (Usuario)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return usu;
	}



	@Override
	public void updateUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		
	}	
	
}
