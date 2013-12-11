package regrasTruco;

import java.util.ArrayList;

public class Jogador1 {

	Baralho baralho = new Baralho();
	ArrayList<Cartas> monte = new ArrayList<Cartas>();

	public void adicionar() {
		baralho.adicionarCartas(monte);

	}

	public Cartas comprarCarta1() {
		return baralho.cartasDaMao(monte).get(0);
	}

	public Cartas comprarCarta2() {
		return baralho.cartasDaMao(monte).get(0);
	}

	public Cartas comprarCarta3() {
		return baralho.cartasDaMao(monte).get(0);
	}

	// testando se a funcionaliadde de comprar cartas esta funcionando
	public static void main(String[] args) {
		Jogador1 iniciante = new Jogador1();
		Cartas carta1 = iniciante.comprarCarta1();
		String jogada;

		int pontuacaoTotal = 0;
		
		if (carta1.name().equalsIgnoreCase("QUATRO_PAUS_ZAP")
				|| carta1.name().equalsIgnoreCase("SETE_COPAS")
				|| carta1.name().equalsIgnoreCase("ESPADILHA")) {
			jogada = "truco";

		} else {

			jogada = "corre";
		}

		System.out.println(carta1.name());
		System.out.println(jogada);
		
		Jogadas partida = new Jogadas();
		pontuacaoTotal = partida.rodada(jogada, pontuacaoTotal);
		System.out.println("Total de pontos " + pontuacaoTotal);

	}
}
