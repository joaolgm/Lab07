package p2cg;

public class JogoFactory {

	public Jogo criajogo(String nome, int preco, String tipo) throws Exception {
		if (tipo.equals("") || tipo == null) {
			throw new Exception("Tipo do jogo nao pode ser nulo ou vazio");
		}
		if (tipo.equals("RPG")) {
			RPG jogo = new RPG(nome, preco, 0, 0, 0);
			return jogo;
		} else if (tipo.equals("Luta")) {
			Luta jogo = new Luta(nome, preco, 0, 0, 0);
			return jogo;
		} else if (tipo.equals("Plataforma")) {
			Plataforma jogo = new Plataforma(nome, preco, 0, 0, 0);
			return jogo;
		}
		return null;
	}
}
