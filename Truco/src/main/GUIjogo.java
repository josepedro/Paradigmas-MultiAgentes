package main;

import java.awt.*;
import javax.swing.*;
import java.beans.*;
import javax.swing.event.*;
import java.awt.event.*;

import jade.core.behaviours.OneShotBehaviour;

public class GUIjogo extends JFrame {

	JPanel pnl_main = new JPanel();
	JButton botao_joga_carta = new JButton();
	JButton botao_aceita_truco = new JButton();
	JButton botao_pede_truco = new JButton();
	JPanel pnl_feedback = new JPanel();
	JLabel feedback = new JLabel();
	GridLayout gridLayout = new GridLayout();
	JButton botao_matar_agente = new JButton();
	JButton ver_mensagem_agente = new JButton();
	boolean jogadorMorto = false;

	protected JogadorDeInicio jogadorDeInicio;

	public GUIjogo(JogadorDeInicio jogadorDeInicio) {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.jogadorDeInicio = jogadorDeInicio;
	}

	private void jbInit() throws Exception {
		pnl_main.setLayout(gridLayout);
		feedback.setText("FeedBack do jogador...");
		ver_mensagem_agente.setText("O que diz o jogador?");
		ver_mensagem_agente
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent e) {
						botaoVerMensagem(e);
					}
				});
		this.getContentPane().add(pnl_feedback, BorderLayout.NORTH);
		pnl_feedback.add(ver_mensagem_agente);
		pnl_feedback.add(feedback);
		botao_joga_carta.setText("Jogue Carta");
		botao_joga_carta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoJogaCartaListener(e);
			}
		});
		botao_aceita_truco.setText("Aceita Truco?");
		botao_aceita_truco
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent e) {
						botaoAceitaTrucoListener(e);
					}
				});
		botao_pede_truco.setText("Pede Truco?");
		botao_pede_truco.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoPedeTrucoListener(e);
			}
		});
		botao_matar_agente.setText("Matar jogador");
		botao_matar_agente
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent e) {
						botaoMataAgenteListener(e);
					}
				});
		this.setTitle("Truco");
		this.getContentPane().add(pnl_main, BorderLayout.CENTER);
		pnl_main.add(botao_joga_carta, null);
		pnl_main.add(botao_pede_truco, null);
		pnl_main.add(botao_aceita_truco, null);
		pnl_main.add(botao_matar_agente, null);

	}

	void botaoPedeTrucoListener(ActionEvent e) {
		jogadorDeInicio.pedeTruco();
	}

	void botaoAceitaTrucoListener(ActionEvent e) {
		jogadorDeInicio.aceitaTruco();
	}

	void botaoJogaCartaListener(ActionEvent e) {
		jogadorDeInicio.jogaCarta();
	}

	void botaoMataAgenteListener(ActionEvent e) {
		if (jogadorMorto == false) {
			jogadorDeInicio.doDelete();
			feedback.setText("Eu jogador " + jogadorDeInicio.getLocalName()
					+ " estou morto!");
			jogadorMorto = true;
			botao_matar_agente.setEnabled(false);
			
		}

	}

	void botaoVerMensagem(ActionEvent e) {
		feedback.setText("Mensagem: " + jogadorDeInicio.receive().getContent());
	}

}
