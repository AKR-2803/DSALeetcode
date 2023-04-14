//Leetcode 191. Number of 1 Bits 
//https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int ans=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') ans++;
        }
        
        return ans;
    }
}
