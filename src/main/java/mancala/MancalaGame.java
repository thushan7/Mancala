package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private ArrayList<Player> players;

    public MancalaGame() {
        System.out.println("==MancalaGame==");
    }

    public Board getBoard() {
        System.out.println("==getBoard==");
        Board b = new Board();
        return b;
    }

    public Player getCurrentPlayer() {
        System.out.println("==getCurrentPlayer==");
        Player p = new Player();
        return p;
    }

    public int getNumStones(int pitNum) {
        System.out.println("==getNumStones==");
        int i = 0;
        return i;
    }

    public ArrayList<Player> getPlayers() {
        System.out.println("==getPlayers==");
        ArrayList<Player> a = new ArrayList<Player>();
        return a;
    }

    public int getStoreCount(Player player) {
        System.out.println("==getStoreCount==");
        int i = 0;
        return i;
    }

    public Player getWinner() {
        System.out.println("==getWinner==");
        Player p = new Player();
        return p;
    }

    public boolean isGameOver() {
        System.out.println("==isGameOver==");
        boolean b = false;
        return b;
    }

    public int move(int startPit) {
        System.out.println("==move==");
        int i = 0;
        return i;
    }

    public void setBoard(Board theBoard) {
        System.out.println("==setBoard==");
    }

    public void setCurrentPlayer(Player player) {
        System.out.println("==setCurrentPlayer==");
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        System.out.println("==setPlayers==");
    }

    public void startNewGame() {
        System.out.println("==startNewGame==");
    }

    public String toString() {
        System.out.println("==toString==");
        String s = "0";
        return s;
    }
}
