package main;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

/**
 * Implementando o jogador novato
 */
public class JogadorDeInicio extends Agent {

	protected GUIjogo m_frame = null;

	// Inserindo comportamento de jogar carta
	class ComportamentoJogarCartas extends SimpleBehaviour {

		// Instancia do comportamento
		public ComportamentoJogarCartas(Agent agente) {
			super(agente);
		}

		@Override
		public void action() {
			System.out.println("Eu " + myAgent.getLocalName()
					+ " acabei de jogar uma carta.");
		}

		@Override
		public boolean done() {
			// O comportamento so sera executado uma vez
			return true;
		}

	}

	// Inserindo comportamento de pedir truco
	class ComportamentoPedirTruco extends SimpleBehaviour {

		// Instancia do comportamento
		public ComportamentoPedirTruco(Agent agente) {
			super(agente);
		}

		@Override
		public void action() {
			System.out.println("Eu " + myAgent.getLocalName()
					+ " não quero pedir truco nem a pau.");
		}

		@Override
		public boolean done() {
			// O comportamento so sera executado uma vez
			return true;
		}

	}
	
	// Inserindo comportamento de aceitar truco
		class ComportamentoAceitarTruco extends SimpleBehaviour {

			// Instancia do comportamento
			public ComportamentoAceitarTruco(Agent agente) {
				super(agente);
			}

			@Override
			public void action() {
				System.out.println("Eu " + myAgent.getLocalName()
						+ " aceito truco na hora.");
			}

			@Override
			public boolean done() {
				// O comportamento so sera executado uma vez
				return true;
			}

		}


	protected void setup() {

		System.out.println("O jogador " + getLocalName()
				+ " está querendo jogar!");

		// Adicionando descricao ao agente jogador novato
		// DFAgentDescription descricaoAgente = new DFAgentDescription();
		// descricaoAgente.setName(getAID());
		// ServiceDescription servicoDescricao = new ServiceDescription();
		// servicoDescricao
		// .setType("Jogador Novato: joga cartas aleatorias; nunca pede truco; sempre aceita truco");
		// servicoDescricao.setName("JADE-Novato");
		// descricaoAgente.addServices(servicoDescricao);
		// try {
		// DFService.register(this, descricaoAgente);
		// } catch (FIPAException e) {
		// e.printStackTrace();
		// }

		//

		// Iniciando a GUI de desenvolvimento do agente jogador
		inciandoGUI();
		

	}

	private void inciandoGUI() {
		m_frame = new GUIjogo(this);
		m_frame.setSize(800, 200);
		m_frame.setLocation(400, 400);
		m_frame.setVisible(true);
		m_frame.validate();
	}

	public void jogaCarta() {
		ComportamentoJogarCartas jogarCartas = new ComportamentoJogarCartas(
				this);
		addBehaviour(jogarCartas);
	}

	public void pedeTruco() {
		ComportamentoPedirTruco pedirTruco = new ComportamentoPedirTruco(this);
		addBehaviour(pedirTruco);
	}
	
	public void aceitaTruco() {
		ComportamentoAceitarTruco aceitarTruco = new ComportamentoAceitarTruco(this);
		addBehaviour(aceitarTruco);
	}
}
