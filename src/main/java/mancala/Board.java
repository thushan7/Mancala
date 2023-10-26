package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;

    Board() {
        pits = new ArrayList<Pit>();
        stores = new ArrayList<Store>();
    }
//
    int captureStones(int stoppingPoint) {
        System.out.println("==captureStones==");
        int i = 0;
        return i;
    }
//
    int distributeStones(int startingPoint) {
        System.out.println("==distributeStones==");
        int i = 0;
        return i;
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
        System.out.println("==moveStones==");
        int i = 0;
        return i;
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
        System.out.println("==toString==");
        String s = "0";
        return s;
    }
}
