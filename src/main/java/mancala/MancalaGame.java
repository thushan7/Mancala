package mancala;

import java.util.ArrayList;
import java.util.Scanner;

public class MancalaGame {
    private Board board;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Scanner input;

    public MancalaGame() {
        board = null;
        players = new ArrayList<Player>();
        currentPlayer = null;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        if (currentPlayer == players.get(0)) {
            setCurrentPlayer(players.get(1));
        } else {
            setCurrentPlayer(players.get(0));
        }
        return currentPlayer;
    }

    public int getNumStones(int pitNum) {
        return board.getPits().get(pitNum-1).getStoneCount();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getStoreCount(Player player) {
        return player.getStoreCount();
    }

    public Player getWinner() {
        if (getStoreCount(players.get(0)) > getStoreCount(players.get(1))) {
            return players.get(0);
        } else if (getStoreCount(players.get(1)) > getStoreCount(players.get(0))) {
            return players.get(1);
        } else {
            return null;
        }
    }

    public boolean isGameOver() {
        if (getNumStones(1)==0 && getNumStones(2)==0 && getNumStones(3)==0
            && getNumStones(4)==0 && getNumStones(5)==0 && getNumStones(6)==0
            ||
            getNumStones(7)==0 && getNumStones(8)==0 && getNumStones(9)==0
            && getNumStones(10)==0 && getNumStones(11)==0 && getNumStones(12)==0) {
            return true;
        }
        return false;
    }

    public int move(int startPit) {
        int stopPit = startPit + getNumStones(startPit);
        int newStones = board.moveStones(startPit, currentPlayer);
        stopPit -= newStones;
        if (getNumStones(stopPit)==1) {
            if (currentPlayer==players.get(0) && stopPit>=1 && stopPit<=6) {
                board.captureStones(stopPit);
            } else if (currentPlayer==players.get(1) && stopPit>=7 && stopPit<=12) {
                board.captureStones(stopPit);
            }
        }
        if (currentPlayer==players.get(0)) {
            return getNumStones(1)+getNumStones(2)+getNumStones(3)
                   + getNumStones(4)+getNumStones(5)+getNumStones(6);
        } else {
            return getNumStones(7)+getNumStones(8)+getNumStones(9)
                   +getNumStones(10)+getNumStones(11)+getNumStones(12);
        }
    }

    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players.add(onePlayer);
        players.add(twoPlayer);
    }

    public void startNewGame() {
        input = new Scanner(System.in);
        board = new Board();
        board.initializeBoard();
        System.out.print("Enter Player 1 Name: ");
        String name1 = input.next();
        Player p1 = new Player(name1);
        System.out.print("Enter Player 2 Name: ");
        String name2 = input.next();
        Player p2 = new Player(name2);
        setPlayers(p1, p2);
        board.registerPlayers(p1, p2);
        setCurrentPlayer(p1);
    }

    public String toString() {
        System.out.println(board);
        String s = "It is currently " + getCurrentPlayer().getName() + "'s turn";
        return s;
    }
}

