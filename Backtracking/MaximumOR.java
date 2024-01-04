package com.akr.GitRepo.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MaximumOR {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //print all subsets
        List<List<Integer>> ans = allSubsets(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> allSubsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            int n = ans.size();
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(num);
                ans.add(list);
            }
        }
        return ans;
    }
}

