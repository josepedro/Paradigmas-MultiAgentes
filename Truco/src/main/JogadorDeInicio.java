package main;

import jade.core.Agent;

public class JogadorDeInicio extends Agent {
	
	protected void setup() {
	  	System.out.println("Hello World! Maaaaaoe meu nome eh: "+getLocalName());
	  	
	  	// Make this agent terminate
	  	doDelete();
	  } 
	
}
