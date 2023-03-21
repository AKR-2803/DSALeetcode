//Leetcode 38. Count and Say 
//https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String str="11";
        for(int i=3;i<=n;i++){
            String temp="";
            int cnt=1;
            str+='$';
            for(int j=1;j<str.length();j++){
                if(str.charAt(j)!=str.charAt(j-1)){
                    temp+=Integer.toString(cnt);
                    temp+=str.charAt(j-1);
                    cnt=1;
                }
                else cnt++;
            }
            str=temp;
        }
        return str;
        
    }
}
