package server.data.data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Reproduccion
{
	
	protected Pago subject;
	
	public Reproduccion(Pago subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	
	   public void update() {
	      System.out.println(subject.getState()); 
	   }

}
