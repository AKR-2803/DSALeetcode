package com.akr.GitRepo.Backtracking.Basics;

//UDLR: Up Down Left Right
public class MazeUDLR {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPaths("",maze, 0,0);
    }

    private static void allPaths(String p, boolean[][] maze, int r, int c){

        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.print(p + " ");
            return;
        }

        if(!maze[r][c]){
            return;
        }

        //down
        if(r < maze.length - 1){
            allPaths(p + 'D', maze, r + 1, c);
        }

        //right
        if(c < maze[0].length - 1){
            allPaths(p + 'R', maze, r, c + 1);
        }

        //up
        if(r > 0){
            allPaths(p + 'U', maze, r - 1, c);
        }

        //left
        if(c > 0){
            allPaths(p + 'L', maze, r, c - 1);
        }
    }
}
