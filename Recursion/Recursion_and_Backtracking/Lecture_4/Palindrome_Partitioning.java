package Recursion_and_Backtracking_4;

/*

Given a string s, partition s such that every
substring
 of the partition is a
palindrome
. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

public class Palindrome_Partitioning {

    public static void main(String[] args) {

        String s = "NitiN";

        PrintPartition(s , "");
    }

    public static void PrintPartition(String ques , String ans){

        // Base case
        if(ques.length() == 0){

            System.out.println(ans);
            return;
        }

        for (int i = 1; i <= ques.length() ; i++){

            String part = ques.substring(0 , i);

            // Agar part hee palindrome nhi hain toh aagye bhadne kii baat hee nhi hain
            // i.e   N| i | ti | N
            // isme : N palindrome hain continue further
            // i is palindrome i.e continue further
            // ti is not a palindrome i.e yaahi par runk jaao aagye bhadne kaa faayda kya.

            // Similarly, N| i| t| in|
            // isme : N palindrome hain continue further
            // i is palindrome i.e continue further.
            // t is palindrome i.e continue further.
            // in is not a palindrome i.e donot continue further.

            // Isliye ham aagye call karne se pehle check kar le rahe hain kii Palindrome hain kii nhi partition.
            if(isPalindrome(part)){

                // Pehle N jaayega ans main aur i t i N --> ques main jaayega.
                // Fir Ni ans main and t i N --> ques main jaayega.
                PrintPartition(ques.substring(i) , ans + part + "| ");
            }

        }
    }




































































































    public static boolean isPalindrome(String s){

        int i = 0;
        int j = s.length() - 1;

        while(i < j){

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i += 1;
            j -= 1;
        }

        return true;
    }
}
