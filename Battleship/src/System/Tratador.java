package System;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Graphics.FrameJogo;
import Graphics.FrameMenu;
import Graphics.Jogador1;
import Graphics.Jogador1Frame;
import Graphics.Jogador2;
import Graphics.Jogador2Frame;

 public class Tratador implements MouseListener {
	 
	 int i, j;
	 Jogador1Frame j1f = null;
	 Jogador2Frame j2f = null;
	 Jogador1 j1 = null;
	 Jogador2 j2 = null;
	 File sg1 = new File("SaveGame1.txt");
	 File sg2 = new File("SaveGame2.txt");
		
		public void mouseClicked(MouseEvent arg0) {
			
			FrameJogo fj = null;
		
			if (arg0.getComponent().getName().equals("NovoJogo")) {
				
				sg1.delete();
				sg2.delete();
					
				JFrame zz = (JFrame) arg0.getComponent().getParent().getParent()
						.getParent().getParent();
				zz.dispose();
				fj = fj.getInstance();
				fj.hideMap(2);
				j1f = j1f.getInstance();
				j2f = j2f.getInstance();

				//f.delete();
				//f2.delete();
			}
			
			else if (arg0.getComponent().getName().equals("CarregarJogo")) {
				Scanner sc;
				Scanner sc2;
				Jogador1Frame j1f = null;
				Jogador2Frame j2f = null;
				
				try {
					j1f = j1f.getInstance();
					j2f = j2f.getInstance();
					sc = new Scanner(sg1);
					sc2 = new Scanner(sg2);
					
					JFrame zz = (JFrame) arg0.getComponent().getParent().getParent()
							.getParent().getParent();
					zz.dispose();
					fj = fj.getInstance();
					j1f.dispose();
					j2f.dispose();
					j1f.setQtdbarcos(0);
					j2f.setQtdbarcos(0);
					fj.hideMap(2);
					
				} catch(FileNotFoundException e) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,
						    "Não há jogo salvo.",
						    "",
						    JOptionPane.WARNING_MESSAGE);
				}
			
			}
			
			else if (arg0.getComponent().getName().equals("Sair")) {
				JFrame zz = (JFrame) arg0.getComponent().getParent().getParent()
						.getParent().getParent();
				zz.dispose();
				System.exit(0);
			}
			
			else if (arg0.getComponent().getName().equals("SaveGame")) {
				j1 = j1.getInstance();
				j2 = j2.getInstance();
				j1.SaveGame();
				j2.SaveGame();
				
				JFrame frame = new JFrame();
				
				JOptionPane.showMessageDialog(frame,
					    "Seu jogo foi salvo.",
					    "",
					    JOptionPane.INFORMATION_MESSAGE);
				
			}

			else if (arg0.getComponent().getName().equals("Confirmar")) {
				
				JFrame zz = (JFrame) arg0.getComponent().getParent().getParent()
						.getParent().getParent();
				
				zz.dispose();
				fj = fj.getInstance();
				j1f = j1f.getInstance();
				j2f = j2f.getInstance();
				j1 = j1.getInstance();
				j2 = j2.getInstance();
				
				fj.hideMap(1);
				fj.showMap(2);
				
				j1f.setQtdbarcos(0);
				j2f.setVisible(true);
				j1f.setPos(false);	
			}
			
			else if (arg0.getComponent().getName().equals("Confirmar2")) {
				
				JFrame zz = (JFrame) arg0.getComponent().getParent().getParent()
						.getParent().getParent();
				
				zz.dispose();
				fj = fj.getInstance();
				j1f = j1f.getInstance();
				j2f = j2f.getInstance();
				j1 = j1.getInstance();
				j2 = j2.getInstance();
				
				fj.hideMap(2);
				fj.showMap(1);
				
				j2f.setQtdbarcos(0);
				j2f.setPos(false);
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
