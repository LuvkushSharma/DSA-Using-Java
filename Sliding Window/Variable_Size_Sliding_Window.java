

// ------------------------------ Variable Size Sliding Window ---------------------------------

/*

Step-1 : First identify whether it is a question of Sliding window or not.
Step-2 : Then, Check window size is fixed or not. If k size window is said then apply
         Fixed size window else apply variable size window.

 */

/*

Q : Subarray Product Less Than k

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the
product of all the elements in the subarray is strictly less than k.


Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

 */


/*

  ------------------------------------- Important --------------------------------------


  Identifying Sliding Window :
  As, array is given and some value k is given and we have to find the number of subarrays and Condition on k is given
  (window of product less than k ----> Condition)  i.e Sliding window is applied.


  Variable size sliding window : Upar waali problem main subarray ke size ke baare main kuch nhi bola gaya
                                 i.e it does not belongs to fixed size sliding window.
                                 Hence, it belongs to the variable size window.

  Intuition :  Take two pointers si (Window start point) and ei (Window end point) and initialize them with 0.

              while(ei < arr.length){
                   // Window grow

                   // Window shrink if needed i.e if condition breaks then shrink the window till condition is followed.

                   // ei += 1;
               }


      ------------------ Dry Run ------------------
      arr : 1  2  4   3  2
      k = 10

      ----------> Initializing Two pointers
                  si on 1 and ei on 1
                  i.e si = 0 and ei = 0

     Step-1:
     window ---> 1 (grow) and (Product is maintained i.e not crossing 10 nor equal to 10) i.e Shrinking is no longer nedeed.
                 now ei on 2.
                 count += 1; ------> window having product less than 10

     Step-2:
     window ---> 1 2 (Product maintained) so, shrinking not required now ei on 4.
                 count += 1;

     Step-3:
     window ---> 1 2 4 (Product maintained) so, shrinking not required now ei on 3.
                 count += 1;

     Step-4:
     window ---> 1 2 4 3 (Product not maintained i.e 10 < 24) so, shrink till product becomes less than 10 so, si on 2.

                 Shrinking the window till window not in range:
                 24/1 = 24 ---> Removing 1 but still window product is not less than k i.e not maintained so, shrink more
                                si += 1 i.e si on 2

                 24/2 = 12 ---> Removing 2 but still window product is not less than k i.e not maintained so, shrink more
                                si += 1 i.e si on 4

                 12/4 = 3  ---> Removing 4 and now product is less than k and si += 1 i.e si on 3

                 we have single element in the Subarray i.e 3 (Product Maintained)
                 count += 1;
                 now ei on 2

      window -----> 3 2 (Product maintained) so, no need to shrink.
                    count += 1;
                    now ei crosses the array length hence stop the process.

            And, ans = 6


 */


/*

       ans = 0 ------> We will add the number of contiguous subarrays in this

       1.
          Window grow :
          Array :   {1 , 2 , 3 , 4 , 2 , 3}
                     |
                  si and ei

         Window product (1) < 10 so, no need to shrink the window

         ans += 1  ----> Because 1 se sirf ek hee subarray banega
         i.e ei += 1


      2.
         Window grow :
         Array :   {1 , 2 , 3 , 4 , 2 , 3}
                    |   |
                  si    ei

         Window product (1 , 2) < 10 so, no need to shrink the window

         ans += 2 ----------> Because 1, 2 se 2 new subarray banengye i.e 2 and 1,2
                              since, 1 was already counted i.e we will not consider that.

         i.e ei += 1


      3.
         Window grow :
         Array :   {1 , 2 , 3 , 4 , 2 , 3}
                    |       |
                  si        ei

         Window product (1 , 2 , 3) < 10 so, no need to shrink the window

         ans += 3 ------> {2,3} , {1,2,3} and 3
         i.e ei += 1


     4.
        Window grow :
        Array :   {1 , 2 , 3 , 4 , 2 , 3}
                    |          |
                  si           ei

         Window product (1 , 2 , 3 , 4) > 10 so, we have to shrink the window.
         Array :   {1 , 2 , 3 , 4 , 2 , 3}
                        |       |
                        si      ei
         Window product (2,3,4) > 10 so shrink more

         Array :   {1 , 2 , 3 , 4 , 2 , 3}
                            |   |
                           si   ei

         Window product (3,4) > 10 so shrink more



         Array :   {1 , 2 , 3 , 4 , 2 , 3}
                                |
                             si and ei
         Window product (4) < 10 so no  need to shrink more

         ans += 1 -------> {4}
         i.e ei += 1


      5.
        Window grow :
        Array :   {1 , 2 , 3 , 4 , 2 , 3}
                               |   |
                             si    ei

         Window product (4 , 2) < 10 so no  need to shrink

         ans += 2 ----------> {4,2} and {2}
         i.e ei += 1


     6.
       Window grow :
        Array :   {1 , 2 , 3 , 4 , 2 , 3}
                               |       |
                             si        ei

         Window product (4 , 2 , 3) > 10 so we have to shrink the window.
         Array :   {1 , 2 , 3 , 4 , 2 , 3}
                                    |   |
                                    si  ei

          Window product (2,3) < 10 so no need to shrink more

          ans += 2 ----------> {2,3} and {3}
          i.e ei += 1


     7.
       Window grow:
       Array :   {1 , 2 , 3 , 4 , 2 , 3}
                                  |      |
                                  si     ei


       Loop will not run now.

       --------> ans = 11



 */


/*

------------------------------------- Important --------------------------------------

----------------> Why :  (si <= ei)  in the shrinking phase.

     When

     Ex : arr = {1 , 2 , 3}
          k   =  0

          Step-1 : {1 ,   2 ,  3}
                    |
                si and ei

                Product not maintained  (1) >= 0 so, shrink the array.

                Product = 1/1;
                si += 1;

                {1 ,   2 ,  3}
                 |     |
                 ei    si

                Product not maintained (1) >= 0 so, shrink the array.
                Product = 1/2 => 0
                si += 1;

                {1 ,   2 ,  3}
                 |          |
                 ei         si


                Product not maintained (0) >= 0 so, shrink the array.
                Product = 0/3 => 0
                si += 1;

                {1 ,   2 ,  3}
                 |              |
                 ei             si

                 Product = 0/arr[si]

                 Now, product /= arr[si] gives error
                 since, si is the index which is out of bound of the array hence it will give.
                 Runtime error.


                 i.e we have added a condition : si <= ei


 */


public class Variable_Size_Sliding_Window {

    public static void main(String[] args) {

//        int arr[] = {1,2,4,3,2};
//        int k = 10;

//        int arr[] = {10,5,2,6};
//        int k = 100;

//        int arr[] = {1 , 2 , 3 , 4 , 2 , 3};
//        int k = 10;

          int arr[] = {1 ,2 , 3};
          int k = 0;

        int ans = CountSubArray(arr , k);

        System.out.println(ans);

    }

    public static int CountSubArray(int arr[] , int k){


        int si = 0;
        int ei = 0;

        int ans = 0;
        int product = 1;

        while(ei < arr.length){

            // Window grow
            product *= arr[ei];

            // Shrinking window if needed i.e when condition is not followed
            while(product >= k && si <= ei){

                product /= arr[si];
                System.out.println(product);
                si += 1;

            }

            // adding the number of contiguous subarrays where the product of all the elements in the subarray is
            // strictly less than k.
            // (ei - si + 1) is the size of the window.
            ans = ans + (ei - si + 1);   // ---------> i.e adding the size of the window

            ei += 1;
        }

        return ans;
    }
}
