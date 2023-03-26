//Leetcode 125. Valid Palindrome 
//https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        if(s.isBlank()) return true;
        s = s.toLowerCase();
        String res="";
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i)>=97 && s.charAt(i)<=122) {
               res+=s.charAt(i); 
            }
            if((int)s.charAt(i)>=48 && s.charAt(i)<=57) {
               res+=s.charAt(i); 
            }
        }
        if(res.length()==0) return true;
        for(int i=0;i<=res.length()/2;i++){
            if(res.charAt(i)!=res.charAt(res.length()-i-1)) return false;
        }
        return true;
    }
}
