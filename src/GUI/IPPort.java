package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Main.JMuxClient;

public class IPPort extends JFrame {
	
	private JPanel contentPane;
	private JTextField ip;
	private JTextField port;
	private JButton defaultbtn;
	private JButton custombtn;
	
	public boolean run = true;
	
	public IPPort() {
		
		setTitle("Primary Load Configuration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIpAddress.setBounds(10, 11, 89, 14);
		panel.add(lblIpAddress);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 36, 89, 14);
		panel.add(lblNewLabel);
		
		ip = new JTextField();
		ip.setHorizontalAlignment(SwingConstants.CENTER);
		ip.setText("192.168.1.1");
		ip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		ip.setBounds(109, 10, 295, 20);
		panel.add(ip);
		ip.setColumns(10);
		
		port = new JTextField();
		port.setText("12345");
		port.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		port.setHorizontalAlignment(SwingConstants.CENTER);
		port.setBounds(109, 35, 295, 20);
		panel.add(port);
		port.setColumns(10);
		
		defaultbtn = new JButton("Default Config");
		defaultbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		defaultbtn.setBounds(10, 66, 197, 59);
		panel.add(defaultbtn);
		
		custombtn = new JButton("Custom Config");
		custombtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		custombtn.setBounds(206, 66, 198, 59);
		panel.add(custombtn);
		
		custombtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JMuxClient.host = ip.getText();
				JMuxClient.port = Integer.parseInt(port.getText());
				run = false;
				setVisible(false);
			}
			
		});
		
		defaultbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				run = false;
				setVisible(false);
			}
			
		});
		
		setVisible(true);
	}

}
