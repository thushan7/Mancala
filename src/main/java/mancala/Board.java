package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;

    public Board() {
        pits = new ArrayList<Pit>();
        stores = new ArrayList<Store>();
    }

    public int captureStones(int stoppingPoint) throws PitNotFoundException {
        if (stoppingPoint<1 || stoppingPoint>12) {
            throw new PitNotFoundException();
        }
        int stones = pits.get(12-stoppingPoint).removeStones();
        if (stoppingPoint>=1 && stoppingPoint<=6) {
            stores.get(0).addStones(stones+1);
        } else if (stoppingPoint>=7 && stoppingPoint<=12) {
            stores.get(1).addStones(stones+1);
        }
        pits.get(stoppingPoint-1).removeStones();
        return stones;
    }

    public int distributeStones(int startingPoint) throws PitNotFoundException {
        if (startingPoint<1 || startingPoint>12) {
            throw new PitNotFoundException();
        }
        int stones = pits.get(startingPoint-1).removeStones();
        int pit = startingPoint-1;
        for (int i=0; i<stones; i++) {
            if (pit==5 && startingPoint>=1 && startingPoint<=6) {
                stores.get(0).addStones(1);
                if (stones-i>1) {
                    pit = 6;
                    pits.get(pit).addStone();
                    i++;
                }
            } else if (pit==11 && startingPoint>=7 && startingPoint<=12) {
                stores.get(1).addStones(1);
                if (stones-i>1) {
                    pit = 0;
                    pits.get(pit).addStone();
                    i++;
                }
            } else {
                if (pit==12) {
                    pit = 0;
                } else {
                    pit++;
                }
                pits.get(pit).addStone();
            }
        }
        return stones;
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum<1 || pitNum>12) {
            throw new PitNotFoundException();
        }
        return pits.get(pitNum-1).getStoneCount();
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

    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        if (pitNum<1 || pitNum>12) {
            throw new PitNotFoundException();
        }
        boolean empty = true;
        if (pitNum>=1 && pitNum<=6) {
            for (int i=0; i<6; i++) {
                if (pits.get(i).getStoneCount() != 0) {
                    empty = false;
                }
            }
        } else if (pitNum>=7 && pitNum<=12) {
            for (int i=6; i<12; i++) {
                if (pits.get(i).getStoneCount() != 0) {
                    empty = false;
                }
            }
        }
        return empty;
    }

    int moveStones(int startPit, Player player) throws InvalidMoveException {
        if ((player.getStore() == stores.get(0) && (startPit>=7 && startPit<=12))
          || (player.getStore() == stores.get(1) && (startPit>=1 && startPit<=6))) {
            throw new InvalidMoveException();
        }
        int startingStoreCount = player.getStoreCount();
        try {
            int stones = distributeStones(startPit);
        } catch (PitNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return player.getStoreCount() - startingStoreCount;
    }

    public void registerPlayers(Player one, Player two) {
        stores.get(0).setOwner(one);
        one.setStore(stores.get(0));
        stores.get(1).setOwner(two);
        two.setStore(stores.get(1));
    }

    public void resetBoard() {
        for (Store s : stores) {
            s.emptyStore();
        }
        for (Pit p : pits) {
            p.removeStones();
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

    public String toString() {
        String s = "";
        s += "                         12:" + pits.get(11).getStoneCount()
                                    + "  11:" + pits.get(10).getStoneCount()
                                    + "  10:" + pits.get(9).getStoneCount()
                                    + "   9:" + pits.get(8).getStoneCount()
                                    + "   8:" + pits.get(7).getStoneCount()
                                    + "   7:" + pits.get(6).getStoneCount() + "\n";
        s += stores.get(1).getOwner().getName() + "'s Store: " + stores.get(1).getTotalStones() + "    "
             + "                                        "
             + "    " + stores.get(0).getTotalStones() + " :" + stores.get(0).getOwner().getName() + "'s Store\n";
        s += "                          1:" + pits.get(0).getStoneCount()
                                    + "   2:" + pits.get(1).getStoneCount()
                                    + "   3:" + pits.get(2).getStoneCount()
                                    + "   4:" + pits.get(3).getStoneCount()
                                    + "   5:" + pits.get(4).getStoneCount()
                                    + "   6:" + pits.get(5).getStoneCount() + "\n";
        return s;

    }
}
