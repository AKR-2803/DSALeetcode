//Leetcode 75. Sort Colors
//https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int hig=nums.length-1;
        int mid=0;
        int temp;
        while(mid<=hig){
            switch(nums[mid]){
                case 0:{
                    temp=nums[low];
                    nums[low]=nums[mid];
                    nums[mid]=temp;
                    low++;mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp=nums[mid];
                    nums[mid]=nums[hig];
                    nums[hig]=temp;
                    hig--;
                    break;
                }
            }
        }
    }
}
