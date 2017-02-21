package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tests.RPG;
import tests.Veterano;

public class RPGTest {

	RPG jogo1;
	Veterano user;

	@Before
	public void start() throws Exception {
		jogo1 = new RPG("ff", 10, 0, 0, 0);
		user = new Veterano("joao", "joao.menezes", 100, 1000);
	}

	@Test
	public void testRegistraJogada() {
		try {
			user.registraJogadas(jogo1, 500000, true);
		} catch (Exception e) {
			assertEquals("Quantidade de x2p errada.", e.getMessage());
		}
	}

	@Test
	public void testRPG() {
		try {
			jogo1 = new RPG(null, 10, 0, 0, 0);
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			jogo1 = new RPG("", 10, 0, 0, 0);
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser nulo ou vazio", e.getMessage());
		}
	}
}
