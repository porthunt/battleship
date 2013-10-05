package System;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Graphics.Jogador1Frame;
import Graphics.Jogador2Frame;
import Graphics.NavioButton;

public class TratadorGirar implements MouseListener {

	Jogador1Frame j1f = null;
	Jogador2Frame j2f = null;

	@Override
	public void mouseClicked(MouseEvent arg0) {

		j1f = j1f.getInstance();
		j2f = j2f.getInstance();

		if (arg0.getComponent().getName().equals("Girar")) {

			if (arg0.getButton() == MouseEvent.BUTTON1) {
				NavioButton nb = (NavioButton) arg0.getComponent();
				if (nb.getPlayer() == 1 && !(j1f.isPos())) {
					nb.setVisible(false);
					j1f.setPos(true);
					j1f.tipo = nb.tipo;
					j1f.posicao = nb.posicao;
					j1f.result.setBounds(80, 375, 200, 60);
					j1f.result
							.setText("<html>POSICIONE<br />SEU NAVIO.</html>");

				}

				if (nb.getPlayer() == 2 && !(j2f.isPos())) {

					nb.setVisible(false);
					j2f.setPos(true);
					j2f.tipo = nb.tipo;
					j2f.posicao = nb.posicao;
					j2f.result.setBounds(80, 375, 200, 60);
					j2f.result
							.setText("<html>POSICIONE<br />SEU NAVIO.</html>");

				}
			}
			else {
				NavioButton nb = (NavioButton) arg0.getComponent();
				// System.out.println("ok");
				giraImagem(nb, Math.PI / 2);
			}
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

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void giraImagem(NavioButton nb, double rad) {
		BufferedImage bufferedImage = nb.i;

		if (nb.posicao.equals("horizontal"))
			nb.posicao = "vertical";

		else
			nb.posicao = "horizontal";

		AffineTransform tx = new AffineTransform();
		tx.translate(0.5 * bufferedImage.getHeight(),
				0.5 * bufferedImage.getWidth());
		tx.rotate(rad);
		tx.translate(-0.5 * bufferedImage.getWidth(),
				-0.5 * bufferedImage.getHeight());
		AffineTransformOp op = new AffineTransformOp(tx,
				AffineTransformOp.TYPE_BILINEAR);
		bufferedImage = op.filter(bufferedImage, null);
		nb.i = bufferedImage;
		nb.repaint();
		nb.setBounds(nb.getX(), nb.getY(), nb.getHeight(), nb.getWidth());
	}

}
