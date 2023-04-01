//Leetcode 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] num, int target) {
        int first=-1,last=-1;
        int[] res=new int[2];
        
        for(int i=0;i<num.length;i++){
            if(num[i]==target && first==-1){
                first=i;
            }
            if(num[i]==target) last=i;
        }
        res[0]=first;
        res[1]=last;
        return res;
    }
}
