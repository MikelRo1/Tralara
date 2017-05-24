package server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.data.Cancion;
import server.data.data.Usuario;

public class CancionDAO<PersistenceManager> implements ICancionDAO {

	private PersistenceManagerFactory pmf;
	
	public CancionDAO ()
	{
		//this.usuariosCache = new ArrayList<>();
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	@Override
	public List<Cancion> getCanciones() {
		// TODO Auto-generated method stub
		PersistenceManager pm = (PersistenceManager) pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		((javax.jdo.PersistenceManager) pm).getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = ((javax.jdo.PersistenceManager) pm).currentTransaction();
		List<Cancion> cancion = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for canciones.");
			
			tx.begin();			
			Extent<Cancion> extent = ((javax.jdo.PersistenceManager) pm).getExtent(Cancion.class, true);
			
			for (Cancion product : extent) {
				cancion.add(product);
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
	    				
		return cancion;
	}

	@Override
	public Cancion getCancion(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = (PersistenceManager) pmf.getPersistenceManager();
		((javax.jdo.PersistenceManager) pm).getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = ((javax.jdo.PersistenceManager) pm).currentTransaction();
		Cancion cancion = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query query = ((javax.jdo.PersistenceManager) pm).newQuery("SELECT FROM " + Cancion.class.getName() + " WHERE tituloCancion == '" + name + "'");
	    	query.setUnique(true);
	    	cancion = (Cancion)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		((javax.jdo.PersistenceManager) pm).close();
	     }

	    return cancion;
	}

	@Override
	public void storeCancion(Cancion cancion) {
		// TODO Auto-generated method stub
		PersistenceManager pm = (PersistenceManager) pmf.getPersistenceManager();
	    Transaction tx = ((javax.jdo.PersistenceManager) pm).currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing a song: " + cancion.getTituloCancion());
	       ((javax.jdo.PersistenceManager) pm).makePersistent(cancion);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an cancion: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		((javax.jdo.PersistenceManager) pm).close();
	    }
	}


}
