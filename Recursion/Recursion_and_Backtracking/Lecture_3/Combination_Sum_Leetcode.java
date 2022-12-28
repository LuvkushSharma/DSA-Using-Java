package Recursion_and_Backtracking_3;

/*


Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

 */


import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_Leetcode {

    public static void main(String[] args) {

             int candidates[] = {2 , 3, 6, 7};
             int target = 7;

             List<Integer> lst = new ArrayList<>();

             List<List<Integer>> ans = new ArrayList<>();

             PrintCombination(candidates , target , lst , 0 , ans);

        System.out.println(ans);

    }

    public static void PrintCombination(int candidates[] , int target , List<Integer> lst, int idx , List<List<Integer>> ans){

        // Base case
        if(target == 0){

            ans.add(new ArrayList<>(lst));
        }

        // Jitne coins utni possibility
        // Infinite supply hain isliye baar baar i = 0 se suru kiya hain.
        for (int i = idx; i < candidates.length ; i++){

            if(target >= candidates[i]){

                lst.add(candidates[i]);

                // It is a case of infinite supply
                // And we have to find the combinations not permutations
                // iska matlab hame peeche waale nhi uthaane
                // Aur yaaha par infinite supply hain isliye : (idx + 1) kii simply idx bhejengye
                PrintCombination(candidates , target - candidates[i] , lst , i , ans);

                // UNDO : Backtrack
                lst.remove(lst.size() - 1);
            }
        }
    }

}
