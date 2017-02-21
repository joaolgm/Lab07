package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tests.Loja;
import tests.Luta;
import tests.Usuario;
import tests.Veterano;

public class LojaTest {

	Luta jogo;
	Usuario user;
	Loja loja;

	@Before
	public void start() throws Exception {
		user = new Veterano("joao", "joao.menezes", 100, 1000);
		jogo = new Luta("ff", 50000, 0, 0, 0);
	}

	@Test
	public void testAdicionaDinheiro() {
		try {
			loja.adicionaDinheiro(user, -100);
		} catch (Exception e) {
			assertEquals("Dinheiro nao pode ser menor que zero", e.getMessage());
		}
	}

	@Test
	public void testVenderJogos() {
		try {
			loja.venderJogos(jogo, user, jogo.getPreco());
		} catch (Exception e) {
			assertEquals("Quantidade de dinheiro insuficiente", e.getMessage());
		}
	}

	@Test
	public void testUpgrade() {
		try {
			loja.upgrade(user.getLogin());
		} catch (Exception e) {
			assertEquals("O usuario ainda nao atingiu 1000 pontos x2p", e.getMessage());
		}
	}

}
