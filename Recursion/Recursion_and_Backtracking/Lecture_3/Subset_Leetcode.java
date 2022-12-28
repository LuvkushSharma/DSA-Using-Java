package Recursion_and_Backtracking_3;

/*

Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

 */

import java.util.ArrayList;
import java.util.List;

public class Subset_Leetcode {

    public static void main(String[] args) {

        int arr[] = {1,2,3};

        List<Integer> lst = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();


        Subset(arr , 0 , lst , ans);

        System.out.println(ans);

    }

    public static void Subset(int arr[] , int i , List<Integer> lst , List<List<Integer>> ans) {

        if(i == arr.length){

            ans.add(new ArrayList<>(lst));
            return;
        }

        Subset(arr , i+1 , lst , ans);

        lst.add(arr[i]);
        Subset(arr , i+1 , lst , ans);

        // UNDO : Backtrack
        lst.remove(lst.size() - 1);
    }
}
