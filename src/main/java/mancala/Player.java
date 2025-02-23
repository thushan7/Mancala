package mancala;

public class Player {
    private String name;
    private Store store;
    private int storeCount;

    public Player() {
        this("noname");
    }

    Player(String n) {
        this.name = n;
        store = null;
        storeCount = 0;
    }

    public String getName() {
        return name;
    }

    Store getStore() {
        return store;
    }

    int getStoreCount() {
        return store.getTotalStones();
    }

    void setName(String n) {
        name = n;
    }

    void setStore(Store s) {
        store = s;
    }

    public String toString() {
        String s = getName() + "'s store currently has " + getStoreCount() + " stones";
        return s;
    }
}
