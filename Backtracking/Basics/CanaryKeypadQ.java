package com.akr.GitRepo.Backtracking.Basics;

import java.util.HashSet;

public class CanaryKeypadQ {

    //with ArrayList Total : 61390
    //we use HashSet to ignore duplicate entries
    //with HashSet Total   : 18713

    //so, we declare a HashSet globally => to ignore duplicates
    //you can also declare this set inside main() as we did in CanaryMailKeypadQuestion.java
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1},
        };

        permutations(arr, 1, 1, "");
        System.out.println("Total : " + set.size());
    }

    private static void permutations(int[][] arr, int r, int c, String ans) {

        if (ans.length() == 10) {
            if (!set.contains(ans)) {
                System.out.println(ans);
                set.add(ans);
            }
            return;
        }

        if (arr[r][c] >= 0) {
            ans += arr[r][c];

            //go left, just make sure c > 0 to avoid indexOuOfBoundException
            if (c > 0) {
                permutations(arr, r, c - 1, ans);
            }

            //go up
            if (r > 0) {
                permutations(arr, r - 1, c, ans);
            }

            //go right
            if (c < arr[0].length - 1) {
                permutations(arr, r, c + 1, ans);
            }

            //go down
            if (r < arr.length - 1) {
                permutations(arr, r + 1, c, ans);
            }
        }
    }
    //alternatively you can use for loop for all 4 directions
    /*
    public static void find(int[][] arr, int i, int j, String ans) {

        //append the digit until length == 10
        ans = ans + arr[i][j];

        //length == 10, add in the Hashset(for only unique entries)
        if (ans.length() == 10) {
            if (!set.contains(ans)) {
                System.out.println(ans);
                set.add(ans);
            }
            return;
        }

        //directions possible, left, right, top, bottom
        int[][] di = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        //moving to possible directions for respective digits
        for (int[] d : di) {
            int x = i + d[0], y = j + d[1];

            //check for invalid position
            if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0 || arr[x][y] < 0) {
                continue;
            }
            //calling function recursively to find move to next possible digit
            find(arr, x, y, ans);
        }
    }

*/
}