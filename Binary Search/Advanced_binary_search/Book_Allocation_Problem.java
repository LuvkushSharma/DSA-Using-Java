
/*

Link : https://code-gym.codingblocks.com/problems/1365

Book Allocation Problem
You are given number of pages in n different books and m students.
The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books.
The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.


Input format

First line contains integer t as number of test cases.
Next t lines contains two lines.
For each test case, 1st line contains two integers n and m which represents the number of books and students and 2nd line contains n space separated integers which represents the number of pages of n books in ascending order.


Output format

Print the maximum number of pages that can be assigned to students.


Example 1

Input

1
4 2
12 34 67 90


Output

113


Explanation

1st students : 12 , 34, 67 (total = 113)

2nd students : 90 (total = 90)

Print max(113, 90)


Constraints

1 < t < 50

1< n < 100

1< m <= 50

1 <= Ai <= 1000


 */

/*

  Pages : 10    20    30     40
  Books : B1    B2    B3     B4

  Let's say we have two students.

  S1 donot reads the book so, S2 have to read 100 pages i.e all the books
  S1 reads 10 pages of the book so, S2 have to read 90 pages
  S1 reads 30 pages of the book so, S2 have to read 70 pages
  S1 reads 60 pages of the book so, S2 have to read 40 pages

  So, maximum pages reads are 100 , 90 , 70 and 60
  i.e Jab S1 0 pages read kiya tab S2 100 kiya thaa i.e Max = 100
      Jab S1 10 pages read kiya tab S2 90 Kiya i.e Max = 90
      Jab S1 30 pages read kiya tab S2 70 kiya i.e Max = 70
      Jab S1 60 pages read kiya tab S2 40 kiya i.e Max = 60


  min ( 100 , 90 , 70 , 60 ) => 60

  Note : Consecutive read karaana hain i.e
  Jab S1 ne 10 pages of Book1 pade and Book1 khatam ho gayi then S2 Book2 se hee padega i.e Book3 yaa fir Book4 par jump nhi kar sakta.



 */

/*

  --------------------------- Intuition -------------------------

  Total pages = 10 + 20 + 30 + 40 ===> 100

  Max pages read by the students can be 100.

  low = 0
  i.e high = 100

  mid = 50

  -----> Maine maximum limit 50 set kari hain i.e 50 se jaada koi baccha nhi karega

  ------------------------------------------
  |                   |           |
  10                  20          30
 S1                   S1          s1 <----- 60 pages nhi read kar sakta

  ------------------------------------------
  |                   |           |        |
  10                  20          30       40
 S1                   S1          s2       s2 <---- 70 pages nhi ek student nhi read kar sakta i.e we need more students par woh hainn nhi isliye no.pages to read bhaada do.



  Maximum limit 50 rakhte hue Maximum limit follow nhi ho rahi.

  low = mid+1 ===> low = 51

  mid = 51+100/2  ====> 75

  Now, maximum limit is 75

  ------------------------------------------
  |                   |           |        |
  10                  20          30       40
  S1                  S1          s1       s2 <----------- S1 nhi read kar sakta but s2 kar sakta hain.

  now , see the minimum pages read
  high = mid-1 ======> high = 74

  mid = 51+74/2 ===> 62


 */


package Advance_Binary_Search;

import java.util.Scanner;

public class Book_Allocation_Problem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int PagesPerBook[] = new int[n];

        for (int i = 0; i < n ; i++) {

            PagesPerBook[i] = sc.nextInt();
        }

        System.out.println(MinPage(PagesPerBook , m));

    }

    public static int MinPage (int page[] , int nos) {

        int low = 0;
        int high = 0;

        // Sum of pages i.e Total Pages
        for (int i = 0; i < page.length ; i++) {
            high += page[i];
        }

        int ans = 0;
        while (low <= high) {

            int mid = (low + high)/2;

            if (isitPossible (page , nos , mid) == true) {

                ans = mid;
                high = mid - 1; // Go for more mimimum number of pages that a student can read

            } else {

                low = mid + 1; // Number of pages per student bhaadao
            }
        }

        return ans;
    }

    public static boolean isitPossible (int page[] , int nos , int mid) {


        int Student = 1;
        int readed_pages = 0;

        for (int i = 0; i < page.length ; i++) {

            // S1 ne initially 10 page read kare koi dikkat nhi
            // When S1 reads 10+20 i.e 30 so, koi dikkat nhi
            // Fir jab S1 tries to read 30+30 i.e 30 dikkat hain
            // i.e Student kii shankhyaa bhaada do and
            if (readed_pages + page[i] <= mid) {

                readed_pages += page[i];

            } else {

                Student += 1;
                readed_pages = page[i];
            }

            if (Student > nos) {

                return false;
            }
        }

        return true;
    }
}
