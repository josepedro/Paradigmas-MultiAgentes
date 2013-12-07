package regrasTruco;


	public enum Cartas {
		DOIS(6,4), TRES(7,4), QUATRO_PAUS_ZAP(11,1), SETE_COPAS(10,1), SETE_OUROS(8,1),
		ESPADILHA(9,1), VALETE(2,4), DAMA(1,4), REI(4,4), AS(5,3);
		
		public final int peso;
		public final int quantidade;
		
		Cartas(int peso , int quantidade){
			this.peso=peso;
			this.quantidade = quantidade;
		}
	}

