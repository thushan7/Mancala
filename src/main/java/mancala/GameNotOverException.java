package mancala;

public class GameNotOverException extends Exception {
    public GameNotOverException() {
        super("Game not over");
    }
}
