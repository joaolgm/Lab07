package p2cg;

/**
 * Classe responsavel por moldar o conceito abstrato de Jogo
 * 
 * @author Joao Menezes
 */
public abstract class Jogo {
	private String nome;
	private int preco;
	private int maiorScore = 0;
	private int qtdVezesJogadas = 0;
	private int qtdVezesZeradas = 0;

	/**
	 * Metodo construtor de Jogo.
	 * 
	 * @param nome
	 * @param preco
	 * @param maiorScore
	 * @param qtdVezesJogadas
	 * @param qtdVezesZeradas
	 */

	public Jogo(String nome, int preco, int maiorScore, int qtdVezesJogadas, int qtdVezesZeradas) throws Exception {
		if (nome == null || nome.equals("")) {
			throw new Exception("Nome do jogo nao pode ser nulo ou vazio");
		}
		if (preco < 0 || maiorScore < 0 || qtdVezesJogadas < 0 || qtdVezesZeradas < 0) {
			throw new Exception("Quantidade nao pode ser menor que zero");
		}
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = maiorScore;
		this.qtdVezesJogadas = qtdVezesJogadas;
		this.qtdVezesZeradas = qtdVezesZeradas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQtdVezesJogadas() {
		return qtdVezesJogadas;
	}

	public void setQtdVezesJogadas(int qtdVezesJogadas) {
		this.qtdVezesJogadas = qtdVezesJogadas;
	}

	public int getQtdVezesZeradas() {
		return qtdVezesZeradas;
	}

	public void setQtdVezesZeradas(int qtdVezesZeradas) {
		this.qtdVezesZeradas = qtdVezesZeradas;
	}

	public int getPreco() {
		return preco;
	}

	public abstract int registraJogada(Jogo jogo, int score, boolean zerou) throws Exception;

	@Override
	public String toString() {
		return "+ " + getNome() + "- " + getClass() + ":" + System.lineSeparator() + "==> Jogou " + getQtdVezesJogadas()
				+ "vez(es)" + System.lineSeparator() + "==> Zerou " + getQtdVezesZeradas() + "vez(es)"
				+ System.lineSeparator() + "==> Maior score: " + getMaiorScore();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maiorScore;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qtdVezesJogadas;
		result = prime * result + qtdVezesZeradas;
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
		Jogo other = (Jogo) obj;
		if (maiorScore != other.maiorScore)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (qtdVezesJogadas != other.qtdVezesJogadas)
			return false;
		if (qtdVezesZeradas != other.qtdVezesZeradas)
			return false;
		return true;
	}

}
