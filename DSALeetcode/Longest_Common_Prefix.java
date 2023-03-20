//Leetcode 14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] str) {
        
        for(int i=1;i<str.length;i++){
            str[i]=com(str[i-1],str[i]);
        }
        return str[str.length-1];
        
    }
    public String com(String x,String y){
        if(x.length()>y.length()) return com(y,x);
        int i=0;
        while(i<x.length()){
            if(x.charAt(i)!=y.charAt(i)) break;
            i++;
        }
        return x.substring(0,i);
    }
}
