package p2cg;

import java.util.HashSet;

/**
 * Classe responsavel por moldar o conceito abstrato de Usuario.
 * 
 * @author Joao Menezes
 *
 */
public abstract class Usuario {

	private String nome, login;
	protected int x2p;
	protected int dinheiro;
	protected HashSet<Jogo> jogosComprados;

	public Usuario(String nome, String login, int dinheiro) throws Exception {
		if (nome == null || nome.equals("")) {
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		if (login == null || login.equals("")) {
			throw new Exception("Login nao pode ser nulo ou vazio");
		}
		if (dinheiro < 0) {
			throw new Exception("Dinheiro nao pode ser menor que zero");
		}
		this.nome = nome;
		this.login = login;
		this.dinheiro = dinheiro;
	}

	/**
	 * Metodo responsavel por comprar jogo para usuario e adicionar na lista de
	 * jogos.
	 * 
	 * @param jogo
	 * @param preco
	 * @throws Exception
	 */
	public void comprarJogo(Jogo jogo, int preco) throws Exception {
		if (preco < 0) {
			throw new Exception("Preco nao pode ser menor que zero");
		}
		double newPreco = preco - jogo.getPreco();
		if (newPreco < this.dinheiro) {
			jogosComprados.add(jogo);
			dinheiro -= preco;
		}
	}

	/**
	 * Metodo responsavel por registrar a quantidade de vezes que um jogo foi
	 * jogado.
	 * 
	 * @param jogo
	 * @param score
	 * @param zerou
	 * @throws Exception
	 */
	public void registraJogadas(Jogo jogo, int score, boolean zerou) throws Exception {
		if (score < 0) {
			throw new Exception("Score nao pode ser menor que zero");
		}
		int pontos = jogo.registraJogada(jogo, score, zerou);
		setX2p(pontos);
	}

	public int getQtdJogosComprados() {
		return jogosComprados.size();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public String toString() {
		String imprime = getLogin() + System.lineSeparator() + getNome() + " - " + "Jogador" + getClass()
				+ System.lineSeparator() + "Lista de Jogos:";
		for (Jogo jogo : jogosComprados) {
			imprime += jogo.toString();
		}
		return imprime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dinheiro;
		result = prime * result + ((jogosComprados == null) ? 0 : jogosComprados.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + x2p;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (dinheiro != other.dinheiro)
			return false;
		if (jogosComprados == null) {
			if (other.jogosComprados != null)
				return false;
		} else if (!jogosComprados.equals(other.jogosComprados))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (x2p != other.x2p)
			return false;
		return true;
	}
}