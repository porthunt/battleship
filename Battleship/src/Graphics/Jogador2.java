package Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import System.Casas;

public class Jogador2 extends JPanel {

	private static final Jogador2 INSTANCE = new Jogador2();
	public Casas casas[][] = new Casas[15][15];
	boolean turn;
	private int qtdbarcos;

	private Jogador2() {
		Scanner sc;
		String str;
		int i, j;
		char estado = 'A';
		char tipo = '?';
		char print = 'A';
		turn = false;

		try {
			sc = new Scanner(new File("SaveGame2.txt")); // FILE 2

			for (i = 0; i < 15; i++) {
				str = sc.next();

				for (j = 0; j < 15; j++) {

					if (str.charAt(j) == 'A') {
						estado = 'A';
						tipo = 'X';
						print = 'A';
					}

					else if (str.charAt(j) == 'N') {
						estado = 'N';
						print = str.charAt(j);
					}

					else if (str.charAt(j) == 'D') {
						estado = 'D';
						print = 'D';
					} else {
						System.out.println("Problema ao ler arquivo.");
						System.exit(1);
					}

					casas[i][j] = new Casas(i + 1, j + 1, estado, tipo, print);
				}
			}

			for (i = 0; i < 15; i++) {
				str = sc.next();
				for (j = 0; j < 15; j++) {
					if (str.charAt(j) == '1') {
						casas[i][j].setConhecido(true);
					} else if (str.charAt(j) == '0') {
						casas[i][j].setConhecido(false);
					} else {
						System.out.println(str.charAt(j));
					}

				}
			}

		} catch (FileNotFoundException e) {
			for (i = 0; i < 15; i++) {
				for (j = 0; j < 15; j++) {
					casas[i][j] = new Casas(i + 1, j + 1, estado, tipo, print);
				}
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int i, j, l;
		JLabel lab;

		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++)

			{
				Rectangle2D r2d = new Rectangle2D.Double(30, 44, 20 + i * 20,
						20 + j * 20);
				g2d.draw(r2d);
			}
		}

	}

	public static synchronized Jogador2 getInstance() {
		return INSTANCE;
	}

