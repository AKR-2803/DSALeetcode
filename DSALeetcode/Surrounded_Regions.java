//Leetcode 130. Surrounded Regions
//https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][m-1]=='O') dfs(board,i,m-1);
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[n-1][i]=='O') dfs(board,n-1,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#') board[i][j]='O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char [][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length|| board[i][j]!='O') return;
        
        board[i][j]='#';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
