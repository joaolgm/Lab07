package p2cg;

import java.util.HashSet;

public enum Jogabilidade {
	
	ONLINE ("Online"),
	OFFLINE ("Offline"),
	MULTIPLAYER ("Multiplayer"),
	COOPERATIVO ("Cooperativo"),
	COMPETITIVO ("Competitivo");
		
	private final String jogabilidade;
	
	Jogabilidade(String jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	HashSet<Jogabilidade> estilosDeJogo = new HashSet<>();
}
