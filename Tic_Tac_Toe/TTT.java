package Tic_Tac_Toe;

import java.util.Scanner;

public class TTT {

        public static void main(String[] args) {
            char[][] board = new char[3][3];
            initializeBoard(board);
            printBoard(board);

            char currentPlayer = 'X';
            boolean gameOver = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter palyer one name:- ");
            String player1 =scanner.nextLine();
            System.out.println("Enter palyer two name:- ");
            String player2 =scanner.nextLine();
            while (!gameOver) {
                if(currentPlayer=='X'){
                    System.out.println( player1 + "'s turn. Enter row (0-2) and column (0-2): ");}
                else {
                    System.out.println( player2 + "'s turn. Enter row (0-2) and column (0-2): ");
                }
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(board, row, col)) {
                    board[row][col] = currentPlayer;
                    printBoard(board);

                    if (isWinner(board, currentPlayer)) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    } else if (isBoardFull(board)) {
                        System.out.println("It's a draw!");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }
            scanner.close();
        }

        private static void initializeBoard(char[][] board) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = ' ';
                }
            }
        }

        private static void printBoard(char[][] board) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println();
            }
        }



        private static boolean isWinner(char[][]board, char player) {
            for (int row = 0; row < board.length; row++) {
                if(board[row][0]==player &&board[row][1]==player&&board[row][2]==player){
                    return true;
                }
            }
            for (int col = 0; col < board[0].length; col++) {
                if(board[0][col]==player &&board[1][col]==player&&board[2][col]==player){
                    return true;
                }
            }
            if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
                return  true;
            }
            if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
                return  true;
            }
            return false;
        }


    }


