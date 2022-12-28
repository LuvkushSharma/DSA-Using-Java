

/*

Problem Preview

Kartik Bhaiya has a string consisting of only 'a' and 'b' as the characters. Kartik Bhaiya describes perfectness of a string
as the maximum length substring of equal characters. Kartik Bhaiya is given a number k which denotes the maximum number
of characters he can change. Find the maximum perfectness he can generate by changing no more than k characters.

Input Format
The first line contains an integer denoting the value of k. The next line contains a string having only 'a' and 'b'
as the characters.

Constraints
2 <= N <= 10^6

Output Format
A single integer denoting the maximum perfectness achievable.

Sample Input
2
abba

Sample Output
4

Explanation
We can swap the a's to b using the 2 swaps and obtain the string 'bbbb'. This would have all the b's and hence answer 4.
Alternatively, we can also swap the b's to make "aaaa". The final answer remains the same for both the cases.

 */



/*

 --------> Identifying Sliding Window and If sliding window occurs then Check whether we will use
           fixed size window or Variable size window.

 Step-1: Given String and k and some condition is given on k i.e we cannot filip more than 2 characters.
 Step-2 : Since, substring can be of any length i.e we will use Variable Size Sliding Window.


 Ex: String = a b b b a
     k = 2 ------> Maximum filip

     1. We are allowed to filip only 2 characters as k = 2.
        Filipping 1st and last 'b' with 'a'
        String = a a b a a
        So, Max length substring of equal characters i.e perfected string is aa
        So, 2

     2. Filipping first and second 'b'
        String = a a a b a
        so, Perfected string length = 3

     3. Filipping Both a's with b
        String = b b b b b
        so, Perfected string length = 5

        and so, on....

     But Max length substring of equal characters = 5


 */


/*

    String s = "a b b b a b a b b a a";
    int k = 3;

    Yaa fir toh main a filip karunga yaa fir b.

    So, Pehle a ko filip karke Perfected string nikaalengye.
        Similarly b ko filip karke Perfected string nikaalengye.

        Then, we compare the Max length of both the string Perfected Strings.


 */


/*

   Step-1 : First 0th character will be added to the window.
            s = "a b a b b b a b b a"
            k = 3



            ------------> Filliping "b"

            if(character == 'b')
               then filip_count += 1;
            else
              len += 1;


            window : "a"
            as character is "a" i.e donot filip
            filip_count = 0;
            len = 1
            ei += 1; i.e ei = 1


            window : "ab"
            as character is "b" i.e filip it.
            Ham real main filip nahi karengye bas uss ka count rakhhengye i.e we are not changing in the String
            filip_count = 1

            len = 2  ----> Agar main is 'b' ko 'a' se filip karta toh perfected window kii length 2 hoti i.e after filip "aa".
            ei += 1; i.e ei = 2

            window : "aba"
            as character is "a" i.e donot filip
            filip_count = 1;
            len = 3 ----> len will be updated.
            ei += 1; i.e ei = 3

            window : "abab"
            as character is "b" i.e filip
            filip_count = 2
            len = 4
            ei += 1; i.e ei = 4

            window : "ababb"
            as character is "b" i.e filip
            filip_count = 3
            len = 5
            ei += 1; i.e ei = 5

   ----->   window : "ababbb"
            as character is "b" i.e filip
            filip_count = 4 but filip_count > 3 so, shrink till filip becomes 3
            si += 1; i.e si = 1

            ---> Shrinking
            Remove "a" from the window i.e starting element of the window
            window : "babbb"
            filip_count = 4 but filip_count > 3 so, shrink more
            si += 1 i.e si = 2

            Similarly, Remove 1st element of the new window ("babbb")
            window : "abbb"
            filip_count = 3 so, no need to shrink more
            len = 4 ------> len will not updated as len = 4 is the max length till now.
            ei += 1 i.e ei = 6


            window : "abbba"
            as character is 'a' so, no need to filip
            len = 5;
            ei += 1; i.e ei = 7

            window : "abbbab"
            as character is 'b' so, we have to filip
            filip_count = 4 so, shrink till filip_count becomes 3
            si += 1; i.e si = 3

            window : "bbbab"
            again filip_count = 4; so, shrink more since, we have 4 b's in this window to filip.
            si += 1; i.e si = 4

            again shrink-->
            window : "bbab"
            filip_count = 3;
            len = 5; ---------------> But len will not update
            ei += 1; i.e ei = 8

            window : "bbabb"
            again character is 'b' i.e filip
            filip_count = 4; i.e filip > 3 so shrink
            si += 1; i.e si = 5

            window : "babb"
            filip_count = 3; now no need to shrink
            len = 5;
            ei += 1; i.e ei = 9


            window : "babba"
            as character is 'a' so, no need to filip
            filip_count = 3
            len = 5;
            ei += 1; i.e ei = 10

            window : "

            now, ei == string.length hence loop ends

            ans = 5



 */





public class Kartik_Bhaiya {

    public static void main(String[] args) {

        // String str = "ababbbabba";
        // String str = "ababbaaba";

        String str = "abababbabbbbbaaaa";
        int k = 3; // ----------------> Maximum we can filip 3 characters

        int filipa = MaxLengthPerfectedString(str , k , 'a');

        int filipb = MaxLengthPerfectedString(str , k , 'b');

        System.out.println(filipa + " " + filipb);

        int ans = Math.max(filipa , filipb);

        System.out.println(ans);
    }

    public static int MaxLengthPerfectedString(String s , int k , char ch){

        int si = 0;
        int ei = 0;

        int ans = 0;
        int filip_count = 0;

        while(ei < s.length()){

            // Growing the window
            // if current character matches with the ch then filip_count will be increamented
            if(s.charAt(ei) == ch){

                filip_count += 1;

            }


            // Shrinking the window
            while(filip_count > k && si <= ei){

                // If current character matches with the ch then filip_count will be decreamented by 1 as we are
                // removing it.
                if(s.charAt(si) == ch){

                    filip_count -= 1;

                }

                si += 1;
            }

            // ans calculating
            ans = Math.max(ans , (ei - si + 1));

            ei += 1;
        }

        return ans;
    }
}
