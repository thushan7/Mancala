package mancala;

public class Player {
    private String name;
    private Store store;
    private int storeCount;

    Player() {
        this("noname");
    }

    Player(String n) {
        this.name = name;
        store = null;
        storeCount = 0;
    }

    String getName() {
        System.out.println("==getName==");
        String s = "0";
        return s;
    }

    Store getStore() {
        System.out.println("==getStore==");
        Store s = new Store();
        return s;
    }

    int getStoreCount() {
        System.out.println("==getStoreCount==");
        int i = 0;
        return i;
    }

    void setName(String n) {
        System.out.println("==setName==");
    }

    void setStore(Store s) {
        System.out.println("==setStore==");
    }

    public String toString() {
        System.out.println("==toString==");
        String s = "0";
        return s;
    }
}
