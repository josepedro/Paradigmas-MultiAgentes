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
		feedback.setText("Tessstando");
		this.getContentPane().add(pnl_feedback, BorderLayout.NORTH);
		pnl_feedback.add(feedback);
		botao_joga_carta.setText("Jogue Carta");
		botao_joga_carta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Exit_actionPerformed(e);
			}
		});
		botao_aceita_truco.setText("Aceita Truco?");
		botao_aceita_truco
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_stop_actionPerformed(e);
					}
				});
		botao_pede_truco.setText("Pede Truco?");
		botao_pede_truco.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_start_actionPerformed(e);
			}
		});
		this.setTitle("Truco");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				this_windowClosing(e);
			}
		});
		this.getContentPane().add(pnl_main, BorderLayout.CENTER);
		pnl_main.add(botao_joga_carta, null);
		pnl_main.add(botao_pede_truco, null);
		pnl_main.add(botao_aceita_truco, null);

	}

	/**
	 * When the user clicks on start, notify the host to begin the party.
	 */
	void btn_start_actionPerformed(ActionEvent e) {
		// enableControls( true );
		//
		// // add a behaviour to the host to start the conversation going
		// m_owner.addBehaviour( new OneShotBehaviour() {
		// public void action() {
		// ((HostAgent) myAgent).inviteGuests( slide_numGuests.getValue() );
		// }
		// } );
	}

	/**
	 * When the user clicks on stop, tell the host to stop the party.
	 */
	void btn_stop_actionPerformed(ActionEvent e) {
		// enableControls( false );
		//
		// // add a behaviour to the host to end the party
		// m_owner.addBehaviour(() new OneShotBehaviour() {
		// public void action() {
		// ((HostAgent) myAgent).endParty();
		// }
		// } );
	}

	void enableControls(boolean starting) {
		botao_pede_truco.setEnabled(!starting);
		botao_aceita_truco.setEnabled(starting);
		botao_joga_carta.setEnabled(!starting);
	}

	void btn_Exit_actionPerformed(ActionEvent e) {
		// m_owner.addBehaviour( new OneShotBehaviour() {
		// public void action() {
		// ((HostAgent) myAgent).terminateHost();
		// }
		// } );
	}

	void this_windowClosing(WindowEvent e) {
		// simulate the user having clicked exit
		btn_Exit_actionPerformed(null);
	}

}
