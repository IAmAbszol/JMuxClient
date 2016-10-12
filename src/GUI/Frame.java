package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	
	private GUI gui;
	
	public Frame() {
		
		gui = new GUI();
		
		JFrame frame = new JFrame("JMux Client");
		frame.setContentPane(gui);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GUI getGUI() { return gui; }

}
