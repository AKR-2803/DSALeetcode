//Leetcode 215. Kth Largest Element in an Array 
//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }

        int i=0;
        while(i<k-1){
            pq.poll();
            i++;
        }
        return pq.peek();
    }
}
