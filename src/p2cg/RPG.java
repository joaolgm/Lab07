package p2cg;

/**
 * Classe responsavel por especializar o conceito de Jogo para RPG.
 * 
 * @author Joao Menezes
 *
 */
public class RPG extends Jogo {

	public RPG(String nome, int preco, int maiorScore, int qtdVezesJogadas, int qtdVezesZeradas) throws Exception {
		super(nome, preco, maiorScore, qtdVezesJogadas, qtdVezesZeradas);
	}

	/**
	 * Metodo para registrar que foi jogado e retornar a quantidade de x2p
	 * merecida.
	 * 
	 * @param jogo
	 * @param score
	 * @param zerou
	 */
	@Override
	public int registraJogada(Jogo jogo, int score, boolean zerou) {
		return 10;
	}
}
