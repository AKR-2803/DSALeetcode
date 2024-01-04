package com.akr.GitRepo.Backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    private static int queens(boolean[][] board, int row){
        if(row == board.length){
            //print board
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board[0].length; col++) {
            if(isSafe(board, row, col)){
                //place the queen
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }


    /*
    checking the directions where queen can go to check the block is safe for another queen
    only check any queen above, as we are going row wise, there is no queen below the current queen
    for Up we have 3 directions to check for a queen
     1. vertically above
     2. left diagonal
     3. right diagonal
    */
    private static boolean isSafe(boolean[][] board, int row, int col) {

        //checking vertically up/above
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //checking left diagonal
        for (int i = 1; i <= Math.min(row,col); i++) {
            if(board[row - i][col - i]){
                return false;
            }
        }

        //checking right diagonal
        for (int i = 1; i <= Math.min(row, board[0].length - col - 1); i++) {
            if(board[row - i][col + i]){
                return false;
            }
        }
        return true;
    }

    //displaying the queens on the board
    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean elem : row){
                if(elem){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
