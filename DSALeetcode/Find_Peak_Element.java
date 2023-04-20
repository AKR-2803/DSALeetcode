//Leetcode 162. Find Peak Element
//https://leetcode.com/problems/find-peak-element/

class Solution {
    public int findPeakElement(int[] nums) {
        int ind=0,max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max) {
                max=nums[i];
                ind=i;
            }
        }
        return ind;
    }
}
