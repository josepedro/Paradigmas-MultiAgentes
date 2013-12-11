package main;

import jade.core.Agent;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

import javax.swing.JFrame;

/**
 * Implementando o jogador novato
 */
public class JogadorDeInicio extends Agent {

	protected GUIjogo m_frame = null;

	protected void setup() {
		System.out.println("O jogador "+getLocalName()+" esta querendo jogar!");
		
		//Adicionando descricao ao agente jogador novato
		DFAgentDescription descricaoAgente = new DFAgentDescription();
		descricaoAgente.setName( getAID() );
        try {
			DFService.register( this, descricaoAgente);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
        
        //Iniciando a GUI de desenvolvimento do agente jogador
        inciandoGUI();
		

		// Make this agent terminate
		doDelete();
	}

	private void inciandoGUI() {
		m_frame = new GUIjogo(this);

        m_frame.setSize( 400, 200 );
        m_frame.setLocation( 400, 400 );
        m_frame.setVisible( true );
        m_frame.validate();
	}
}
