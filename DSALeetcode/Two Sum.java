class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        Map<Integer,Integer> store=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(store.containsKey(target-nums[i])){
                ans[1]=i;
                ans[0]=store.get(target-nums[i]);
                return ans;
            }
            store.put(nums[i],i);
        }
        return ans;
    }
}
