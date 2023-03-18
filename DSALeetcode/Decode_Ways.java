//Leetcode 91. Decode Ways
// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            
            int cnt=dp[i+1];
            
            if((i<s.length()-1)&&(s.charAt(i)=='1' || (s.charAt(i)=='2'&& s.charAt(i+1)>='0' && s.charAt(i+1)<='6'))) cnt+=dp[i+2];
            
            dp[i]=cnt;
        }
        return dp[0];
    }
}
