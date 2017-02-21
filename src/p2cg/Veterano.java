package p2cg;

/**
 * Classe responsavel por especializar o conceito de Usuario para Veterano.
 * 
 * @author Joao Menezes
 *
 */
public class Veterano extends Usuario {

	public Veterano(String nome, String login, int dinheiro, int x2p) throws Exception {
		super(nome, login, dinheiro);
		this.x2p = 1000;
	}

	@Override
	public void comprarJogo(Jogo jogo, int preco) throws Exception {
		if (preco < 0) {
			throw new Exception("Preco nao pode ser menor que zero");
		}
		double newPreco = preco - 1 / 5;
		if (newPreco < this.dinheiro) {
			jogosComprados.add(jogo);
			dinheiro -= preco;
		}
	}

	/**
	 * Metodo responsavel por calcular a quantidade de x2p por jogo comprado.
	 * 
	 * @param jogo
	 */
	public void x2pPorJogo(Jogo jogo) {
		this.x2p += (15 * jogo.getPreco());
	}
}
