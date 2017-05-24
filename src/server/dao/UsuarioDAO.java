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

public class UsuarioDAO<PersistenceManager> implements IUsuarioDAO{

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
		this.storeObject(usu);
	}
	
	private void storeObject(Object object) {
		PersistenceManager pm = (PersistenceManager) pmf.getPersistenceManager();
	    Transaction tx = ((javax.jdo.PersistenceManager) pm).currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + object);
	       ((javax.jdo.PersistenceManager) pm).makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		((javax.jdo.PersistenceManager) pm).close();
	    }
	}

	
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = (PersistenceManager) pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		((javax.jdo.PersistenceManager) pm).getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = ((javax.jdo.PersistenceManager) pm).currentTransaction();
		List<Usuario> products = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Usuario> extent = ((javax.jdo.PersistenceManager) pm).getExtent(Usuario.class, true);
			
			for (Usuario product : extent) {
				products.add(product);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		((javax.jdo.PersistenceManager) pm).close();    		
	    }
	    				
		return products;
	}
	
	public Usuario getUsu(String name){
		PersistenceManager pm = (PersistenceManager) pmf.getPersistenceManager();
		((javax.jdo.PersistenceManager) pm).getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = ((javax.jdo.PersistenceManager) pm).currentTransaction();
		Usuario usu = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query query = ((javax.jdo.PersistenceManager) pm).newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE name == '" + name + "'");
	    	query.setUnique(true);
	    	usu = (Usuario)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		((javax.jdo.PersistenceManager) pm).close();
	     }

	    return usu;
	}



	@Override
	public void updateUsuario(Usuario product) {
		// TODO Auto-generated method stub
		
	}	
	
}
