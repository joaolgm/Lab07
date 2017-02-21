package p2cg;

/**
 * Classe responsavel por especializar o conceito de Jogo para Luta.
 * 
 * @author Joao Menezes
 *
 */
public class Luta extends Jogo {

	public Luta(String nome, int preco, int maiorScore, int qtdVezesJogadas, int qtdVezesZeradas) throws Exception {
		super(nome, preco, maiorScore, qtdVezesJogadas, qtdVezesZeradas);
	}

	/**
	 * Metodo para registrar que foi jogado e retornar a quantidade de x2p
	 * merecida.
	 * 
	 * @param jogo
	 * @param score
	 * @param zerou
	 * @throws Exception
	 */
	@Override
	public int registraJogada(Jogo jogo, int score, boolean zerou) throws Exception {
		if (score < 0) {
			throw new Exception("Score nao pode ser menor que zero");
		}
		if (score > jogo.getMaiorScore()) {
			jogo.setMaiorScore(score);
			return score / 1000;
		}
		return 0;
	}
}
