package server.jdo.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.data.Cancion;

public class CancionDAO implements ICancionDAO{
	
	private PersistenceManagerFactory pmf;
	

	public CancionDAO ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public void storeCancion(Cancion can) {
		// TODO Auto-generated method stub
		this.storeObject(can);
	}
	
	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + object);
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}

	@Override
	public Cancion getCancion(int idCancion) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Cancion can = null;
	    
		try {
			System.out.println ("   * Querying a Cancion number: " + idCancion);
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Cancion.class.getName() + " WHERE idCancion == '" + idCancion + "'");
	    	query.setUnique(true);
	    	can = (Cancion)query.execute();	    
 	    	tx.commit();
 	    	System.out.println("Reproduciendo cancion: "+can.getTituloCancion()+"...");
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return can;
	}

}
