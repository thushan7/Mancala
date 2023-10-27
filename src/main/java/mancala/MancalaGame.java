package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private ArrayList<Player> players;

    public MancalaGame() {
        board = null;
        players = new ArrayList<Player>();
    }

    public Board getBoard() {
        return board;
    }
//
    public Player getCurrentPlayer() {
    }

    public int getNumStones(int pitNum) {
        return board.pits[pitNum-1].getStoneCount();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getStoreCount(Player player) {
        return player.getStoreCount();
    }
//
    public Player getWinner() {
    }
//
    public boolean isGameOver() {
    }
//
    public int move(int startPit) {
    }

    public void setBoard(Board theBoard) {
        board = theBoard;
    }
//
    public void setCurrentPlayer(Player player) {
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players.add(onePlayer);
        players.add(twoPlayer);
    }
//
    public void startNewGame() {
    }
//
    public String toString() {
    }
}
