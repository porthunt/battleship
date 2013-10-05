package Graphics;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import System.Tratador;
import System.TratadorMapeamento;

public class FrameJogo extends JFrame implements Observer, KeyListener {

	public final int LARG_DEFAULT = 690;
	public final int ALT_DEFAULT = 400;
	public LabelImagem cp[][] = new LabelImagem[15][15];
	public LabelImagem cp2[][] = new LabelImagem[15][15];
	Color blueColor = new Color(83, 141, 211);
	Jogador1 pr1 = Jogador1.getInstance();
	Jogador2 pr2 = Jogador2.getInstance();
	Jogador1Frame j1f = Jogador1Frame.getInstance();
	Jogador2Frame j2f = Jogador2Frame.getInstance();
	JLabel jog1;
	JLabel jog2;

	private int CORD_X = 39;
	private int CORD_X_2 = 371;
	private int CORD_Y = 24;
	private static final FrameJogo INSTANCE = new FrameJogo();

	public FrameJogo() {
		setTitle("Battleship");
		setBounds(0, 0, LARG_DEFAULT, ALT_DEFAULT);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		int i, j, l;
		char a;
		JLabel lab;
		TratadorMapeamento tt = new TratadorMapeamento();
		Tratador t1 = new Tratador();
		this.setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		
		jog1 = new JLabel("");
		jog1.setBounds(160, 340, 120, 30);
		jog1.setVisible(true);
		this.add(jog1);
		
		jog2 = new JLabel("");
		jog2.setBounds(500, 340, 120, 30);
		jog2.setVisible(true);
		this.add(jog2);

		JButton ocultar = new JButton("Salvar Jogo");
		ocultar.setName("SaveGame");
		ocultar.setBounds(300, 340, 120, 30);
		ocultar.setVisible(true);
		this.add(ocultar);
		ocultar.addMouseListener(t1);

		for (l = 1; l <= 9; l++) {
			lab = new JLabel(Integer.toString(l));
			lab.setBounds(24 + l * 20, 3, 20, 20);
			lab.setVisible(true);
			this.add(lab);
		}

		for (l = 10; l <= 15; l++) {
			lab = new JLabel(Integer.toString(l));
			lab.setBounds(20 + l * 20, 3, 20, 20);
			lab.setVisible(true);
			this.add(lab);
		}

		for (a = 'A', l = 1; a <= 'O'; a++, l++) {
			lab = new JLabel(Character.toString(a));
			lab.setBounds(20, 5 + l * 20, 20, 20);
			lab.setVisible(true);
			this.add(lab);
		}

		pr1.setBounds(8, -20, 350, 350);
		pr1.setVisible(true);
		this.add(pr1);

		for (l = 1; l <= 9; l++) {
			lab = new JLabel(Integer.toString(l));
			lab.setBounds(355 + l * 20, 3, 20, 20);
			lab.setVisible(true);
			this.add(lab);
		}

		for (l = 10; l <= 15; l++) {
			lab = new JLabel(Integer.toString(l));
			lab.setBounds(352 + l * 20, 3, 20, 20);
			lab.setVisible(true);
			this.add(lab);
		}

		for (a = 'A', l = 1; a <= 'O'; a++, l++) {
			lab = new JLabel(Character.toString(a));
			lab.setBounds(355, 5 + l * 20, 20, 20);
			lab.setVisible(true);
			this.add(lab);
		}

		pr2.setBounds(340, -20, 350, 350);
		pr2.setVisible(true);
		this.add(pr2);

		this.addMouseListener(tt);

		for (i = 0; i < 15; i++) {

			for (j = 0; j < 15; j++) {

				if (pr1.casas[i][j].getPrint() == 'A')
				{
					cp[i][j] = new LabelImagem("imagens/outros/agua.png");
				}
				else if (pr1.casas[i][j].getPrint() == 'N')
				{
					cp[i][j] = new LabelImagem("imagens/outros/navio.jpg");
				}
				else if (pr1.casas[i][j].getPrint() == 'D')
				{
					cp[i][j] = new LabelImagem("imagens/outros/destruido.png");
				}

				cp[i][j].setBounds(CORD_X, CORD_Y, 20, 20);
				cp[i][j].setVisible(true);
				cp[i][j].setLayout(null);
				this.add(cp[i][j]);
				CORD_X += 20;
			}
			CORD_X = 39;
			CORD_Y += 20;
		}

		CORD_Y = 24;

		for (i = 0; i < 15; i++) {

			for (j = 0; j < 15; j++) {

				if (pr2.casas[i][j].getPrint() == 'A')
				{
					cp2[i][j] = new LabelImagem("imagens/outros/agua.png");
				} 
				else if (pr2.casas[i][j].getPrint() == 'N')
				{
					cp2[i][j] = new LabelImagem(
							"imagens/outros/navio.jpg");
				} else if (pr2.casas[i][j].getPrint() == 'D')
				{
					cp2[i][j] = new LabelImagem("imagens/outros/destruido.png");
				}

				cp2[i][j].setBounds(CORD_X_2, CORD_Y, 20, 20);
				cp2[i][j].setVisible(true);
				cp2[i][j].setLayout(null);
				this.add(cp2[i][j]);
				CORD_X_2 += 20;
			}
			CORD_X_2 = 371;
			CORD_Y += 20;
		}
		
	}

