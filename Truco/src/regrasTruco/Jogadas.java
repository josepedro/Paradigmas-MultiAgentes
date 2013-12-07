package regrasTruco;

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
		
		return pontuacao+pontos;
	}

	public static void main(String[] args) {
		Jogadas jogada = new Jogadas();
		int pontuacao = 0;
		int totalpontos = jogada.rodada("truco", pontuacao);
		
		
		totalpontos = jogada.rodada("seis", totalpontos);
		
		
		if (totalpontos >= 12){
			System.out.println("FIM DE JOGO \n Total de pontos = "+totalpontos);
		}else{
		   System.out.println("Placar Parcial = "+totalpontos);
	   }

}
}