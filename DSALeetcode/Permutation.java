//Leetcode 46. Permutations
//https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recur(0,ans,nums);
        return ans;
    }
    void recur(int ind,List<List<Integer>> ans,int[] arr){
        if(ind==arr.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList(ds));
            return ;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i,ind,arr);
            recur(ind+1,ans,arr);
            swap(i,ind,arr);
        }
    }
    void swap(int i,int ind,int[] arr){
        int j=arr[i];
        arr[i]=arr[ind];
        arr[ind]=j;
    }
}