	public void hideMap(int n) {
		int i, j;

		if (n == 2) {
			CORD_X_2 = 371;
			CORD_Y = 24;

			for (i = 0; i < 15; i++) {
				for (j = 0; j < 15; j++) {
					
					this.remove(cp2[i][j]);
				
					if (pr2.casas[i][j].isConhecido() && pr2.casas[i][j].getPrint()=='A') {
						cp2[i][j] = new LabelImagem("imagens/outros/agua.png");
					}
					else if (pr2.casas[i][j].isConhecido() && pr2.casas[i][j].getPrint()=='D') {
						cp2[i][j] = new LabelImagem("imagens/outros/destruido.png");
					}
					else {
						cp2[i][j] = new LabelImagem("imagens/outros/nuvem.png");				
					}
					cp2[i][j].setBounds(CORD_X_2, CORD_Y, 20, 20);
					cp2[i][j].setVisible(true);
					cp2[i][j].setLayout(null);
					this.add(cp2[i][j]);
					CORD_X_2 += 20;
				}
				CORD_X_2 = 371;
				CORD_Y += 20;
			}
		} 
		else
		{
			CORD_X = 39;
			CORD_Y = 24;

			for (i = 0; i < 15; i++) {
				for (j = 0; j < 15; j++) {
					
					this.remove(cp[i][j]);
					
					if (pr1.casas[i][j].isConhecido() && pr1.casas[i][j].getPrint() == 'A') {
						cp[i][j] = new LabelImagem("imagens/outros/agua.png");
					}
					else if (pr1.casas[i][j].isConhecido() && pr1.casas[i][j].getPrint() == 'D') {
						cp[i][j] = new LabelImagem("imagens/outros/destruido.png");
					}
					else {
						cp[i][j] = new LabelImagem("imagens/outros/nuvem.png");
					}
					
					cp[i][j].setBounds(CORD_X, CORD_Y, 20, 20);
					cp[i][j].setVisible(true);
					cp[i][j].setLayout(null);
					this.add(cp[i][j]);
					CORD_X += 20;
	
				}
				CORD_X = 39;
				CORD_Y += 20;
			}
		}
		this.repaint();
	}

	public void showMap(int n) {
		int i, j;

		if (n==2) {

			CORD_X_2 = 371;
			CORD_Y = 24;

			for (i = 0; i < 15; i++) {

				for (j = 0; j < 15; j++) {

					this.remove(cp2[i][j]);

					if (pr2.casas[i][j].getPrint() == 'A')
					{
						cp2[i][j] = new LabelImagem("imagens/outros/agua.png");
					} else if (pr2.casas[i][j].getPrint() == 'N')
					{
						cp2[i][j] = new LabelImagem("imagens/outros/navio.jpg");
					} else if (pr2.casas[i][j].getPrint() == 'D')
					{
						cp2[i][j] = new LabelImagem("imagens/outros/destruido.png");
					}
					
					cp2[i][j].setBounds(CORD_X_2, CORD_Y, 20, 20);
					cp2[i][j].setVisible(true);
					this.add(cp2[i][j]);
					System.out.println();
					CORD_X_2 += 20;
				}
				CORD_X_2 = 371;
				CORD_Y += 20;
			}
		}

		else {
			CORD_X = 39;
			CORD_Y = 24;

			for (i = 0; i < 15; i++) {

				for (j = 0; j < 15; j++) {

					this.remove(cp[i][j]);

					if (pr1.casas[i][j].getPrint() == 'A') {
						cp[i][j] = new LabelImagem("imagens/outros/agua.png");
					} else if (pr1.casas[i][j].getPrint() == 'N') {
						cp[i][j] = new LabelImagem(
								"imagens/outros/navio.jpg");
					} else if (pr1.casas[i][j].getPrint() == 'D') {
						cp[i][j] = new LabelImagem(
								"imagens/outros/destruido.png");
					}
					cp[i][j].setBounds(CORD_X, CORD_Y, 20, 20);
					cp[i][j].setVisible(true);
					this.add(cp[i][j]);
					CORD_X += 20;
				}
				CORD_X = 39;
				CORD_Y += 20;
			}
		}

		this.repaint();
	}

