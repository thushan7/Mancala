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

    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum<1 || pitNum>12) {
            throw new PitNotFoundException();
        }
        return board.getPits().get(pitNum-1).getStoneCount();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getStoreCount(Player player) throws NoSuchPlayerException {
        if (players.get(0)!=player && players.get(1)!=player) {
            throw new NoSuchPlayerException();
        }
        return player.getStoreCount();
    }

    public Player getWinner() throws GameNotOverException {
        try {
            if (getNumStones(1)==0 && getNumStones(2)==0 && getNumStones(3)==0
               && getNumStones(4)==0 && getNumStones(5)==0 && getNumStones(6)==0
               ||
               getNumStones(7)==0 && getNumStones(8)==0 && getNumStones(9)==0
               && getNumStones(10)==0 && getNumStones(11)==0 && getNumStones(12)==0) {
                int add;
                if (getNumStones(1)==0 && getNumStones(2)==0 && getNumStones(3)==0
                    && getNumStones(4)==0 && getNumStones(5)==0 && getNumStones(6)==0) {
                    add = getNumStones(7) + getNumStones(8) + getNumStones(9)
                          + getNumStones(10) + getNumStones(11) + getNumStones(12);
                    players.get(1).getStore().addStones(add);
                } else {
                    add = getNumStones(1) + getNumStones(2) + getNumStones(3)
                          + getNumStones(4) + getNumStones(5) + getNumStones(6);
                    players.get(0).getStore().addStones(add);
                }
                if (getStoreCount(players.get(0)) > getStoreCount(players.get(1))) {
                    return players.get(0);
                } else if (getStoreCount(players.get(1)) > getStoreCount(players.get(0))) {
                    return players.get(1);
                } else {
                    return null;
                }
            }
            throw new GameNotOverException();
        } catch (PitNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchPlayerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean isGameOver() {
        try {
            if (getNumStones(1)==0 && getNumStones(2)==0 && getNumStones(3)==0
                && getNumStones(4)==0 && getNumStones(5)==0 && getNumStones(6)==0
                ||
                getNumStones(7)==0 && getNumStones(8)==0 && getNumStones(9)==0
                && getNumStones(10)==0 && getNumStones(11)==0 && getNumStones(12)==0) {
                return true;
            }
            return false;
        } catch (PitNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int move(int startPit) throws InvalidMoveException {
        if ((currentPlayer.getStore() == players.get(0).getStore() && (startPit>=7 && startPit<=12))
          || (currentPlayer.getStore() == players.get(1).getStore() && (startPit>=1 && startPit<=6))) {
            throw new InvalidMoveException();
        }
        try {
            int stopPit = startPit + getNumStones(startPit);
            if (stopPit>12) {
                stopPit -= 13;
            } else if (stopPit>6) {
                stopPit -= 7;
            }
            int newStones = board.moveStones(startPit, currentPlayer);
            if (stopPit!=0) {
                if (getNumStones(stopPit)==1) {
                    if (currentPlayer==players.get(0) && stopPit>=1 && stopPit<=6) {
                        board.captureStones(stopPit);
                    } else if (currentPlayer==players.get(1) && stopPit>=7 && stopPit<=12) {
                        board.captureStones(stopPit);
                    }
                }
            }
            if (currentPlayer==players.get(0)) {
                return getNumStones(1)+getNumStones(2)+getNumStones(3)
                       + getNumStones(4)+getNumStones(5)+getNumStones(6);
            } else {
                return getNumStones(7)+getNumStones(8)+getNumStones(9)
                       +getNumStones(10)+getNumStones(11)+getNumStones(12);
            }
        } catch (PitNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        }
        return 1;
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
        setCurrentPlayer(p2);
    }

    public String toString() {
        System.out.println(board);
        String s = "It is currently " + getCurrentPlayer().getName() + "'s turn";
        return s;
    }
}

