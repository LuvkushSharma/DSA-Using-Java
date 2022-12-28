
/*

Given a string s, find the length of the longest substring without repeating characters.

Input Format
Input string

Constraints
0<=|s|<=10000

Output Format
Length of longest substring with non repeating characters

Sample Input
ABDEFGABEF

Sample Output
6

Explanation
For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.

 */


import java.util.*;
public class Length_of_longest_substring {
    public static void main (String args[]) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int ans = LongestSubstringWithoutrepeat(s);

        System.out.println(ans);
    }

    public static int LongestSubstringWithoutrepeat(String s){

        // Calculating the frequency of each character of the string
        int frqt[] = new int[256];

        int start = 0;
        int end = 0;

        int ans = 0;


        while(end < s.length()){

            // Grow the window
            frqt[s.charAt(end)] += 1;


            // Shrink the window till the repeating character not removes from the current window.
            while(frqt[s.charAt(end)] > 1  && start <= end){

                frqt[s.charAt(start)] -= 1;
                start += 1;
            }


            // ans calculating
            ans = Math.max(ans , end - start + 1);

            end += 1;
        }

        return ans;
    }
}
