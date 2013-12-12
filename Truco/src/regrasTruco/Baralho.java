package regrasTruco;

import java.util.ArrayList;
import java.util.List;

public class Baralho {

	
	public ArrayList<Cartas> adicionarCartas(ArrayList<Cartas> baralho) {

		baralho.add(Cartas.AS);
		baralho.add(Cartas.ESPADILHA);
		baralho.add(Cartas.DOIS);
		baralho.add(Cartas.TRES);
		baralho.add(Cartas.QUATRO_PAUS_ZAP);
		baralho.add(Cartas.SETE_COPAS);
		baralho.add(Cartas.SETE_OUROS);
		baralho.add(Cartas.VALETE);
		baralho.add(Cartas.DAMA);
		baralho.add(Cartas.REI);
		
			return baralho;	 

	}



	public List<Cartas> cartasDaMao(ArrayList<Cartas> monte){
		
		ArrayList<Cartas> mao = new ArrayList<Cartas>();
		
		Baralho baralho = new Baralho();
		baralho.adicionarCartas(monte);
		
		int numeroAleatorio1 = (int) (Math.random() * 9); 
		int numeroAleatorio2 = (int) (Math.random() * 9); 
		int numeroAleatorio3 = (int) (Math.random() * 9); 
		
		//adicionando 3 cartas a mão
		
		mao.add(monte.get(numeroAleatorio1));
		
		mao.add(monte.get(numeroAleatorio2));
		mao.add(monte.get(numeroAleatorio3));
		
		return mao;
	}
		public static void main(String[] args) {

			
		Baralho baralho = new Baralho();
		ArrayList<Cartas> mao = new ArrayList<Cartas>();
		
		mao = baralho.adicionarCartas(mao);
			
		}
}





