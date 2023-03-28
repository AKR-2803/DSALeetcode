//Leetcode 53. Maximum Subarray
//https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int max=0;
        int maxAns=nums[0];
        for(int i=0;i<nums.length;i++){
            max+=nums[i];
            if(max>maxAns) maxAns=max;
            if(max<0)max=0;
        }
        return maxAns;
    }
}
