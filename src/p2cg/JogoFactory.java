package p2cg;

public class JogoFactory {
	
	public Jogo criajogo(String nome, int preco, String tipo) throws Exception {
		if (tipo.equals("") || tipo == null) {
			throw new Exception("Tipo do jogo nao pode ser nulo ou vazio");
		}
		if (tipo.equals("RPG")) {
			return new RPG(nome, preco, 0, 0, 0);
		} else if (tipo.equals("Luta")) {
			return new Luta(nome, preco, 0, 0, 0);
		} else if (tipo.equals("Plataforma")) {
			return new Plataforma(nome, preco, 0, 0, 0);
		}
		return null;
	}
}
