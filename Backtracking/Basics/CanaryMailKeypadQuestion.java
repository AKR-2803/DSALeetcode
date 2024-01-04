package com.akr.GitRepo.Backtracking.Basics;

import java.util.HashSet;

public class CanaryMailKeypadQuestion {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1},
        };


        HashSet<String> set = new HashSet<>();
        System.out.println(permutations(arr, 1, 1, "", set));
        System.out.println();
        System.out.println("Total : " + set.size());
    }

    private static HashSet<String> permutations(int[][] arr, int r, int c, String ans, HashSet<String> set) {

        if (ans.length() == 10) {
            set.add(ans);
            return set;
        }

        if (arr[r][c] >= 0) {
            ans += arr[r][c];

            //left
            if (c > 0) {
                set = permutations(arr, r, c - 1, ans, set);
            }

            //up
            if (r > 0) {
                set = permutations(arr, r - 1, c, ans, set);
            }

            //right
            if (c < arr[0].length - 1) {
                set = permutations(arr, r, c + 1, ans, set);
            }

            //down
            if (r < arr.length - 1) {
                set = permutations(arr, r + 1, c, ans,set);
            }
        }
        return set;
    }
}