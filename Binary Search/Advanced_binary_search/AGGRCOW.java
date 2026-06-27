package Advance_Binary_Search;
/*

 ------------------------------- AGGRCOW - Aggressive cows ------------------------------------
#binary-search
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1 ... xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Example
Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.



 */

/*

  ------------ Hame 3 Cows ko 5 stalls i.e 5 tabele par baithaana hain. ------------


  -----
      |
      |
      V
  Tabele at position.

  -----------------------------------------------------------------------
  |           |           |                      |                      |
  1           2           4                      8                      9

  --------------------- Let's say minimum distance = 1
                                                                    ------------
  Pehli aur dusri cow ke beech main 1 hain distance ko dikkat nhi.  1          2

                                                                    -----------
  Fir cow at position 2 and 4 kii duuri bhi minimum 1 hain.         2          4

  So, 1 minimum distance toh fit baith gaya

  --------------------- Let's take minimum distance = 2

  Cow-1 position-1 par hain and cow-2 position-2 par toh inke beech kaa distance 1 hain but we had decided the minimum distance as 2.

  So, Cow-2 ko position 4 par baitha do i.e dusre tabele par baitha do. Now, Inke beech kaa distance minimum 2 se jaada ho gaya i.e koi dikkat nhi.

  Similarly, Cow-2 and Cow-3 kaa distance 4 hain i.e minimum distance fulfilled.

  ----------------
  4              8
 Cow-2          Cow-3

  Sabhi cow sahi tabele yaani stall par baandh dii hain.

  --------------------- Let's take minimum distance = 3

  Cow 1 position-1 par hain and cow-2 position-2 par toh inke beech kaa  minimum distance i.e 3 fulfilled nhi kar raha i.e
  Cow-2 ko dusre tabele par bhejo. Now Cow-1 and Cow-2 kee beech kaa distance 3 ho gaya

  ---------------
  1              4
 Cow-1         Cow-2

 Now, Cow-3 at position-8 i.e Cow-2 and Cow-3 kee beech kaa distance  4 hain i.e Minimum distance fullfilled.

 --------------------- Let's take minimum distance = 4

 Cow 1 position-1 par hain and cow-2 position-2 par toh inke beech kaa distance minimum distance i.e 4 fulfilled nhi kar raha i.e
 Cow-2 ko dusre tabele par betha do i.e Tabela at position-4. Again distance between Cow-1 and Cow-2 is less than required minimum
 distance. So, Cow-2 ko agle tabele par betha do i.e Tabela at position-8. Now distance is maintained.

 But, Cow-3 position-9 par hee baith sakti hain i.e ladaai ho kar rahegyi. Hence

 Max (1, 2 , 3) = 3

 i.e ans = 3


 */

/*

 ------------------------------ Intuition -------------------------------------------------

 Step-1 : Starting main dono Cow ko end points par baitha do.

 Cow-1 ko Position-1 par baitha do and Cow-2 ko Position-9 par maan lo kii beth gayi

 -----------------------------------------------------------
 |                                                         |
 Cow-1                                                    Cow-2

                      Distance = 8

 Answer exists karta hoga toh Position-1 par hamesha ek Cow jaruur bathegyi. As maximum distance will be maintained.


 low = 1 and high = 9

 For , maintaining largest Possible distance Cow-1 and Cow-3 & Cow-3 and Cow-2

 mid = 1+9/2

 mid = 5

 Matlab , minimum Cow ke beech main distance 5 rakhte hain. But check karo kya minimum distance 5 possible hain kya.

 i.e abb Baithaana Chaalu karo using isPossible()

 ----------------------------------------------------------
 |                                               |        |
 1                                               8        9
 Cow-1                                          Cow-2   Cow-3

 Cow-3 nhi baith paayegyi.

 -------- Agar 5 possible nhi hain toh usse aagye waale bhi possible nhi hongye. Hence , hame minimum distance kam karna padega.

   so, high = mid-1

   i.e low = 1 and high = 4

   mid = 1+4/2 = 2

   So, minimum distance 2 maintain karte hue Cows ko baithaana hoga.

   so, cow-2 ko 1 se 4 tak cow-2 ko baitha do.

   ---------------------------------------------------
   |                        |                        |
   1                        4                        8
  Cow-1                     Cow-2                  Cow-3

  So, 2 ke liye baithaa paa rahe hain.
  i.e Agar 2 par possible hain toh uske peeche bhi possible hoga.

  Kya aur paas baitha sakte hain ?.

  i.e low = mid+1 = 3

  so, mid = 3+4/2 = 3

  i.e abb Minimum distance 3 try karo.


  ----------------------------------------------
      |                 |                      |
      1                 4                      8
     Cow-1             Cow-2                  Cow-3

     Now , again low = mid+1 i.e aur possibility check karo.

     low = 4 and high = 4

     mid = 8/2 = 4


     ---------------------------------------------------
     |                      |
     1                      4
    Cow-1                  Cow-2


   Not possible for 4


 */


import java.util.Arrays;
import java.util.Scanner;


public class AGGRCOW {

    public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          int nos = sc.nextInt(); // number of stalls
          int noc = sc.nextInt(); // number of cows

        int stall[] = new int[nos];

        for (int i = 0; i < nos ; i++) {

            stall[i] = sc.nextInt();
        }

        // Sorting the stall
        Arrays.sort(stall);

        System.out.println(MinDistance (stall , noc));

    }

    public static int MinDistance (int stall[] , int noc) {

        int low = stall[0];
        int high = stall[stall.length - 1];
        int ans = 0;

        while (low <= high) {

            int mid = (low + high)/2;

            if (isitPossible (stall , noc , mid) == true) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }

        }

        return ans;
    }

    public static boolean isitPossible (int stall[] , int noc , int mid) {

        // Pehli Cow 0 position par baitha do.
        // Iske baad distance check kar the i.e Cow-1 and Cow-2
        // then Cow-2 and Cow-3 kaa distance check karo.

        int pos = stall[0];

        int cowsCount = 1; // ek cow baith chuki hain

        // Next tabele se cows ko baithaana suru karengye
        for (int i = 1 ; i < stall.length; i++) {

            // Let's say mid = 2
            // Cow-1 at 1 and Cow-2 at 2
            // i.e 2 - 1 >= 2 -------> false

            // Cow-1 at 1 and Cow-2 at 4
            // i.e 4 - 1 >= 2 ---------> true
            // So, abb Cow-3 and Cow-2 ke beech kaa distance dekhengye i.e pos = 4 ho jaaye.
            if (stall[i] - pos >= mid) {

                cowsCount += 1;
                pos = stall[i];
            }

            // All cows sitted successfully.
            if (cowsCount == noc) {

                return true;
            }

        }

        return false;
    }
}
