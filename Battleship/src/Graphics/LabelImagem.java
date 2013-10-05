package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelImagem extends JLabel {

	public BufferedImage i;
	
	public LabelImagem (String s) {
		try {
			i = ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(i, 0, 0, null);
	}
	
	
}
