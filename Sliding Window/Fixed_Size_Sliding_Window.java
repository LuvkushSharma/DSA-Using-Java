
/*

Sliding window is a technique to solve array and string problems


  Array : {2 , 1 ,3 , 5 , 1 , 2 , 1 ,  7 , 8 , 2 , 4}

  Find the k size array whose sum is maximum.


  -----> Input : Array and k
  -----> Output : k size maximum subarray or k size minimum subarray

  Input main Array and string with a value is given and Some condition is applied on the value or max aur min kii
  baat hogyi yaa fir combined condition hogyi.

  Output main subarray yaa fir substring maanga jaayega.

  Jab input main array aur k diyaa ho aur output main subarray puuchi ho with some condition then Sliding window is applied.
  Since size of the window is fixed i.e fixed size sliding window.

  Types of sliding window :-

  1. Fixed size Sliding Window
  2. Variable size Sliding Window



 ---------------------------------- Fixed size Sliding Window --------------------------------------

          Step-1: Indentifying whether sliding window can be applied on this problem or not.

          -----------> Since, Array is given and a value is also given here i.e k = 3 and
                       some condition is also applied on the subarray. Hence, it is a problem of
                       Sliding window.

          Step-2: If sliding window is applied then check which type of Sliding window we should use.

          ----------> Here size of the subarray is fixed i.e k size i.e we will use Fixed size sliding window in
                      that case.

          Array : {2 , 1 ,3 , 5 , 1 , 2 , 1 ,  7 , 8 , 2 , 4}
          k = 3   size kaa woh subarray batao jiska sum maximum ho.
          i.e condition on subarray is given.

          Step-1 : Find the first k size window sum  i.e 2 + 1 + 3
          Step-2 : Grow the window by adding one element in the window and then shrink the window
                  2  1  3  5

          ----->  Pehle ek element add karo k size window main i.e 5 aur ek element nikaaldo i.e 2  becoz 4 size
                  kii window ban gayi aur banni thi 3 kii.
                  (2+1+3) + 5 - 2 i.e 6 + 5 - 2 = 9

          ----->  Pehle ek element add karo k size window main i.e 1 aur ek element nikaaldo i.e 1
                  1  3 5  1
                  (9) + 1 - 1  = 9

          ----->  Pehle ek element add karo k size window main i.e 2 aur ek element nikaaldo i.e 3
                  3  5  1  2
                  (9) + 2 - 3 = 8

          ----->  Pehle ek element add karo k size window main i.e 1 aur ek element nikaaldo i.e 5
                  5 1 2 1
                  8 + 1 - 5 = 4

          ----->  Pehle ek element add karo k size window main i.e 7 aur ek element nikaaldo i.e 1
                  1  2   1  7
                  4 + 7 - 1 = 10

          ----->  Pehle ek element add karo k size window main i.e 8 aur ek element nikaaldo i.e 2
                  2   1   7  8
                  10 + 8 - 2 = 16

          ----->  Pehle ek element add karo k size window main i.e 2 aur ek element nikaaldo i.e 1
                  1  7   8  2
                  16 + 2 - 1 = 17

          ----->  Pehle ek element add karo k size window main i.e 4 aur ek element nikaaldo i.e 7
                  7  8  2  4
                  17 + 4 - 7 = 14


                  Ans = 17   -----> Maximum sum of a  k size subarray.


 ------------------------------------------- Dry Run -----------------------------------------------------

          Step  - 1:

                  {2 ,     1 ,     3 , 5 , 1 , 2 , 1 ,  7 , 8 , 2 , 4}
                   |               |
                   -----------------
                           |
                    First k = 3 size
                        window

                    So, initially max = 2 + 1 + 3 = 6


           Step - 2:

                   {2 ,  1 ,     3 ,        5 , 1 , 2 , 1 ,  7 , 8 , 2 , 4}
                         |                  |
                         --------------------
                                  |
                             Now, 5 will be added to the previous sum
                             and 2 will be deducted


           Step - 3:

                   {2 ,  1 ,   3 ,      5 ,       1 , 2 , 1 ,  7 , 8 , 2 , 4}
                               |                  |
                               --------------------
                                        |
                             Now, 1 will be added to the previous sum
                             and 1 will be deducted


          and so on....


 */


public class Fixed_Size_Sliding_Window {

    public static void main(String[] args) {

          // int arr[] = {1,4,5,6,7,8,2,3,9,1,2,5};

           // Array and k is given with some condition i.e max subarray of k size 3
          //  i.e window size is fixed hence fixed size sliding window will be used.

          int arr[] = {2 , 1 ,3 , 5 , 1 , 2 , 1 ,  7 , 8 , 2 , 4};

          int k = 3;

          int ans = Maximum_Sum(arr , k);

          System.out.println(k + " size subarray maximum sum : " + ans);

    }

    public static int Maximum_Sum(int arr[] , int k){

        // Initializing the max and sum as 0
        int max = 0;
        int sum = 0;

        // First k element kaa sum nikaalo  i.e forming first window
        for (int i = 0; i < k ; i++){

            sum = sum + arr[i];
        }

        // Assigning max as the First window sum
        max = sum;

        // Abb window ko grow karo then shrink it and then compare sun with max
        for (int i = k; i < arr.length ; i++){

            // Growing the window i.e adding next element in the window
            sum = sum + arr[i];

            // Shrinking the window i.e window size kam hua hain by removing first element of the previous window.
            // Since, window size should be k i.e we have to remove one element.
            sum = sum - arr[i - k];

            // Comparing the Max sum till now and current sum.
            max = Math.max(max , sum);

        }

        return max;
    }
}
