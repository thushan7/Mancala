package ui;

import mancala.MancalaGame;

import java.util.Scanner;

public class TextUI {
    private MancalaGame game;
    private Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        game = new MancalaGame();

        game.startNewGame();
    }
}
