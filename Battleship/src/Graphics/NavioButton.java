package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class NavioButton extends JButton {

	public BufferedImage i;
	int player;
	public String tipo;
	public String posicao;
	
	public NavioButton(String s)
	{
		posicao="horizontal";
		try
		{
		i=ImageIO.read(new File(s));
		}
		catch(IOException e)
		{
		System.out.println(e.getMessage());
		System.exit(1);
		}
		
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(i, 0, 0, null);
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
	
	

}
