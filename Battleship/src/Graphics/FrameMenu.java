package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import System.Tratador;

public class FrameMenu extends JFrame{

	public final int LARG_DEFAULT = 690;
	public final int ALT_DEFAULT = 360;
	LabelImagem image = new LabelImagem("imagens/outros/BT.jpg");
	
	
	public FrameMenu () {
		setTitle("Battleship");
		setBounds(0, 0, LARG_DEFAULT, ALT_DEFAULT);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);	
		Tratador tt = new Tratador();
		
		JButton start = new JButton("Novo Jogo");
		start.setBounds(20, 200, 120, 40);		
		start.setName("NovoJogo");
		start.setVisible(true);
		this.add(start); //0
		start.addMouseListener(tt);
		
		JButton load = new JButton("Carregar Jogo");
		load.setBounds(20, 240, 120, 40);		
		load.setName("CarregarJogo");
		load.setVisible(true);
		this.add(load); //1
		load.addMouseListener(tt);
				
		JButton exit = new JButton("Sair");
		exit.setBounds(20, 280, 120, 40);		
		exit.setName("Sair");
		exit.setVisible(true);
		this.add(exit); //2
		exit.addMouseListener(tt);
		
		image.setBounds(0, 0, LARG_DEFAULT, ALT_DEFAULT);
		image.setVisible(true);
		this.add(image);//3
		
	}
	
}