	public static synchronized FrameJogo getInstance() {
		return INSTANCE;
	}

	public void executeTurn(char a, int x, int casa, int coordX) {
		Jogador1 j1 = null;
		Jogador2 j2 = null;
		JFrame victory = new JFrame();
		
		j1 = j1.getInstance();
		j2 = j2.getInstance();
		
		if (j2.isTurn()==true && coordX>=40 && coordX<339 && j1.casas[casa][x-1].getEstado() != 'D') {

			if (j1.casas[casa][x-1].getEstado() == 'N') {
				System.out.println(Character.toString(a) + x + " foi destruido.");
				this.jog2.setText("ATINGIDO");
				j1.setQtdbarcos(j1.getQtdbarcos()-1);
				try {
					cp[casa][x-1].i = ImageIO.read(new File("imagens/outros/destruido.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cp[casa][x-1].paintImmediately(cp[casa][x-1].getBounds());
				j1.casas[casa][x-1].setPrint('D');
				if (j1.getQtdbarcos()==0) {
					JOptionPane.showMessageDialog(victory, "Jogador 2 venceu.", "", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
			} else if (j1.casas[casa][x-1].getEstado() == 'A'){
				System.out.println("Atingiu a agua.");
				this.jog2.setText("AGUA");
				j1.casas[casa][x-1].setPrint('A');
			}

			j1.casas[casa][x-1].setEstado('D');
			j1.casas[casa][x-1].setConhecido(true);
			j1.setTurn(true);
			j2.setTurn(false);
			showMap(1);
			hideMap(2);
			System.out.println(Integer.toString(j1.getQtdbarcos()));
		}
		else if (j1.isTurn()==true && coordX>=372 && coordX < 672 && j2.casas[casa][x-1].getEstado() != 'D') {

			if (j2.casas[casa][x-1].getEstado() == 'N') {
				System.out.println(Character.toString(a) + x + " foi destruido.");
				this.jog1.setText("ATINGIDO");
				j2.setQtdbarcos(j2.getQtdbarcos()-1);
				try {
					cp2[casa][x-1].i = ImageIO.read(new File("imagens/outros/destruido.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cp2[casa][x-1].paintImmediately(cp2[casa][x-1].getBounds());
				j2.casas[casa][x-1].setPrint('D');
				if (j2.getQtdbarcos()==0) {
					JOptionPane.showMessageDialog(victory, "Jogador 1 venceu.", "", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
			} else if (j1.casas[casa][x-1].getEstado() == 'A') {
				System.out.println("Atingiu a agua.");
				this.jog1.setText("AGUA");
				j2.casas[casa][x-1].setPrint('A');
			}
			else if (j1.casas[casa][x-1].getEstado() == 'D'){
				System.out.println(Character.toString(a)+x+" ja havia sido atingida. Voce perdeu seu turno.");
			}

			j2.casas[casa][x-1].setEstado('D');
			j2.casas[casa][x-1].setConhecido(true);
			j2.setTurn(true);
			j1.setTurn(false);
			showMap(2);
			hideMap(1);
			System.out.println(Integer.toString(j2.getQtdbarcos()));

		}
		else 
			System.out.println("Jogada invalida.");
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			Jogador1 j1 = null;
			j1 = j1.getInstance();
			Jogador2 j2 = null;
			j2 = j2.getInstance();
			Jogador1Frame j1f = null;
			j1f = j1f.getInstance();
			Jogador2Frame j2f = null;
			j2f = j2f.getInstance();
			int i, j;
			
			
			if (j2.getQtdbarcos()>0)
			{
				
			}
			else if (j1.getQtdbarcos()>0)
			{
				for (i=0; i<15; i++)
				{
					for (j=0; j<15; j++)
					{
						j1.casas[i][j].setEstado('A');
						j1.casas[i][j].setPrint('A');
					}
				}
				j1.setQtdbarcos(0);
				
				j1f.dispose();
				j1f = j1f.getInstance();
			}
			else {
				System.out.println("Nao ha barcos.");
			}
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_DELETE){
			System.out.println("teste");
		}
		
		else {
			System.out.println(Integer.toString(arg0.getKeyCode()));
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
