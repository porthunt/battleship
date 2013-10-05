package System;

	public class Casas {
		private int CoordX, CoordY;
		private char estado;
		private char tipo;
		private char print;
		private boolean conhecido;
		
		public Casas (int x, int y, char estado, char tipo, char print) {
			CoordX = x;
			CoordY = y;
			this.estado = estado;
			this.tipo = tipo;
			this.print = print;
			this.conhecido = false;
		}

		public char getTipo() {
			return tipo;
		}

		public char getPrint() {
			return print;
		}

		public void setPrint(char print) {
			this.print = print;
		}

		public void setTipo(char tipo) {
			this.tipo = tipo;
		}



		public int getCoordX() {
			return CoordX;
		}

		public void setCoordX(int coordX) {
			CoordX = coordX;
		}

		public int getCoordY() {
			return CoordY;
		}

		public void setCoordY(int coordY) {
			CoordY = coordY;
		}


		public char getEstado() {
			return estado;
		}


		public void setEstado(char estado) {
			this.estado = estado;
		}

		public boolean isConhecido() {
			return conhecido;
		}

		public void setConhecido(boolean conhecido) {
			this.conhecido = conhecido;
		}
		
}
