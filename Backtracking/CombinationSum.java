package com.akr.GitRepo.Backtracking;

// Leetcode 39 Combination Sum
// [https://leetcode.com/problems/combination-sum/description/]

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 8;
//        int currentSum = 0;
        List<List<Integer>> ans = new ArrayList<>();
//        System.out.println(sum(arr,target, currentSum, new ArrayList<>(), ans));
        System.out.println(sum2(arr, target, 0, new ArrayList<>(),ans));
    }

    /*
    time: 18ms
    problem with this method is that it will also print permutations of the answers
    example for [1,2,3] target 8
    output:[[2, 2, 2, 2], [2, 3, 3], [3, 2, 3], [3, 3, 2], [3, 5], [5, 3]]
    To avoid these permutations we need to modify the code :
    Modification 1. Either check sort the list and check it exists in the `ans` list (sum() method)
    2 Get a start pointer (sum2() method) [more efficient]
    */
    private static List<List<Integer>> sum(int[] arr, int target, int currentSum, List<Integer> list, List<List<Integer>> ans){

        /* the problem
        //this will print the permutations of the answers too
        if(currentSum == target){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        */

        //Modification 1
        //check if the list already exists by sorting it before adding it to answer list
        if(currentSum == target){
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            if(!ans.contains(temp)){
            ans.add(new ArrayList<>(temp));
            }
            return ans;
        }

        for(int num : arr){
            if(currentSum + num > target){
                continue;
            }
            list.add(num);
            sum(arr, target, currentSum + num, list, ans);
            list.remove(list.size() - 1);
        }
        return ans;
    }


    /*
        time : 1ms
        More effective
        Here we use the remaining target to reach `0` eventually
        Modification 2
        We can have a start pointer to avoid permutations of a combination
        Start means : Search from this position onwards
        Hence this method works faster than the previous ones
        targetLeft is the target left to reach `0`, if we reach `0`, we found a combination
    */
    public static List<List<Integer>> sum2(int[] candidates, int targetLeft, int start, List<Integer> list, List<List<Integer>> ans){

        if(targetLeft == 0){
            // List<Integer> temp = new ArrayList<>(list);
            // Collections.sort(temp);
            ans.add(new ArrayList<>(list));
            return ans;
        }

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > targetLeft){
                continue;
            }
            list.add(candidates[i]);
            sum2(candidates, targetLeft - candidates[i], i, list, ans);
            list.remove(list.size() - 1);
        }
        return ans;
    }

}
