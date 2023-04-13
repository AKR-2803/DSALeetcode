//Leetcode 171. Excel Sheet Column Number 
//https://leetcode.com/problems/excel-sheet-column-number/

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0,power=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            ans+=Math.pow(26,power++)*(columnTitle.charAt(i)-'A'+1);
        }
        return ans;
    }
}
