package main;

import java.util.ArrayList;
import java.util.List;

import regrasTruco.Baralho;
import regrasTruco.Cartas;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

/**
 * Implementando o jogador novato
 */
@SuppressWarnings("serial")
public class JogadorDeInicio extends Agent {

	protected GUIjogo m_frame = null;
	protected Baralho baralho = new Baralho();
    protected ArrayList<Cartas> monte = new ArrayList<Cartas>();
    protected int pontuacaoFinal = 0;
    // Inserindo comportamento de jogar carta
	class ComportamentoJogarCartas extends SimpleBehaviour {

		// Instancia do comportamento
		public ComportamentoJogarCartas(Agent agente) {
			super(agente);
		}

		@Override
		public void action() {
			baralho.adicionarCartas(monte);
			List<Cartas> mao = baralho.cartasDaMao(monte);
			System.out.println("Eu " + myAgent.getLocalName()
					+ " Comprei 3 cartas "+mao);
			System.out.println("Eu " + myAgent.getLocalName()
					+ " acabei de jogar uma carta "+mao.get(0));
			mao.remove(0);
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
				pontuacaoFinal = pontuacaoFinal +3;
				System.out.println("A partida agora esta valendo "+pontuacaoFinal);
			}

			@Override
			public boolean done() {
				// O comportamento so sera executado uma vez
				return true;
			}

		}


	protected void setup() {

		// Adicionando jogador de Inicio nas paginas amarelas
		System.out.println("O jogador " + getLocalName()
				+ " esta querendo jogar!");

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("Pessoa Comum");
		sd.setName("Pessoa Comum");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}

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
