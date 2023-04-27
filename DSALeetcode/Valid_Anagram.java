//Leetcode 242. Valid Anagram 
//https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1 = new String(chars);
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
        String t1 = new String(chars1);
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=t1.charAt(i)) return false;
        }
        return true;
    }
}
