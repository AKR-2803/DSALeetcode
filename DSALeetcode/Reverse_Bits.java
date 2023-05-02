//Leetcode 190. Reverse Bits 
//https://leetcode.com/problems/reverse-bits/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder str = new StringBuilder(Integer.toBinaryString(n));
        String s1 = str.reverse().toString();
        if(s1.length() < 32){
            while(s1.length() != 32){
                s1 += '0';
            }
        }
        return Integer.parseUnsignedInt(s1,2);
    }
}
