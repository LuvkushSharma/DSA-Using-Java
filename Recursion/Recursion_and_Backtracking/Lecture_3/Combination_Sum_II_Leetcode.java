package Recursion_and_Backtracking_3;

/*

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],  <------- Isme 2 ones isliye le rahe hain becoz 2 ones hain array main. We cannot take 3 ones as we donot have 3 ones in the given array.
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_Leetcode {

    public static void main(String[] args) {

         // To get the required output we have to sort the array first
        // As 1 is used first not 10.

        // (Given) : Each number in candidates may only be used once in the combination.
        // By seeing the above given statement we are sure that we donot have infinite supply.
        // i.e we are required to use a single num from the array only once.

        int arr[] = {10,1,2,7,6,1,5};
        int target = 8;

        Arrays.sort(arr);

        List<Integer> lst = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        PrintCombination(arr , target , lst , 0 , ans);

        System.out.println(ans);
    }

    public static void PrintCombination(int candidates[] , int target , List<Integer> lst, int idx , List<List<Integer>> ans){

        // Base case
        if(target == 0){

            ans.add(new ArrayList<>(lst));
        }


        for (int i = idx; i < candidates.length ; i++){

            // This will create simply a duplicate
            // Like, in the given array : {10,1,2,7,6,1,5} : Sort this array to meet the required condition.
            // we have two One's and Target = 8
            // i.e first 1 will give a pair : 1,7
            // and second 1 will also gave a pair : 1,7

            if(i != idx && candidates[i] == candidates[i-1]){

                continue;
            }

            if(target >= candidates[i]){

                lst.add(candidates[i]);

                // Infinite supply nahi hain isliye (i+1) bhej rahe hain
                PrintCombination(candidates , target - candidates[i] , lst , i + 1 , ans);

                // UNDO : Backtrack
                lst.remove(lst.size() - 1);
            }
        }
    }
}
