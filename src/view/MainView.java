package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import component.OwnCompPanel;

public class MainView extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout ());
		
		OwnCompPanel ownCompPanel_1 = new OwnCompPanel();
		getContentPane().add(ownCompPanel_1);
		
		OwnCompPanel ownCompPanel = new OwnCompPanel();
		getContentPane().add(ownCompPanel);
		
	}

}
