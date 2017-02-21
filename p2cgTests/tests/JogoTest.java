package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tests.Jogo;
import tests.Plataforma;

public class JogoTest {

	Jogo jogo;

	@Before
	public void start() throws Exception {
		jogo = new Plataforma("mario", 1337, 0, 0, 0);
	}

	@Test
	public void testSetNome() {
		try {
			jogo.setNome("");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			jogo.setNome(null);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
	}

	@Test
	public void testSetMaiorScore() {
		try {
			jogo.setMaiorScore(-20);
		} catch (Exception e) {
			assertEquals("Quantidade nao pode ser menor que zero", e.getMessage());
		}
	}

	@Test
	public void testSetQtdVezesJogadas() {
		try {
			jogo.setMaiorScore(-50);
		} catch (Exception e) {
			assertEquals("Quantidade nao pode ser menor que zero", e.getMessage());
		}
	}

	@Test
	public void testSetQtdVezesZeradas() {
		try {
			jogo.setQtdVezesZeradas(-1);
		} catch (Exception e) {
			assertEquals("Quantidade nao pode ser menor que zero", e.getMessage());
		}
	}

}
