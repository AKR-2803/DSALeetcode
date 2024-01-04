package com.akr.GitRepo.Backtracking;

import java.util.Arrays;

/*
In really simple words
- Backtracking is reverting the changes after returning from each recursion call.
- Make the change, and revert the change when the work is done.

Why use Backtracking here?
Problem with UDLR was it went in infinite recursion calls when we used a similar approach as in Maze.java example
Problem was that that now we can also go Up and Down which caused duplication in recursion tree and
the program went in infinite recursion calls [see BacktrackingExample.jpg for better understanding]

*/
public class BacktrackingExample {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] indices = new int[maze.length][maze[0].length];

//        allPaths("", maze, 0, 0);
        allPathsIndices("", maze, 0, 0, indices, 1);
    }


    private static void allPaths(String p, boolean[][] maze, int r, int c) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        //false means marked visited, the block is visited for a particular path to avoid infinite recusrion
        maze[r][c] = false;

        //down
        if (r < maze.length - 1) {
            allPaths(p + 'D', maze, r + 1, c);
        }

        //right
        if (c < maze[0].length - 1) {
            allPaths(p + 'R', maze, r, c + 1);
        }

        //up
        if (r > 0) {
            allPaths(p + 'U', maze, r - 1, c);
        }

        //left
        if (c > 0) {
            allPaths(p + 'L', maze, r, c - 1);
        }

        //at the end revert the changes of the path you found till now
        //so that they do not hinder the next path
        //marking the block as unvisited
        maze[r][c] = true;
    }

    private static void allPathsIndices(String p, boolean[][] maze, int r, int c, int[][] indices, int step) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            indices[r][c] = step;
            for (int[] arr : indices) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        //false means marked visited, the block is visited for a particular path to avoid infinite recursion
        maze[r][c] = false;
        indices[r][c] = step;

        //down
        if (r < maze.length - 1) {
            allPathsIndices(p + 'D', maze, r + 1, c, indices, step + 1);
        }

        //right
        if (c < maze[0].length - 1) {
            allPathsIndices(p + 'R', maze, r, c + 1, indices, step + 1);
        }

        //up
        if (r > 0) {
            allPathsIndices(p + 'U', maze, r - 1, c, indices, step + 1);
        }

        //left
        if (c > 0) {
            allPathsIndices(p + 'L', maze, r, c - 1, indices, step + 1);
        }

        //at the end revert the changes of the path you found till now
        //so that they do not hinder the next path
        //marking the block as unvisited
        maze[r][c] = true;
        indices[r][c] = 0;
    }
}




