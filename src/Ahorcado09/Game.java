package Ahorcado09;

public class Game implements HangmanGame {
	private String secreta;
	private StringBuilder adivinada;

	@Override
	public void startNewGame(String word, int maxAttempts) {
		secreta = word;
		adivinada = new StringBuilder(word.length());
	}

	@Override
	public boolean guessLetter(char letter) {
		int encontrada = secreta.indexOf(letter);
		int existe = encontrada;
		if (encontrada != -1) {
			do {
				adivinada.setCharAt(encontrada, letter);
				encontrada = secreta.indexOf(encontrada, letter);
			} while (encontrada != -1);
		}
		return existe!=-1;
	}

	@Override
	public String getWordState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRemainingAttempts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGameWon() {
		// TODO Auto-generated method stub
		return false;
	}

}
