package Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import System.Tratador;
import System.TratadorGirar;

public class Jogador2Frame extends JFrame {

private static final Jogador2Frame INSTANCE = new Jogador2Frame();

public JLabel result;
public JButton confirmar;
public NavioButton encouracado1;
public NavioButton encouracado2;
public NavioButton portaaviao1;
public NavioButton portaaviao2;
public NavioButton cruzador1;
public NavioButton cruzador2;
public NavioButton cruzador3;
public NavioButton sub1;
public NavioButton sub2;
public NavioButton sub3;
public NavioButton sub4;
public NavioButton hidroaviao1;
public NavioButton hidroaviao2;
public NavioButton hidroaviao3;
public NavioButton hidroaviao4;
public NavioButton hidroaviao5;
TratadorGirar tg = new TratadorGirar();
Tratador tt = new Tratador();
boolean pos;
int qtdbarcos;
public String tipo;
public String posicao;
	
	private Jogador2Frame() {
		setVisible(false);
		setBounds(1000, 130, 250, 500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pos = false;
		
		JLabel jogName = new JLabel("Navios:");
		jogName.setVisible(true);
		jogName.setBounds(100, 20, 70, 30);
		
		qtdbarcos=15;
		
		result = new JLabel("");
		result.setVisible(true);
		result.setBounds(70, 400, 70, 30);
		
		encouracado1 = new NavioButton("imagens/posicionamento/encouracado.jpg");
		encouracado1.setName("Girar");
		encouracado1.tipo="encouracado";
		encouracado1.setVisible(true);
		encouracado1.setBounds(30, 60, 80, 20);
		encouracado1.setPlayer(2);
		encouracado1.addMouseListener(tg);
		
		encouracado2 = new NavioButton("imagens/posicionamento/encouracado.jpg");
		encouracado2.setName("Girar");
		encouracado2.tipo="encouracado";
		encouracado2.setVisible(true);
		encouracado2.setBounds(140, 60, 80, 20);
		encouracado2.setPlayer(2);
		encouracado2.addMouseListener(tg);
		
		portaaviao1 = new NavioButton("imagens/posicionamento/portaaviao.jpg");
		portaaviao1.setName("Girar");
		portaaviao1.tipo="portaaviao";
		portaaviao1.setVisible(true);
		portaaviao1.setBounds(10, 150, 110, 20);
		portaaviao1.setPlayer(2);
		portaaviao1.addMouseListener(tg);
		
		cruzador1 = new NavioButton("imagens/posicionamento/cruzador.jpg");
		cruzador1.setName("Girar");
		cruzador1.tipo="cruzador";
		cruzador1.setVisible(true);
		cruzador1.setBounds(130, 150, 40, 20);
		cruzador1.setPlayer(2);
		cruzador1.addMouseListener(tg);
		
		cruzador2 = new NavioButton("imagens/posicionamento/cruzador.jpg");
		cruzador2.setName("Girar");
		cruzador2.tipo="cruzador";
		cruzador2.setVisible(true);
		cruzador2.setBounds(180, 150, 40, 20);
		cruzador2.setPlayer(2);
		cruzador2.addMouseListener(tg);
		
		cruzador3 = new NavioButton("imagens/posicionamento/cruzador.jpg");
		cruzador3.setName("Girar");
		cruzador3.tipo="cruzador";
		cruzador3.setVisible(true);
		cruzador3.setBounds(130, 200, 40, 20);
		cruzador3.setPlayer(2);
		cruzador3.addMouseListener(tg);
		
		sub1 = new NavioButton("imagens/posicionamento/submarino.jpg");
		sub1.setName("Girar");
		sub1.tipo="submarino";
		sub1.setVisible(true);
		sub1.setBounds(180, 200, 20, 20);
		sub1.setPlayer(2);
		sub1.addMouseListener(tg);
		
		sub2 = new NavioButton("imagens/posicionamento/submarino.jpg");
		sub2.setName("Girar");
		sub2.tipo="submarino";
		sub2.setVisible(true);
		sub2.setBounds(201, 200, 20, 20);
		sub2.setPlayer(2);
		sub2.addMouseListener(tg);
		
		sub3 = new NavioButton("imagens/posicionamento/submarino.jpg");
		sub3.setName("Girar");
		sub3.tipo="submarino";
		sub3.setVisible(true);
		sub3.setBounds(180, 221, 20, 20);
		sub3.setPlayer(2);
		sub3.addMouseListener(tg);
		
		sub4 = new NavioButton("imagens/posicionamento/submarino.jpg");
		sub4.setName("Girar");
		sub4.tipo="submarino";
		sub4.setVisible(true);
		sub4.setBounds(201, 221, 20, 20);
		sub4.setPlayer(2);
		sub4.addMouseListener(tg);
		
		hidroaviao1 = new NavioButton("imagens/posicionamento/hidroaviao.jpg");
		hidroaviao1.setName("Girar");
		hidroaviao1.tipo="hidroaviao";
		hidroaviao1.setVisible(true);
		hidroaviao1.setBounds(20, 265, 60, 40);
		hidroaviao1.setPlayer(2);
		hidroaviao1.addMouseListener(tg);
		
		hidroaviao2 = new NavioButton("imagens/posicionamento/hidroaviao.jpg");
		hidroaviao2.setName("Girar");
		hidroaviao2.tipo="hidroaviao";
		hidroaviao2.setVisible(true);
		hidroaviao2.setBounds(90, 265, 60, 40);
		hidroaviao2.setPlayer(2);
		hidroaviao2.addMouseListener(tg);

		hidroaviao3 = new NavioButton("imagens/posicionamento/hidroaviao.jpg");
		hidroaviao3.setName("Girar");
		hidroaviao3.tipo="hidroaviao";
		hidroaviao3.setVisible(true);
		hidroaviao3.setBounds(160, 265, 60, 40);
		hidroaviao3.setPlayer(2);
		hidroaviao3.addMouseListener(tg);
		
		hidroaviao4 = new NavioButton("imagens/posicionamento/hidroaviao.jpg");
		hidroaviao4.setName("Girar");
		hidroaviao4.tipo="hidroaviao";
		hidroaviao4.setVisible(true);
		hidroaviao4.setBounds(50, 325, 60, 40);
		hidroaviao4.setPlayer(2);
		hidroaviao4.addMouseListener(tg);
		
		hidroaviao5 = new NavioButton("imagens/posicionamento/hidroaviao.jpg");
		hidroaviao5.setName("Girar");
		hidroaviao5.tipo="hidroaviao";
		hidroaviao5.setVisible(true);
		hidroaviao5.setBounds(120, 325, 60, 40);
		hidroaviao5.setPlayer(2);
		hidroaviao5.addMouseListener(tg);
		
		confirmar = new JButton ("Confirmar");
		confirmar.setName("Confirmar2");
		confirmar.setVisible(true);
		confirmar.setEnabled(true);
		confirmar.setBounds(70, 430, 90, 30);
		confirmar.addMouseListener(tt);
		
		this.add(confirmar);
		this.add(hidroaviao5);
		this.add(hidroaviao4);
		this.add(hidroaviao3);
		this.add(hidroaviao2);
		this.add(hidroaviao1);
		this.add(sub4);
		this.add(sub3);
		this.add(sub2);
		this.add(sub1);
		this.add(cruzador3);
		this.add(cruzador2);
		this.add(cruzador1);
		this.add(portaaviao1);
		this.add(encouracado2);
		this.add(encouracado1);
		this.add(jogName);
		this.add(result);
	}
	
	public static synchronized Jogador2Frame getInstance() {
		return INSTANCE;
	}

	public int getQtdbarcos() {
		return qtdbarcos;
	}

	public void setQtdbarcos(int qtdbarcos) {
		this.qtdbarcos = qtdbarcos;
	}
	
	public boolean isPos() {
		return pos;
	}

	public void setPos(boolean pos) {
		this.pos = pos;
	}


}
