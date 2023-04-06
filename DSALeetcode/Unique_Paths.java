//Leetcode 62. Unique Paths
//https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        int N=m+n-2;
        int r=n-1;
        double res=1;
        for(int i=1;i<=r;i++){
            res=res*(N-r+i)/i;
        }
        return (int)res;
    }
}
