package p2cg;

public class UsuarioFactory {

	public Usuario criaUsuario(String nome, String login, int dinheiro) throws Exception {
		if(nome.equals("") || nome == null) {
			throw new Exception("Nome nao pode ser nulo ou invalido");
		}
		if(login.equals("") || login == null) {
			throw new Exception("Login nao pode ser nulo ou invalido");
		}
		if(dinheiro < 0) {
			throw new Exception("Dinheiro nao pode ser menor que zero");
		}
		return new Noob(nome, login, dinheiro, 0);
	}
}
