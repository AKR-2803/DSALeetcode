//Leetcode 189. Rotate Array
//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        int A[] = new int[l];
        int temp = k;
        for (int i = 0; i < k; i++) {
            A[i] = nums[l - temp];
            temp--;
        }
        temp = l - 1;
        for (int i = l - k - 1; i >= 0; i--) {
            nums[temp] = nums[i];
            temp--;
        }
        for (int i = 0; i < k; i++) {
            nums[i] = A[i];
        }
    }
}
