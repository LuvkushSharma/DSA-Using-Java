
/*

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a
single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


 */


/*

 1. Output should not have multiple spaces
 2. Trimming the starting and ending spaces

 */


public class Reverse_word_in_a_string_151__leet {

    public static void main(String[] args) {

          String str = " the     sky is   blue ";

          String ans = Reverse_words_in_string(str);

          // Now removing last extra space
          ans = ans.trim();

        System.out.println(ans);


    }

    public static String Reverse_words_in_string(String s){

        // Trimming the space in a string
           s = s.trim();

        // Removing the multiple spaces in a string using regular expression
        //  '\s' means removing single space but '\s+' removes more than one space

        // On the str 1st index we have substring as "the" on 2nd index we have "sky" ,..
        String arr[] = s.split("\s+");

        String ans = "";

        for (int i = arr.length - 1 ; i >= 0 ; i--){

            ans = ans + arr[i] + " ";

        }

        return ans;
    }
}
