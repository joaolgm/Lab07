package p2cg;

import java.util.HashMap;

/**
 * Classe responsavel pela simbolizacao da Loja
 * 
 * @author Joao Menezes
 */

public class LojaController {
	private HashMap<String, Usuario> usuarios;

	/**
	 * Metodo para adicionar usuarios na loja utilizando o objeto usuario.
	 * 
	 * @param usuario
	 */
	public void adicionaUsuario(Usuario usuario) {
		usuarios.put(usuario.getLogin(), usuario);
	}

	/**
	 * Metodo para adicionar dinheiro na conta de certo usuario.
	 * 
	 * @param usuario
	 * @param dinheiro
	 * @throws Exception
	 */
	public void adicionaDinheiro(Usuario usuario, int dinheiro) throws Exception {
		try {
			if (usuarios.containsKey(usuario.getLogin())) {
				usuario.setDinheiro(dinheiro);
			}
		} catch (Exception e) {
			System.out.println("Dinheiro nao pode ser menor que zero");
		}
	}

	/**
	 * Metodo para vender jogos para algum usuario.
	 * 
	 * @param jogo
	 * @param usuario
	 * @param preco
	 * @throws Exception
	 */
	public void venderJogos(String jogo, String login, int preco) throws Exception {
		try {
			if (usuarios.containsKey(login)) {
				Usuario usuario = usuarios.get(login);
				Jogo jogo = cria
				if (usuario.getDinheiro() >= preco) {
					usuario.setDinheiro((usuario.getDinheiro() - preco));
					usuario.jogosComprados.add(jogo);
				}
			}
		} catch (Exception e) {
			System.out.println("Quantidade de dinheiro insuficiente");
		}
	}

	/**
	 * Metodo para dar upgrade para "veterano" em contas de usuarios.
	 * 
	 * @param login
	 * @throws Exception
	 */
	public void upgrade(String login) throws Exception {
		try {
			for (String username : usuarios.keySet()) {
				if (usuarios.get(username).getX2p() >= 1000) {
					Veterano user = new Veterano(usuarios.get(username).getNome(), login,
							usuarios.get(username).getDinheiro(), usuarios.get(username).getX2p());
					usuarios.remove(username);
					usuarios.put(login, user);
				}
			}
		} catch (Exception e) {
			System.out.println("O usuario ainda nao atingiu 1000 pontos x2p");
		}
	}

	@Override
	public String toString() {
		String imprime = "=== Central P2-CG ===";
		for (String username : usuarios.keySet()) {
			imprime += usuarios.get(username).toString();
		}
		imprime += "--------------------------------------------";
		return imprime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		LojaController other = (LojaController) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

}
