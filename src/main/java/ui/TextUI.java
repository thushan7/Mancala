package ui;

import mancala.MancalaGame;
import mancala.Player;
import mancala.InvalidMoveException;
import mancala.GameNotOverException;

import java.util.Scanner;

public class TextUI {
    private MancalaGame game;
    private Scanner input;

    public static void main(String[] args) {
        TextUI ui = new TextUI();

        ui.input = new Scanner(System.in);
        ui.game = new MancalaGame();
        String cont = "y";
        Player p;
        int pit;

        ui.game.startNewGame();

        while(cont.equals("y")) {
            while(!ui.game.isGameOver()) {
                p = ui.game.getCurrentPlayer();
                System.out.println(p.getName() + "'s turn");
                System.out.println(ui.game.getBoard());
                System.out.print("Enter a pit to move from: ");
                pit = ui.input.nextInt();
                try {
                    ui.game.move(pit);
                } catch (InvalidMoveException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Game over");

            try {
                p = ui.game.getWinner();
                if (p == null) {
                    System.out.println("Tie!");
                } else {
                    System.out.println(p.getName() + " wins!");
                }
            } catch (GameNotOverException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter y to continue");
            cont = ui.input.next();

            if (cont.equals("y")) {
                ui.game.getBoard().resetBoard();
            }
        }

        System.out.println("Goodbye!");
    }
}
