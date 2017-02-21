package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tests.Plataforma;
import tests.Usuario;
import tests.Veterano;

public class UsuarioTest {

	Usuario user;
	Plataforma jogo3;
	
	@Before
	public void start() throws Exception {
	user = new Veterano("joao", "joao.menezes", 100, 1000);
	jogo3 = new Plataforma("mario", 1337, 0, 0, 0);
	}

	@Test
	public void testUsuario() {
		try {
			user = new Veterano(null, "joao.menezes", 100, 1000);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			user = new Veterano("", "joao.menezes", 100, 1000);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			user = new Veterano("joao menezes", null, 100, 1000);
		} catch (Exception e) {
			assertEquals("Login nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			user = new Veterano("joao menezes", "", 100, 1000);
		} catch (Exception e) {
			assertEquals("Login nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			user = new Veterano("joao menezes", "joao.menezes", -5, 1000);
		} catch (Exception e) {
			assertEquals("Dinheiro nao pode ser menor que zero", e.getMessage());
		}
	}
	
	@Test
	public void testSetDinheiro() {
		try {
			user.setDinheiro(-100);
		} catch (Exception e) {
			assertEquals("Dinheiro nao pode ser menor que zero", e.getMessage());		
			}
	}
	
	@Test
	public void testSetNome() {
		try {
			user.setNome("");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			user.setNome(null);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
	}

}
