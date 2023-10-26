package mancala;

public class Pit {
    private int numStones;

    Pit() {
        numStones = 0;
    }

    void addStone() {
        numStones++;
    }

    int getStoneCount() {
        return numStones;
    }

    int removeStones() {
        int i = numStones;
        numStones = 0;
        return i;
    }

    public String toString() {
        String s = getStoneCount() + " stones";
        return s;
    }
}
