package main;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class Jogador2 extends Agent {

	private AID[] jogador1;

	

	public void setup() {

		// Adicionando um Jogador
		System.out.println("O jogador 2 : " + getAID().getName()
				+ " entrou no jogo");

		// Registrando pessoas nas páginas amarelas
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("Jogador2");
		sd.setName("Jogador Experiente");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}

		// Pesquisando pessoas nas páginas amarelas
		addBehaviour(new TickerBehaviour(this, 3000) {
			protected void onTick() {

				DFAgentDescription template = new DFAgentDescription();
				ServiceDescription sd = new ServiceDescription();
				sd.setType("Jogador1");
				template.addServices(sd);

				try {

					DFAgentDescription[] result = DFService.search(myAgent,
							template);
					jogador1 = new AID[result.length];
					for (int i = 0; i < result.length; ++i) {
						jogador1[i] = result[i].getName();
					}
				} catch (FIPAException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});


		addBehaviour(new TickerBehaviour(this, 10000) {
			protected void onTick() {
				
				
				ACLMessage msg = myAgent.receive();
				ACLMessage order = new ACLMessage(ACLMessage.CFP);
				ACLMessage mensagemParaJogador2 = new ACLMessage(ACLMessage.CFP);
				for (int i = 0; i < jogador1.length; ++i) {
					mensagemParaJogador2.addReceiver(jogador1[i]);
				}
				mensagemParaJogador2.setContent("Bora jogar meu Pato ?");
				mensagemParaJogador2.setConversationId("Chamar");
				

				mensagemParaJogador2.setContent("Joguei a carta :  ?");
				mensagemParaJogador2.setConversationId("Jogada");
				
				
				
				myAgent.send(mensagemParaJogador2);
				myAgent.send(mensagemParaJogador2);
				myAgent.send(mensagemParaJogador2);
				if (msg != null) {
					// CFP Message received. Process it
					ACLMessage reply = msg.createReply();
					System.out.println("Aguardando um jogador : "
							+ msg.getContent());
					// Recebe Mensagem de Policial
					if (reply.getConversationId() == "Chamar") {
						reply.setPerformative(ACLMessage.AGREE);
						reply.setContent("Simbora meu pato");

						// Recebe Mensagem de PessoaComum
					} else if (reply.getConversationId() == "Jogada") {
						reply.setPerformative(ACLMessage.AGREE);
						reply.setContent("Joguei a carta ");

						// Recebe mensagem de Usuário
					} else if (reply.getConversationId() == "Truco") {
						reply.setPerformative(ACLMessage.FAILURE);
						reply.setContent("ACEITO");
					}
					myAgent.send(reply);
					System.out.println("O jogador 2 respondeu: "
							+ reply.getContent());
				} else {
					block();
				}
			}
		});

	}

	
	public void takeDown() {
		// Desresgistrando das páginas amarelas
		try {
			DFService.deregister(this);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}
		System.out.println("O jogador : " + getAID().getName()
				+ "saiu do jogo");
	}
}
