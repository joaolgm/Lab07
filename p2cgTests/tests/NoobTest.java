package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tests.Noob;
import tests.Plataforma;

public class NoobTest {

	Noob user;
	Plataforma jogo3;

	@Before
	public void start() throws Exception {
		user = new Noob("joao", "joao.menezes", 100, 1000);
		jogo3 = new Plataforma("mario", 1337, 0, 0, 0);
	}

	@Test
	public void testNoob() {
		try {
			new Noob(null, "joao.menezes", 100, 0);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			new Noob("", "joao.menezes", 100, 0);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			new Noob("joao", null, 100, 0);
		} catch (Exception e) {
			assertEquals("Login nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			new Noob("joao", "", 100, 0);
		} catch (Exception e) {
			assertEquals("Login nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			new Noob("joao", "joao.menezes", -5, 0);
		} catch (Exception e) {
			assertEquals("Dinheiro nao pode ser menor que zero", e.getMessage());
		}
	}

}
