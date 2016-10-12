package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GUI extends JPanel {
	
	// have it so width and height update with the frame
	private static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private Graphics2D g;
	private BufferedImage img;
	
	public GUI() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		
		img = new BufferedImage(
				WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB
			);
		g = (Graphics2D) img.getGraphics();
		
	}

	public BufferedImage getImage() { return img; }
	
	public void setImage(BufferedImage img) { this.img = img; }
	
	public void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(img, 0, 0,  this.getWidth(), this.getHeight(), null);
		g2.dispose();
	}
	
}
