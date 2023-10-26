package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;

    Board() {
        pits = new ArrayList<Pit>(12);
        stores = new ArrayList<Store>(2);
    }

    int captureStones(int stoppingPoint) {
        System.out.println("==captureStones==");
        int i = 0;
        return i;
    }

    int distributeStones(int startingPoint) {
        System.out.println("==distributeStones==");
        int i = 0;
        return i;
    }

    int getNumStones(int pitNum) {
        System.out.println("==getNumStones==");
        int i = 0;
        return i;
    }

    ArrayList<Pit> getPits() {
        System.out.println("==getPits==");
        ArrayList<Pit> a = new ArrayList<Pit>();
        return a;
    }

    ArrayList<Store> getStores() {
        System.out.println("==getStores==");
        ArrayList<Store> a = new ArrayList<Store>();
        return a;
    }

    void initializeBoard() {
        System.out.println("==initializeBoard==");
    }

    boolean isSideEmpty(int pitNum) {
        System.out.println("==isSideEmpty==");
        boolean b = false;
        return b;
    }

    int moveStones(int startPit, Player player) {
        System.out.println("==moveStones==");
        int i = 0;
        return i;
    }

    void registerPlayers(Player one, Player two) {
        System.out.println("==registerPlayers==");
    }

    void resetBoard() {
        System.out.println("==resetBoard==");
    }

    void setUpPits() {
        System.out.println("==setUpPits==");
    }

    void setUpStores() {
        System.out.println("==setUpStores==");
    }

    public String toString() {
        System.out.println("==toString==");
        String s = "0";
        return s;
    }
}