	public void SaveGame() {
		int i, j;
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File("SaveGame2.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				try {
					writer.write(Character.toString(casas[i][j].getPrint()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				writer.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				if (casas[i][j].isConhecido()) {
					try {
						writer.write("1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						writer.write("0");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				writer.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public int getQtdbarcos() {
		return qtdbarcos;
	}

	public void setQtdbarcos(int qtdbarcos) {
		this.qtdbarcos = qtdbarcos;
	}

	public void posicionarNavio(String tipo, String pos, int i, int j) {
		FrameJogo fj = null;
		Jogador2Frame j2f = null;
		Jogador2 j2 = null;
		j2f = j2f.getInstance();
		j2 = j2.getInstance();
		fj = fj.getInstance();

		/* horizontal */

		if (i < 14 && j < 14 && i > 0 && j > 0 && pos.equals("horizontal")) {

			if (tipo.equals("submarino") && casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);
			}

			else if (tipo.equals("cruzador")
					&& casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 2;
					if (j + 1 <= 14) {
						fj.cp2[i][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 1].setEstado('N');
						j2.casas[i][j + 1].setPrint('N');
					} else {
						fj.cp2[i][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 1].setEstado('N');
						j2.casas[i][j - 1].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);
			}

			else if (tipo.equals("encouracado")
					&& casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 4;
					if (j + 3 <= 14) {
						fj.cp2[i][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 1].setEstado('N');
						j2.casas[i][j + 1].setPrint('N');
						fj.cp2[i][j + 2].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 2].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 2].setEstado('N');
						j2.casas[i][j + 2].setPrint('N');
						fj.cp2[i][j + 3].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 3].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 3].setEstado('N');
						j2.casas[i][j + 3].setPrint('N');
					} else {
						fj.cp2[i][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 1].setEstado('N');
						j2.casas[i][j - 1].setPrint('N');
						fj.cp2[i][j - 2].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 2].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 2].setEstado('N');
						j2.casas[i][j - 2].setPrint('N');
						fj.cp2[i][j - 3].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 3].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 3].setEstado('N');
						j2.casas[i][j - 3].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);
			}

			else if (tipo.equals("portaaviao")
					&& casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 5;
					if (j + 4 <= 14) {
						fj.cp2[i][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 1].setEstado('N');
						j2.casas[i][j + 1].setPrint('N');
						fj.cp2[i][j + 2].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 2].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 2].setEstado('N');
						j2.casas[i][j + 2].setPrint('N');
						fj.cp2[i][j + 3].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 3].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 3].setEstado('N');
						j2.casas[i][j + 3].setPrint('N');
						fj.cp2[i][j + 4].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j + 4].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j + 4].setEstado('N');
						j2.casas[i][j + 4].setPrint('N');
					} else {
						fj.cp2[i][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 1].setEstado('N');
						j2.casas[i][j - 1].setPrint('N');
						fj.cp2[i][j - 2].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 2].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 2].setEstado('N');
						j2.casas[i][j - 2].setPrint('N');
						fj.cp2[i][j - 3].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 3].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 3].setEstado('N');
						j2.casas[i][j - 3].setPrint('N');
						fj.cp2[i][j - 4].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j - 4].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i][j - 4].setEstado('N');
						j2.casas[i][j - 4].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);
			}

			if (tipo.equals("hidroaviao") && casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 3;

					if (i + 1 < 14) {
						fj.cp2[i + 1][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 1][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 1][j - 1].setEstado('N');
						j2.casas[i + 1][j].setPrint('N');
						fj.cp2[i + 1][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 1][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 1][j + 1].setEstado('N');
						j2.casas[i + 1][j + 1].setPrint('N');
					} else {
						fj.cp2[i - 1][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j - 1].setEstado('N');
						j2.casas[i - 1][j - 1].setPrint('N');
						fj.cp2[i - 1][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j + 1].setEstado('N');
						j2.casas[i - 1][j + 1].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);
			}

		}

		else if (i < 14 && j < 14 && i > 0 && j > 0 && pos.equals("vertical")) {

			if (tipo.equals("submarino") && casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.posicao = null;
				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);

				if (j2f.qtdbarcos == 0) {
					j2f.confirmar.setEnabled(true);
					j2f.confirmar.setVisible(true);
				}
			}

			else if (tipo.equals("cruzador")
					&& casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 2;
					if (i + 1 <= 14) {
						fj.cp2[i + 1][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
						j2.casas[i + 1][j].setEstado('N');
						j2.casas[i + 1][j].setPrint('N');
					} else {
						fj.cp2[i - 1][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j].setEstado('N');
						j2.casas[i - 1][j].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.posicao = null;
				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);

				if (j2f.qtdbarcos == 0) {
					j2f.confirmar.setEnabled(true);
					j2f.confirmar.setVisible(true);
				}
			}

			else if (tipo.equals("encouracado")
					&& casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 4;
					if (i + 3 <= 14) {
						fj.cp2[i + 1][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 1][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 1][j].setEstado('N');
						j2.casas[i + 1][j].setPrint('N');
						fj.cp2[i + 2][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 2][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 2][j].setEstado('N');
						j2.casas[i + 2][j].setPrint('N');
						fj.cp2[i + 3][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 3][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 3][j].setEstado('N');
						j2.casas[i + 3][j].setPrint('N');
					} else {
						fj.cp2[i - 1][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j].setEstado('N');
						j2.casas[i - 1][j].setPrint('N');
						fj.cp2[i - 2][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 2][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 2][j].setEstado('N');
						j2.casas[i - 2][j].setPrint('N');
						fj.cp2[i - 3][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 3][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 3][j].setEstado('N');
						j2.casas[i - 3][j].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.posicao = null;
				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);

				if (j2f.qtdbarcos == 0) {
					j2f.confirmar.setEnabled(true);
					j2f.confirmar.setVisible(true);
				}
			}

			else if (tipo.equals("portaaviao")
					&& casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 5;
					if (i + 4 <= 14) {
						fj.cp2[i + 1][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 1][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 1][j].setEstado('N');
						j2.casas[i + 1][j].setPrint('N');
						fj.cp2[i + 2][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 2][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 2][j].setEstado('N');
						j2.casas[i + 2][j].setPrint('N');
						fj.cp2[i + 3][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 3][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 3][j].setEstado('N');
						j2.casas[i + 3][j].setPrint('N');
						fj.cp2[i + 4][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 4][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 4][j].setEstado('N');
						j2.casas[i + 4][j].setPrint('N');
					} else {
						fj.cp2[i - 1][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j].setEstado('N');
						j2.casas[i - 1][j].setPrint('N');
						fj.cp2[i - 2][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 2][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 2][j].setEstado('N');
						j2.casas[i - 2][j].setPrint('N');
						fj.cp2[i - 3][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 3][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 3][j].setEstado('N');
						j2.casas[i - 3][j].setPrint('N');
						fj.cp2[i - 4][j].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 4][j].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 4][j].setEstado('N');
						j2.casas[i - 4][j].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.posicao = null;
				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);

				if (j2f.qtdbarcos == 0) {
					j2f.confirmar.setEnabled(true);
					j2f.confirmar.setVisible(true);
				}
			}

			if (tipo.equals("hidroaviao") && casas[i + 1][j].getEstado() != 'N'
					&& casas[i][j + 1].getEstado() != 'N'
					&& casas[i - 1][j].getEstado() != 'N'
					&& casas[i][j - 1].getEstado() != 'N') {
				try {
					fj.cp2[i][j].i = ImageIO.read(new File(
							"imagens/outros/navio.jpg"));
					fj.cp2[i][j].paintImmediately(fj.cp2[i][j].getBounds());
					j2.casas[i][j].setEstado('N');
					j2.casas[i][j].setPrint('N');
					j2.qtdbarcos += 3;

					if (j + 1 < 14) {
						fj.cp2[i + 1][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 1][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 1][j + 1].setEstado('N');
						j2.casas[i + 1][j + 1].setPrint('N');
						fj.cp2[i - 1][j + 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j + 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j + 1].setEstado('N');
						j2.casas[i - 1][j + 1].setPrint('N');
					} else {
						fj.cp2[i - 1][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i - 1][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i - 1][j - 1].setEstado('N');
						j2.casas[i - 1][j - 1].setPrint('N');
						fj.cp2[i + 1][j - 1].i = ImageIO.read(new File(
								"imagens/outros/navio.jpg"));
						fj.cp2[i + 1][j - 1].paintImmediately(fj.cp2[i][j]
								.getBounds());
						j2.casas[i + 1][j - 1].setEstado('N');
						j2.casas[i + 1][j - 1].setPrint('N');
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j2f.posicao = null;
				j2f.tipo = null;
				j2f.qtdbarcos--;
				j2f.result.setText("");
				j2f.setPos(false);

				if (j2f.qtdbarcos == 0) {
					j2f.confirmar.setEnabled(true);
					j2f.confirmar.setVisible(true);
				}
			}

		}

		else {
			System.out.println(pos + " " + Integer.toString(i) + " "
					+ Integer.toString(j));
		}
	}

}
