package mancala;

public class Store {
    private int numStones;
    private Player owner;

    Store() {
        numStones = 0;
        owner = null;
    }

    void addStones(int amount) {
        numStones += amount;
    }

    int emptyStore() {
        int i = numStones;
        numStones = 0;
        return i;
    }

    Player getOwner() {
        return owner;
    }

    int getTotalStones() {
        return numStones;
    }

    void setOwner(Player player) {
        owner = player;
    }

    public String toString() {
        String s = owner.getName() + "'s store has " + getTotalStones() + " stones";
        return s;
    }
}
