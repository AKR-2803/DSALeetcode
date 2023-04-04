//Leetcode 79. Word Search 
//https://leetcode.com/problems/word-search/

class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && search(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board,String word,int i,int j,int len){
        if(len==word.length()) return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!= word.charAt(len)) return false;
        boolean res=false;
        board[i][j]^=256;
        res |=search(board,word,i+1,j,len+1);// bottom
        res |=search(board,word,i-1,j,len+1);// top
        res |=search(board,word,i,j+1,len+1);// right
        res |=search(board,word,i,j-1,len+1);//left
        board[i][j]^=256;
        return res;
    }
}
