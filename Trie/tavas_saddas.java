/*
https://codeforces.com/problemset/problem/535/B

Once again Tavas started eating coffee mix without water! Keione told him that it smells awful, but he didn't stop doing that.
That's why Keione told his smart friend, SaDDas to punish him! SaDDas took Tavas' headphones and told him: "If you solve the
following problem, I'll return it to you."


The problem is:

You are given a lucky number n. Lucky numbers are the positive integers whose decimal representations contain only the lucky
digits 4 and 7. For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.

If we sort all lucky numbers in increasing order, what's the 1-based index of n?

Tavas is not as smart as SaDDas, so he asked you to do him a favor and solve this problem so he can have his headphones back.

Input
The first and only line of input contains a lucky number n (1 ≤ n ≤ 109).

Output
Print the index of n among all lucky numbers.

Examples
input
4
output
1

input
7
output
2

input
77
output
6


 */

/*

Lucky no. woh hoga jisme sirf 4 and 7 hee hongyee.

------> Lucky numbers in the increasing order :-

---->     4  7  44  47  74  77  444   447   474
Posn      1  2   3   4   5   6   7     8     9

Ex : find the posn of 47477


Generate toh nhi kar skate iska Trie khud se because bahut saare numbers ho sakte.

But , we can count 47477 se chote numbers and usme +1 kar dunga toh 47477 kii posn aa jaeygyi.

i.e. count kar lengye 1 --> length main kitne ayengye , 2 length main kitne ayenge ,....


          _       2^1

      _       _    2^2


      1 length main 4 hoga yaa fir 7
      hame (n-1) length ke numbers count karne hain.


 2^1  + 2^2 + 2^3 + .... + 2^n-1 -------> GP series

  2 (2^n - 1)
  -----------  ====> 2(2^n-1 - 1)  =====> 2^n - 2
     2 - 1

     i.e. (n-1)th length tak kaa number of lucky numbers : 2^n - 2 hain

     abb hame ye count karna hain kii 47477 i.e. 5 length ke isse chotte kitne words bana sakte hain.

     4     7      4      7     4     7
                                     | posn = 0
                                     v
                                 isse main 4 karta huun toh 1 number banega as no posn khaali after this i.e. 2^0  and posn + 1

   4     7      4      7     4     7
                             |
                             v
                             no change but posn = 2


   4     7      4      7     4     7
                       |
                       V
                       yaha agar 4 dalengye toh iske peeche jo vacant hain i.e. 2^3 numbers banengye chotte.

   i.e. 7 ke peeche jitne places hain utni 2 kii power chote words banengye.



 */

public class tavas_saddas {

    public static void main(String[] args) {

        String str = "47477";

        System.out.println(TavasSaDDas(str));
    }

    public static int TavasSaDDas (String str) {

        int n = str.length();
        int count = (1 << n) - 2; // 2^n - 2

        int posn = 0;
        for (int i = str.length() - 1 ; i >= 0 ; i--) {

            if (str.charAt (i) == '7') {

                count += (1 << posn); // 7 ke peeche kitne vacant space hain
            }

            posn += 1;
        }
       return count + 1;

    }
}
