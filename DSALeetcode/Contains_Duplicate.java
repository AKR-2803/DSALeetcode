//Leetcode 217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mp=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(mp.contains(nums[i])) return true;
            mp.add(nums[i]);
        }
        return false;
    }
}
