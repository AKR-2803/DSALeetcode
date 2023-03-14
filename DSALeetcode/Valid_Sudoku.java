//Leetcode 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet tmp=new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!tmp.add("row"+i+board[i][j])|| !tmp.add("column"+j+board[i][j])) return false;
                    
                    if(!tmp.add("box"+(i/3)*3+(j/3)+board[i][j])) return false;
                }
            }
        }
        return true;
    }
}
