package com.akr.GitRepo.Backtracking.Basics;

public class MazeRestrict {
    public static void main(String[] args) {

        //(1,1) is blocked, you cant go to (1,1)
        //row and column indices start from 0,1,2...
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        System.out.println(mazeBlock(maze, 0, 0));
        mazePathsRestricted("", maze, 0, 0);
    }

    //blockage at (1,1)
    //indices of rows and columns start from 0, i.e. r => 0,1,2, c=>0,1,2 for 3X3 matrix
    private static int mazeBlock(boolean[][] maze, int r, int c) {

        if (r == maze.length - 1 || c == maze[0].length - 1) {
            return 1;
        }

        if (!maze[r][c]) {
            return 0;
        }

        int down = mazeBlock(maze, r + 1, c);
        int right = mazeBlock(maze, r, c + 1);

        return down + right;
    }

    private static void mazePathsRestricted(String p, boolean[][] maze, int r, int c) {
        //the base condition
        //when we reach the target, last element of the maze, i.e. maze[3][3] in this case
        //which means both row and column have reach their ends => add the answer to String "p"
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }

        //(1,1) is blocked/restricted, hence skip this!
        //whichever block is false, i.e. it is blocked, skip that
        if (!maze[r][c]) {
            return;
        }

        // [end for row = maze.length - 1]
        // [end for column = maze[0].length - 1]
        //until both, row and column have not reached the end, keep moving
        //if row end has been reached, it will run column loop
        //if column end has been reached, it will row  loop
        //and when both reach their ends => we add that answer to the answer String "p" [aka the base condition]
        if(r < maze.length - 1){
            mazePathsRestricted(p + 'D', maze, r + 1, c);
        }

        if(c < maze[0].length - 1){
            mazePathsRestricted(p + 'R', maze, r, c + 1);
        }
    }
}
