package com.akr.GitRepo.Backtracking.Basics;
/*
Given a maze as a 2d array with `r` rows and `c` columns
Condition: You can only go Down(D) or Right(R)

Start(S) => (3,3)
Finish(F)/Target to reach => (1,1)

  3  2  1
3 S
2
1       F

- method 1 : count no. of possible paths (Allowed : D or R)
- method 2 : print all possible paths, i.e. strings (Example "DDRR" means down,down,right,right)
- method 3 : store paths(strings) in arrayList (with arrayList in method arguments) [D,R]
- method 4 : store paths(strings) in arrayList (without arrayList in method arguments) [D,R]
- method 5 : store paths(strings) in arrayList (without arrayList in method arguments) [V,H,D]
- method 6 : count no. of possible paths (can go V vertical OR H Horizontal OR D Diagonal)
*/

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // try inputting different values of rows and columns (for example r=3, c=4)
        // method1
        //         maze(3,3);
        // method2
        //         mazePath("", 3,3);
        // method 3
        //         System.out.println(mazePathListInArg("",3,3,new ArrayList<String>()));
        // method 4
        //         System.out.println(mazePathList("",3,3));
        // method 5
        //         System.out.println(mazePathListDiagonal("",3,3));
        // method 6
        //         System.out.println(mazeDiagonal(3,3));
    }

    //method 1
    //find no of possible paths/ways
    private static int maze(int r, int c) {

        if (r == 1 || c == 1) {
            return 1;
        }

        //no of paths from left calls (go down calls)
        int down = maze(r - 1, c);
        //no of paths from right calls (go right calls)
        int right = maze(r, c - 1);

        //add possible answers from both left and right calls
        return down + right;
    }

    //method 2
    //print all possible paths
    private static void mazePath(String p, int r, int c) {

        //when both r == 1 and c == 1, we reached (1,1) which is our target to reach
        //just print the answer path!
        if (r == 1 && c == 1) {
            System.out.print(p + " ");
            return;
        }

        //we need reach the end which is (1,1), for that as decrement rows till 1
        if (r > 1) {
            mazePath(p + 'D', r - 1, c);
        }

        //we need reach the end which is (1,1), for that as decrement columns till 1
        if (c > 1) {
            mazePath(p + 'R', r, c - 1);
        }
    }

    //method 3
    //WITH arraylist in arguments
    private static ArrayList<String> mazePathListInArg(String p, int r, int c, ArrayList<String> ans) {

        //when both r == 1 and c == 1, we reached (1,1) which is our target to reach
        //just print the answer path!
        if (r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }

        //we need reach the end which is (1,1), for that as decrement rows till 1
        if (r > 1) {
            ans = mazePathListInArg(p + 'D', r - 1, c, ans);
        }

        //we need reach the end which is (1,1), for that as decrement columns till 1
        if (c > 1) {
            ans = mazePathListInArg(p + 'R', r, c - 1, ans);
        }

        return ans;
    }

    //method 4
    //WITHOUT arraylist in arguments
    private static ArrayList<String> mazePathList(String p, int r, int c) {

        //when both r == 1 and c == 1, we reached (1,1) which is our target to reach
        //just print the answer path!
        if (r == 1 && c == 1) {
            //this local list will have answer from each call
            ArrayList<String> localList = new ArrayList<>();
            localList.add(p);
            return localList;
        }

        ArrayList<String> ans = new ArrayList<>();
        //we need reach the end which is (1,1), for that as decrement rows till 1
        if (r > 1) {
            //add all the answers from the localLists of each recursion call!
            ans.addAll(mazePathList(p + 'D', r - 1, c));
        }

        //we need reach the end which is (1,1), for that as decrement columns till 1
        if (c > 1) {
            ans.addAll(mazePathList(p + 'R', r, c - 1));
        }

        return ans;
    }

    //method 5
    //can go diagonally
    //Down is Vertical(V), Right is Horizontal(R), Diagonal is (D)
    //WITHOUT arraylist in arguments
    private static ArrayList<String> mazePathListDiagonal(String p, int r, int c) {

        //when both r == 1 and c == 1, we reached (1,1) which is our target to reach
        //just print the answer path!
        if (r == 1 && c == 1) {
            //this local list will have answer from each call
            ArrayList<String> localList = new ArrayList<>();
            localList.add(p);
            return localList;
        }

        ArrayList<String> ans = new ArrayList<>();
        if (r > 1 && c > 1) {
            ans.addAll(mazePathListDiagonal(p + 'D', r - 1, c - 1));
        }

        //we need reach the end which is (1,1), for that as decrement rows till 1
        if (r > 1) {
            //add all the answers from the localLists of each recursion call!
            ans.addAll(mazePathListDiagonal(p + 'V', r - 1, c));
        }

        //we need reach the end which is (1,1), for that as decrement columns till 1
        if (c > 1) {
            ans.addAll(mazePathListDiagonal(p + 'H', r, c - 1));
        }
        return ans;
    }

    //method 6
    //find no of ways if diagonal is also allowed
    //V vertical, H Horizontal, D Diagonal
    private static int mazeDiagonal(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int diagonal = mazeDiagonal(r - 1, c - 1);
        //no of paths from left calls (go down calls)
        int vertical = mazeDiagonal(r - 1, c);
        //no of paths from right calls (go right calls)
        int horizontal = mazeDiagonal(r, c - 1);

        //add possible answers from both `V`, `H` and `D` calls
        return diagonal + vertical + horizontal;
    }

}