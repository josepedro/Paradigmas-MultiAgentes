package regrasTruco;

import java.util.ArrayList;
import java.util.List;

public class Jogadas {

	private int pontos;

	

	
	
	
	public int rodada(String jogada, int pontuacao) {
		
		

		if (jogada.equalsIgnoreCase("truco")) {
			pontos = 3;

		} else if (jogada.equalsIgnoreCase("seis")) {
			pontos = 6;

		} else if (jogada.equalsIgnoreCase("nove")) {
			pontos = 9;

		} else if (jogada.equalsIgnoreCase("doze")) {
			pontos = 12;

		} else if (jogada.equalsIgnoreCase("corre")) {
			pontos = 1;

		} else {
			pontos = 1;
		}

		return pontuacao + pontos;
	}

	public String maiorCarta (List<Cartas> cartasJogador1 , List<Cartas> cartasJogador2){
		int pontosJogador1 =0 ;
		for (int i = 0; i < cartasJogador1.size() ; i++) {
		
			if(cartasJogador1.get(i).peso > cartasJogador2.get(i).peso){
				pontosJogador1++;
			}
		}
		
		if(pontosJogador1 >=2){
			return "jogador 1 venceu a rodada";
		}else
		return "jogador 2 venceu a rodada";
	}
	public static void main(String[] args) {
		Jogadas jogada = new Jogadas();
		int pontuacao = 0;
		int totalpontos = jogada.rodada("truco", pontuacao);

		
		
		Baralho baralho = new Baralho();
		ArrayList<Cartas> monte = new ArrayList<Cartas>();
		baralho.adicionarCartas(monte);
		
		List cartasJogador1 = baralho.cartasDaMao(monte);
		System.out.println(cartasJogador1.get(0));
		System.out.println(cartasJogador1.get(1));
		System.out.println(cartasJogador1.get(2));
		
		
		totalpontos = jogada.rodada("seis", totalpontos);

		if (totalpontos >= 12) {
			System.out.println("FIM DE JOGO \n Total de pontos = "
					+ totalpontos);
		} else {
			System.out.println("Placar Parcial = " + totalpontos);
		}

	}
}