//Leetcode 66. Plus One
//https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        digits[n-1]=digits[n-1]+1;
        n=n-1;
        while(n>0 && digits[n]==10){
            digits[n]=0;
            digits[n-1]++;
            n--;
        }
        if(n==0 && digits[n]==10){
            int []res=new int[digits.length+1];
            for(int i=0;i<digits.length;i++){
                res[i+1]=digits[i];
            }
            res[0]=1;
            res[1]=0;
            return res;
        }
        return digits;
    }
}
