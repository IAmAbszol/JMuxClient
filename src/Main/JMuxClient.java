package Main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.imageio.ImageIO;

import GUI.Frame;
import GUI.IPPort;

public class JMuxClient {
	
	public static String host = "localhost";
	public static int port = 12345;
	
	private static Frame frame;
	private static Socket socket;
	private static DataInputStream dIn;
	
	public static boolean run = true;
	
	public static void main(String[] args)  {
		
		IPPort ip = new IPPort();
		
		while(ip.run) {
			System.out.print("");
		}
		
		ip.dispose();

		try {
			frame = new Frame();
			
			System.out.println("Connecting To Server");
			socket = new Socket(host, port);
			
			System.out.println("Server Allowed Connection, Lets Begin");
			dIn = new DataInputStream(socket.getInputStream());
			
			while(true) {
				
				byte[] tmp = readIn();
				if(tmp != null) {
					
					InputStream in = new ByteArrayInputStream(readIn());
					BufferedImage img = ImageIO.read(in);
					
					frame.getGUI().setImage(img);
					frame.getGUI().drawToScreen();
				
				} else {
					BufferedImage img = ImageIO.read(JMuxClient.class.getResource("/sad.png"));
					frame.getGUI().setImage(img);
					frame.getGUI().drawToScreen();
				}
				
			}
		} catch (Exception e) {
			BufferedImage img;
			try {
				while(true) {
					img = ImageIO.read(JMuxClient.class.getResource("/sad.png"));
					frame.getGUI().setImage(img);
					frame.getGUI().drawToScreen();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	private static byte[] readIn() throws IOException {
		byte[] message = null;
		int length = dIn.readInt();                    // read length of incoming message
		if(length>0) {
		   message = new byte[length];
		    dIn.readFully(message, 0, message.length); // read the message
		}
		return message;
	}
	
	

}
