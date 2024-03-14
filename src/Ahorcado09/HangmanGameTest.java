package Ahorcado09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanGameTest {
	HangmanGame game;
	String secret;
	int attemps;

	@BeforeEach
	void setUp() throws Exception {
		game=new Game();
		secret="hola";
		attemps=5;
		game.startNewGame(secret,attemps);
	}

	
	@Test
	void testGuessLetter() {
		assertTrue(game.guessLetter('h'));
		assertFalse(game.guessLetter('n'));
	}

	@Test
	void testGetWordState() {
		game.guessLetter('h');
		assertEquals(game.getWordState(),"h   ");
		game.guessLetter('n');
		assertEquals(game.getWordState(),"h   ");
		game.guessLetter('l');
		assertEquals(game.getWordState(),"h l ");
	}

	@Test
	void testGetRemainingAttempts() {
		game.guessLetter('n');
		assertEquals(game.getRemainingAttempts(),--attemps);
		game.guessLetter('h');
		assertEquals(game.getRemainingAttempts(),attemps);
		game.guessLetter('n');
		assertEquals(game.getRemainingAttempts(),--attemps);
	}

	@Test
	void testIsGameOverGanado() {
		game.guessLetter('h');
		game.guessLetter('o');
		game.guessLetter('n');
		game.guessLetter('n');
		game.guessLetter('l');
		game.guessLetter('a');
		assertTrue(game.isGameOver());
	}
	@Test
	void testIsGameOverPerdido() {
		game.guessLetter('n');
		assertFalse(game.isGameOver());
		game.guessLetter('n');
		game.guessLetter('n');
		game.guessLetter('n');
		game.guessLetter('n');
		assertTrue(game.isGameOver());
	}

	@Test
	void testIsGameWon() {
		game.guessLetter('h');
		assertFalse(game.isGameWon());
		game.guessLetter('o');
		assertFalse(game.isGameWon());
		game.guessLetter('n');
		game.guessLetter('n');
		assertFalse(game.isGameWon());
		game.guessLetter('l');
		game.guessLetter('a');
		assertTrue(game.isGameWon());
	}

}
