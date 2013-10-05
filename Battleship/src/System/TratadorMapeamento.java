package System;

import java.awt.Color;
import java.util.Observable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Graphics.FrameJogo;
import Graphics.Jogador1;
import Graphics.Jogador1Frame;
import Graphics.Jogador2;
import Graphics.Jogador2Frame;

public class TratadorMapeamento extends Observable implements MouseListener  {

	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		int ret=0;
		Jogador1 j1 = null;
		Jogador2 j2 = null;
		Jogador1Frame j1f = null;
		Jogador2Frame j2f = null;
		FrameJogo fj = null;
		
		x = (int)((x/20)-1);
		y = (int)((y/20)-1);
		j1 = j1.getInstance();
		j2 = j2.getInstance();
		fj = fj.getInstance();
		j1f = j1f.getInstance();
		j2f = j2f.getInstance();

		if (arg0.getX()>=40 && arg0.getY()>48 && arg0.getX()<=339 && arg0.getY()<348){
			ret = 1;
		}
		
		else if (arg0.getX()>=372 && arg0.getY()>48 && arg0.getX()<=672 && arg0.getY()<348) {
			ret = 2;
		}
		
		if (arg0.getX()<40 || arg0.getY()<48 || (arg0.getX()>339 && arg0.getX()<372) || arg0.getX()>672 || arg0.getY()>348){
			System.out.println("fora das coordenadas: ("+arg0.getX()+","+arg0.getY()+")");
		}
		
		/* JOGADOR 1 */
		
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()<70) {
			System.out.println("Jogador: "+ret+" | A"+x+" ("+arg0.getX()+","+arg0.getY()+")");
				if(j1f.getQtdbarcos()==0) {
					fj.executeTurn('A', x, 0, arg0.getX());
					notifyObservers();
				}
				else if (j1f.isPos()){
					j1.posicionarNavio(j1f.tipo, j1f.posicao, 0, x-1);
				}
				else {
					System.out.println("Coloque seus navios.");
					System.out.println(Integer.toString(j1f.getQtdbarcos()));
				}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=70 && arg0.getY()<90) {
			System.out.println("Jogador: "+ret+" | B"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('B', x, 1, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()){
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 1, x-1);
			}
			
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=90 && arg0.getY()<110) {
			System.out.println("Jogador: "+ret+" | C"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('C', x, 2, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()){
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 2, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=110 && arg0.getY()<130) {
			System.out.println("Jogador: "+ret+" | D"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('D', x, 3, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 3, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=130 && arg0.getY()<150) {
			System.out.println("Jogador: "+ret+" | E"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('E', x, 4, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 4, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=150 && arg0.getY()<170) {
			System.out.println("Jogador: "+ret+" | F"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('F', x, 5, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 5, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=170 && arg0.getY()<190) {
			System.out.println("Jogador: "+ret+" | G"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('G', x, 6, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 6, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=190 && arg0.getY()<210) {
			System.out.println("Jogador: "+ret+" | H"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('H', x, 7, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 7, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=210 && arg0.getY()<230) {
			System.out.println("Jogador: "+ret+" | I"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('I', x, 8, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 8, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=230 && arg0.getY()<250) {
			System.out.println("Jogador: "+ret+" | J"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('J', x, 9, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 9, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=250 && arg0.getY()<270) {
			System.out.println("Jogador: "+ret+" | K"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('K', x, 10, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 10, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=270 && arg0.getY()<290) {
			System.out.println("Jogador: "+ret+" | L"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('L', x, 11, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 11, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=290 && arg0.getY()<310) {
			System.out.println("Jogador: "+ret+" | M"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('M', x, 12, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 12, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=310 && arg0.getY()<330) {
			System.out.println("Jogador: "+ret+" | N"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('N', x, 13, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 13, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		else if (arg0.getX()>=40 && arg0.getX()<339 && arg0.getY()>=330 && arg0.getY()<350) {
			System.out.println("Jogador: "+ret+" | O"+x+" ("+arg0.getX()+","+arg0.getY()+")");
			if(j1f.getQtdbarcos()==0) {
				fj.executeTurn('O', x, 14, arg0.getX());
				notifyObservers();
			}
			else if (j1f.isPos()) {
				j1.posicionarNavio(j1f.tipo, j1f.posicao, 14, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		/* JOGADOR 2 */
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()<70) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | A"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('A', x, 0, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 0, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
				System.out.println(Integer.toString(j2f.getQtdbarcos()));
			}
		}
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=70 && arg0.getY()<90) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | B"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('B', x, 1, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 1, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=90 && arg0.getY()<110) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | C"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('C', x, 2, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 2, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=110 && arg0.getY()<130) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | D"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('D', x, 3, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 3, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=130 && arg0.getY()<150) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | E"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('E', x, 4, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 4, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=150 && arg0.getY()<170) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | F"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('F', x, 5, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 5, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=170 && arg0.getY()<190) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | G"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('G', x, 6, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 6, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=190 && arg0.getY()<210) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | H"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('H', x, 7, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 7, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=210 && arg0.getY()<230) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | I"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('I', x, 8, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 8, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=230 && arg0.getY()<250) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | J"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('J', x, 9, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 9, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=250 && arg0.getY()<270) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | K"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('K', x, 10, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 10, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=270 && arg0.getY()<290) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | L"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('L', x, 11, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 11, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=290 && arg0.getY()<310) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | M"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('M', x, 12, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 12, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=310 && arg0.getY()<330) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | N"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('N', x, 13, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 13, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else if (arg0.getX()>=372 && arg0.getX()<672 && arg0.getY()>=330 && arg0.getY()<350) {
			x = ((arg0.getX()-31)/20)-16;
			System.out.println("Jogador: "+ret+" | O"+x+" ("+arg0.getX()+","+arg0.getY()+")");	
			if(j2f.getQtdbarcos()==0) {
				fj.executeTurn('O', x, 14, arg0.getX());
				notifyObservers();
			}
			else if (j2f.isPos()) {
				j2.posicionarNavio(j2f.tipo, j2f.posicao, 14, x-1);
			}
			else {
				System.out.println("Coloque seus navios.");
			}
		}
		
		else {
			System.out.println(arg0.getX()+" "+arg0.getY());
		}
		
		fj.repaint();
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

