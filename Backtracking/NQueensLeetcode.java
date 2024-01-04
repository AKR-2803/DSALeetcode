package com.akr.GitRepo.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensLeetcode {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        List<List<String>> queenList = new ArrayList<>();
        System.out.println(queen(board, 0, queenList));
    }

    private static List<List<String>> queen(boolean[][] board, int row, List<List<String>> ans) {

        if (row == board.length) {
            ans.addAll(getAnswerList(board));
            return ans;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                // if it is safe, place the queen
                board[row][col] = true;
                ans = queen(board, row + 1, ans);
                board[row][col] = false;
            }
        }
        return ans;
    }

    private static List<List<String>> getAnswerList(boolean[][] board) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (boolean[] row : board) {
            String p = "";
            for (boolean elem : row) {
                if (elem) {
                    p += "Q";
                } else {
                    p += ".";
                }
            }
            list.add(p);
        }
        ans.add(list);
        return ans;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertically above
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // check left diagonal
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // check right diagonal
        for (int i = 1; i <= Math.min(row, board[0].length - 1 - col); i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
}
