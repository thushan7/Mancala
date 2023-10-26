package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;

    Board() {
        pits = new ArrayList<Pit>();
        stores = new ArrayList<Store>();
    }

    int captureStones(int stoppingPoint) {
        int stones = pits[13-stoppingPoint].removeStones();
        if (stoppingPoint>=1 && stoppingPoint<=6) {
            stores[0].addStones(stones);
        }
        else if (stoppingPoint>=7 && stoppingPoint<=12) {
            stores[1].addStones(stones);
        }
        return stones;
    }

    int distributeStones(int startingPoint) {
        int stones = pits[startingPoint].removeStones();
        int pit = startingPoint;
        for (int i=0; i<stones; i++) {
            if (pit==6 && startingPoint>=1 && startingPoint<=6) {
                stores[0].addStones(1);
                if (stones-i>1) {
                    pit++;
                    pits[pit].addStone();
                    i++;
                }
            }
            else if (pit==12 && startingPoint>=7 && startingPoint<=12) {
                stores[1].addStones(1);
                if (stones-i>1) {
                    pit++;
                    pits[pit].addStone();
                    i++;
                }
            }
            else {
                pit++;
                pits[pit].addStone();
            }
        }
        return stones;
    }

    int getNumStones(int pitNum) {
        return pits[pitNum].getStoneCount();
    }

    ArrayList<Pit> getPits() {
        return pits;
    }

    ArrayList<Store> getStores() {
        return stores;
    }

    void initializeBoard() {
        setUpPits();
        setUpStores();
        for (Pit p : pits) {
            for (int i=0; i<4; i++) {
                p.addStone();
            }
        }
    }

    boolean isSideEmpty(int pitNum) {
        boolean empty = true;
        if (pitNum>=1 && pitNum<=6) {
            for (int i=0; i<6; i++) {
                if (pits[i].getStoneCount() != 0) {
                    empty = false;
                }
            }
        }
        else if (pitNum>=7 && pitNum<=12) {
            for (int i=6; i<12; i++) {
                if (pits[i].getStoneCount() != 0) {
                    empty = false;
                }
            }
        }
        return empty;
    }
//
    int moveStones(int startPit, Player player) {
    }

    void registerPlayers(Player one, Player two) {
        stores[0].setOwner(one);
        one.setStore(stores[0]);
        stores[1].setOwner(two);
        two.setStore(stores[1]);
    }

    void resetBoard() {
        for (Store s : stores) {
            s.emptyStore();
        }
        for (Pit p : pits) {
            for (int i=0; i<4; i++) {
                p.addStone();
            }
        }
    }

    void setUpPits() {
        for (int i=0; i<12; i++) {
             Pit p = new Pit();
             pits.add(p);
        }
    }

    void setUpStores() {
        for (int i=0; i<2; i++) {
             Store s = new Store();
             stores.add(s);
         }
    }
//
    public String toString() {
    }
}
