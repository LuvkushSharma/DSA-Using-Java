
/*


Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character
in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

 */



/*

 Ye given hain kii hame window banaani hain i.e no need to check whether we need to use the sliding window or not.

 We will use the variable length sliding window.

 -----> First count the frequency of the characters of the string t.

 -----> s ke characters kii frequency nikaalo aur if that characters occurs in "t" then increase the count.

 -----> If count reaches to the t.length then shrink the window

 s = "D   B   A  E  C  B  B  A  B  D  C  A  A  F  B  D  D  C  A  B  G  B  A"
 t = "A  B  B  C  D  C"


 // Jaise hee t kaa koi character s main mil jaayega tab count increament kar do.
 count = 0;

 frequency of characters of the string t :-
 A -> 1
 B -> 2
 C -> 2
 D -> 1

 start = 0;
 end = 0;

 Note :  when count == t.length() then start shrinking

 Step-1 : first D is encounter in string s and D is also in the string t i.e count += 1 and end = 1 now
          count of D is : 1
          window : D

 Step-2 : Now, B is encounter in string s and B is also in the string t i.e count += 1 and end = 2 now
          count of B is : 1
          window : D B

 Step-3 : Now, A is encounter in string s and A is also in the string t i.e count += 1 and end = 3 now
          count of A is : 1
          window : D B A

 step-4 : Now, E is encounter in string s and E is not in the string t so match count will not increase and end = 4 now.
          count of E is : 1
          window : D B A E

 step-5 : Now, C is encounter in string s and C is also in the string t i.e count += 1 and end = 5 now
          count of C is : 1
          window : D B A E C

 step-6 : Abhi tak hame 1 hee B milaa tha hame ek aur B bhi chaiye thaa jo kii abb mil gaya hain. count += 1 i.e 5 and end = 6 now
          count of B is : 2 ----> requirement of B is fullfilled in s to match with string t.
          window : D B A E C B

 step-7 : Now, B is encountered in string s at index 6 but B's requirement is fulfilled already. As we want two B's in the window
          so, that it will match with the string t. Hence we will acquire this B but match count will not increase. end = 7
          count of B is : 3
          window : D B A E C B B

  step-8 : Now, A is encountered but A's requirement is already fulfilled since we need only one A in our window.
           hence we will acquire this but match count will not increase. end = 8
           count of A is : 2
           window : D B A E C B B A

  step-9 : Now, again B is encountered but B's requirement is already fulfilled since we need only two B in our window.
           hence we will acquire this but match count will not increase. end = 9
           count of B is : 4
           window : D B A E C B B A B

  step-10 : Now, D is encountered but D's requirement is already fulfilled since we need only one D in our window.
           hence we will acquire this but match count will not increase. end = 10
           count of D is : 2
           window : D B A E C B B A B D

  step-11 : Now, C is encounter in string s and we need  2 --> C in our window. So, increament count i.e count = 6.
            count of C is : 2
            window : D B A E C B B A B D C

            Now stop acquiring as count == t.length() it means we got our required window which contains all the characters
            that are present in the string t.

            Hence start shrinking to make the window of minimum length.

            Shrinking : Release D , start = 1 now and end = 11 and count of D : 1 now
                        B A E C B B A B D C and still match count = 6.

                        Release B , start = 2  and count of B : 3 now
                        A E C B B A B D C and still match count = 6.

                        Release A and start = 3 and count of A : 1 now
                        E C B B A B D C and still match count = 6.

                        Release E and start = 4 and count of E : 0 now
                        C B B A B D C and still match count = 6.

                        Release C and by releasing match count decreases by 1 as we had lost kaam kaa banda.
                        Hence stop releasing when count < t.length()

            Ans till now :  C B B A B D C


   step-12 : Now, A encounters but match count remains same as A's requirement is fullfilled.
             count of A is : 2
             window : C B B A B D C A

   step-13 : Now, A encounters but match count remains same as A's requirement is fullfilled.
             count of A is : 3
             window : C B B A B D C A A

   step-14 : Now, F encounters but we donot need F i.e count remains same.
             count of F is : 1
             window : C B B A B D C A F

   step-15 : Now, B encounters but we donot need B as it's requirement is already fulfilled i.e count remains same.
             count of B is : 4
             window : C B B A B D C A F B

   step-16 : Now, D encounters but we donot need B as it's requirement is already fulfilled i.e count remains same.
             count of D is : 2
             window : C B B A B D C A F B D

   step-17 : Now, D encounters but we donot need B as it's requirement is already fulfilled i.e count remains same.
             count of D is : 3
             window : C B B A B D C A F B D













 */




public class Leetcode_76 {

    public static void main(String[] args) {


         String s = "ADOBECODEBANC";
         String t = "ABC";

        System.out.println(MinimumWindow(s, t));


    }

    public static String MinimumWindow(String s , String t){

        int frqt[] = new int[123];

        // If 'A' occurs then increase its frequency on index - 65
        // If 'a' occurs then increase its frequency on index - 97

        for(int i = 0; i < t.length() ; i++){

            char ch = t.charAt(i);

            // ch index par ch kii frequency bhada dii
            frqt[ch] += 1;
        }

        int frqs[] = new int[123];

        int si = 0;
        int ei = 0;

        int start = -1; // if start = -1 hee raha end tak iska matlab hame t ke sabhi characters mile hee nhi.
        int len = Integer.MAX_VALUE;
        int count = 0;

        while(ei < s.length()){

            // Grow the window
            // s main se ek character nikaalo
            char ch = s.charAt(ei);

            // uski frq bhada do
            frqs[ch] += 1;

            if(frqt[ch] >= frqs[ch]){

                count += 1;

            }

            // Shrink the window
            if(count == t.length()) {

                while(frqs[s.charAt(si)] > frqt[s.charAt(si)] && si <= ei){

                    frqs[s.charAt(si)] -= 1;
                    si += 1;
                }

                // ans calculating
                // Jab window maintain ho gaya tha
                if(len > ei - si + 1){

                    len = ei - si + 1;
                    start = si;
                }
            }



            ei += 1;
        }

        if(start == -1){

            return "";
        }

        return s.substring(start , start + len);
    }
}
