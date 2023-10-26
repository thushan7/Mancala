package mancala;

public class Store {
    private int numStones;
    private Player owner;

    Store() {
        numStones = 0;
        owner = null;
    }

    void addStones(int amount) {
        System.out.println("==addStones==");
    }

    int emptyStore() {
        System.out.println("==emptyStore==");
        int i = 0;
        return i;
    }

    Player getOwner() {
        System.out.println("==getOwner==");
        Player p = new Player();
        return p;
    }

    int getTotalStones() {
        System.out.println("==getTotalStones==");
        int i = 0;
        return i;
    }

    void setOwner(Player player) {
        System.out.println("==setOwner==");
    }

    public String toString() {
        System.out.println("==toString==");
        return "0";
    }
}
