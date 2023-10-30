package ai;

import java.util.Scanner;

public class aiMancala {
    static int playerTurn = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the Mancala board
        int[] board = new int[14]; // 0-5 for player 1, 7-12 for player 2

        while (!isGameOver(board)) {
            displayBoard(board);

            int currentPlayer = (playerTurn == 1) ? 0 : 7;
            int move = getPlayerMove(scanner);

            if (isValidMove(board, currentPlayer, move)) {
                int stones = board[currentPlayer + move];
                board[currentPlayer + move] = 0;

                int i = currentPlayer + move + 1;
                while (stones > 0) {
                    if (i == currentPlayer + 13) {
                        i = currentPlayer;
                    }
                    if (i != currentPlayer + 6) {
                        board[i]++;
                        stones--;
                    }
                    i++;
                }

                if (i - 1 == currentPlayer + 6) {
                    // Player gets another turn
                    System.out.println("You get another turn!");
                } else if (board[i - 1] == 1 && isPlayerPit(playerTurn, i - 1)) {
                    // Capture opponent's stones
                    int oppositePit = 12 - (i - 1);
                    board[currentPlayer + 6] += board[oppositePit] + 1;
                    board[i - 1] = 0;
                    board[oppositePit] = 0;
                }

                // Switch to the next player's turn
                playerTurn = (playerTurn == 1) ? 2 : 1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        displayBoard(board);
        determineWinner(board);
    }

    private static boolean isValidMove(int[] board, int currentPlayer, int move) {
        return move >= 1 && move <= 6 && board[currentPlayer + move] != 0;
    }

    private static boolean isPlayerPit(int player, int pit) {
        return (player == 1 && pit >= 0 && pit <= 5) || (player == 2 && pit >= 7 && pit <= 12);
    }

    private static boolean isGameOver(int[] board) {
        return (sumStonesInRange(board, 0, 5) == 0) || (sumStonesInRange(board, 7, 12) == 0);
    }

    private static int sumStonesInRange(int[] board, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += board[i];
        }
        return sum;
    }

    private static void displayBoard(int[] board) {
        // Display the Mancala board
        // Implement your own board display logic here.
    }

    private static int getPlayerMove(Scanner scanner) {
        System.out.print("Player " + (playerTurn == 1 ? "1" : "2") + ", choose a pit (1-6): ");
        return scanner.nextInt();
    }

    private static void determineWinner(int[] board) {
        int player1Score = sumStonesInRange(board, 0, 5);
        int player2Score = sumStonesInRange(board, 7, 12);

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player1Score < player2Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
