package server.data.data;

import java.io.Serializable;

public class Reproduccion implements Serializable
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
