package piedarapapeltiejeras08;

/**
 * Interfaz para el juego "Piedra, Papel o Tijeras".
 */
public interface RockPaperScissorsGame {
    
    /**
     * Inicia un nuevo juego.
     */
    void startNewGame();
    
    /**
     * El jugador humano elige una opci�n: piedra, papel o tijeras.
     * 
     * @param playerChoice La opci�n elegida por el jugador (0 para piedra, 1 para papel, 2 para tijeras)
     * @return El resultado del juego (0 para empate, 1 para victoria del jugador, -1 para victoria de la computadora)
     * @throws IllegalStateException Si el juego no se ha iniciado a�n
     */
    int playerChoose(int playerChoice);
    
    /**
     * Obtiene la opci�n elegida por la computadora.
     * 
     * @return La opci�n elegida por la computadora (0 para piedra, 1 para papel, 2 para tijeras)
     * @throws IllegalStateException Si el juego no se ha iniciado a�n
     */
    int getComputerChoice();
    
    /**
     * Comprueba si el juego ha terminado.
     * 
     * @return true si el juego ha terminado, false de lo contrario
     */
    boolean isGameFinished();
}
