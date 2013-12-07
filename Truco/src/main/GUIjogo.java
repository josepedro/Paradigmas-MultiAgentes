package main;

import java.awt.*;
import javax.swing.*;
import java.beans.*;
import javax.swing.event.*;
import java.awt.event.*;

import jade.core.behaviours.OneShotBehaviour;

public class GUIjogo extends JFrame {

	BorderLayout borderLayout1 = new BorderLayout();
	JPanel pnl_main = new JPanel();
	JButton btn_Exit = new JButton();
	Component component3;
	JButton btn_stop = new JButton();
	Component component2;
	JButton btn_start = new JButton();
	Box box_buttons;
	JPanel pnl_numGuests = new JPanel();
	BorderLayout borderLayout3 = new BorderLayout();
	JLabel lbl_numGuests = new JLabel();
	Box box_numGuests;
	JLabel lbl_guestCount = new JLabel();
	JSlider slide_numGuests = new JSlider();
	Component component1;
	Component component4;
	GridLayout gridLayout1 = new GridLayout();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel lbl_numIntroductions = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel lbl_partyState = new JLabel();
	Box box1;
	JProgressBar prog_rumourCount = new JProgressBar();
	Component component6;
	Component component5;
	JLabel jLabel3 = new JLabel();
	JLabel lbl_rumourAvg = new JLabel();

	// protected HostAgent m_owner;


	public GUIjogo() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// m_owner = owner;
	}

	private void jbInit() throws Exception {
		pnl_main.setLayout(gridLayout1);
		btn_Exit.setText("Exit");
		btn_Exit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Exit_actionPerformed(e);
			}
		});
		btn_stop.setEnabled(false);
		btn_stop.setText("Stop");
		btn_stop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_stop_actionPerformed(e);
			}
		});
		btn_start.setText("Start");
		btn_start.addActionListener(new java.awt.event.ActionListener() {
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
		pnl_main.add(btn_start, null);
		pnl_main.add(btn_Exit, null);
		pnl_main.add(btn_stop, null);
				
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
		btn_start.setEnabled(!starting);
		btn_stop.setEnabled(starting);
		slide_numGuests.setEnabled(!starting);
		btn_Exit.setEnabled(!starting);
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
