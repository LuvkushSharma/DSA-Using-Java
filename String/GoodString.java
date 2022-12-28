
// A Good string is a string which contains only vowels (a,e,i,o,u). Given a string S, print a single positive integer
// N where N is the length of the longest substring of S that is also a Good String.

// Input String:
// A string 'S'

// Output:
// A single positive integer N, where N is the length of the longest sub-string of S that is also a Good string.


// Sample Input:
// cbaeicde


// Sample Output
// 3


// Explanation :
// aei and ei are the two good strings.
// But aei is the longest substring.


// Logic : Skip for the consonents and move forward


/*

         ------------------------------------- Dry Run ----------------------------------------

         count = 0;
         ans = 0;
         int i = 0;

         "c b a i e u k l a e"

         Step-1: 'c' is the consonant so, count remains same. and i += 1 i.e i = 1
         Step-2 : 'b' is the consonant so, count remains same and i += 1 i.e i = 2
         Step-3 : 'a' is a vowel so, count += 1 i.e count = 1 , and i += 1 i.e i = 3
         Step-4 : 'i' is a vowel so, count += 1 i.e count = 2 , and i += 1 i.e i = 4
         Step-5 : 'e' is a vowel so, count += 1 i.e count = 3 , and i += 1 i.e i = 5
         Step-6 : 'u' is a vowel so, count += 1 i.e count = 4 , and i += 1 i.e i = 6
         Step-7 : 'k' is the consonant so, go to else block , ans = 4 now and count = 0 again and i += 1 i.e i = 7
         Step-8 : 'l' is the consonant so, count remains same and i += 1 i.e i = 8
         Step-9 : 'a' is a vowel so, count += 1 i.e count = 1 , and i += 1 i.e i = 9
         Step-10 : 'e' is a vowel so, count += 1 i.e count = 2 , and i += 1 i.e i = 10

         Now, the loop ends.

         ans = max(4 , 2) ==> 4

         ans = 4;

 */

public class GoodString {

    public static void main(String[] args) {

        String str = "cbaieuklae";

        System.out.println(PlayWithGoodString(str));

    }


    public static int PlayWithGoodString(String str){

        int ans = 0;
        int count = 0;

        for (int i = 0; i < str.length() ; i++){

            char ch = str.charAt(i);

            if(isVowels(ch) == true){

                count += 1;

            }else{

                ans = Math.max(count , ans);
                count = 0;
            }
        }

        ans = Math.max(count , ans);

        return ans;
    }

    public static boolean isVowels(char ch){

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){

            return true;
        }

//        Otherwise it is a consonant
        return false;
    }
}
