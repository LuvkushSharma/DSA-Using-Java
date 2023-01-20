package MergeSort_Prerequisite;

// Merging two sorting array so that output array is also
// sorted.

/*

   Given two sorted arrays.

   {3 , 5 , 7 , 9 , 11}
   {1 , 2 , 3 , 4 , 6 , 7}

   final_ans = {1 ,2 , 3 , 3 , 4 , 5 , 6 , 7 , 7 , 9 , 11}

   M-1 : Merge both of them in a new array then use Arrays.sort()

         Time Complexity : O(nlogn)

   M-2 : Merge of them in a new array of the size : (n + m)
         Take two pointers one at the starting of arr1 and another
         at the starting of arr2.

       arr1 = {3 , 5 , 7 , 9 , 11}
          ^
          |
          i

       arr2 = {1 , 2 , 3 , 4 , 6 , 7}
          ^
          |
          j


       ans = { , , , , , , , , , , ,}
           ^
           |
           idx

       Step-1 :  Compare arr1[i] and arr2[j].
                 1 aur 3 main se pehle 1 ayyega.

                  j += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                         ^
                         |
                         i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                             ^
                             |
                             j


                 idx += 1;

                 ans = { 1 , , , , , , , , , , ,}
                          ^
                          |
                         idx


        Step-2 : Compare 2 and 3. Since 2 < 3 i.e add 2 in the ans array
                 j += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                         ^
                         |
                         i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                 ^
                                 |
                                 j


                 idx += 1;

                 ans = { 1 , 2 , , , , , , , , , ,}
                              ^
                              |
                             idx

         Step-3 : Compare 3 and 3. Since 3 == 3.
                  In this case we can increament any of the two pointers i.e either i or j.
                  j += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                         ^
                         |
                         i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                     ^
                                     |
                                     j


                 idx += 1;

                 ans = { 1 , 2 , 3 , , , , , , , , ,}
                                    ^
                                    |
                                   idx


           Step-4 : Compare 3 and 4. Since 3 < 4 i.e add 3 in the ans array
                 i += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                             ^
                             |
                             i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                     ^
                                     |
                                     j


                 idx += 1;

                 ans = { 1 , 2 , 3 , 3 , , , , , , , ,}
                                        ^
                                        |
                                       idx


           Step-5 : Compare 5 and 4. Since 5 > 4 i.e add 4 in the ans array
                 j += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                             ^
                             |
                             i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                         ^
                                         |
                                         j


                 idx += 1;

                 ans = { 1 , 2 , 3 , 3 , 4 , , , , , , ,}
                                            ^
                                            |
                                           idx


             Step-6 : Compare 5 and 6. Since 5 < 6 i.e add 5 in the ans array
                 i += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                                 ^
                                 |
                                 i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                         ^
                                         |
                                         j


                 idx += 1;

                 ans = { 1 , 2 , 3 , 3 , 4 , 5 , , , , , ,}
                                                ^
                                                |
                                               idx



              Step-7 : Compare 7 and 6. Since 7 > 6 i.e add 6 in the ans array
                 j += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                                 ^
                                 |
                                 i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                             ^
                                             |
                                             j


                 idx += 1;

                 ans = { 1 , 2 , 3 , 3 , 4 , 5 , 6 , , , , ,}
                                                    ^
                                                    |
                                                   idx



             Step-8 : Compare 7 and 7. Since 7 == 7 , so increament j. As we had decided earlier to move j in this case.
                 j += 1;

                 arr1 = {3 , 5 , 7 , 9 , 11}
                                 ^
                                 |
                                 i


                 arr2 = {1 , 2 , 3 , 4 , 6 , 7}
                                               ^
                                               |
                                               j


                 idx += 1;

                 ans = { 1 , 2 , 3 , 3 , 4 , 5 , 6 , 7 , , , ,}
                                                        ^
                                                        |
                                                       idx

                Step-9 : Add left elements of the arr1 in the ans array.

                         ans = { 1 , 2 , 3 , 3 , 4 , 5 , 6 , 7 , 7 , 9 , 11}


 */

public class Merge_two_sorted_array {

    public static void main(String[] args) {

       int arr1[] = {3 , 5 , 7 , 9 , 11};
       int arr2[] = {1 , 2 , 3 , 4 , 6 , 7};

       int ans[] = MergeTwoSortedArray(arr1 , arr2);

        System.out.print("{ ");
       for (int i = 0; i < ans.length ; i++) {

           System.out.print(ans[i] + " , ");
       }

        System.out.print(" }");
    }

    public static int[] MergeTwoSortedArray(int arr1[] , int arr2[]) {

             int n = arr1.length;
             int m = arr2.length;

             int ans[] = new int[n+m];

             int i = 0; // arr1
             int j = 0; // arr2
             int idx = 0; // ans

             while (i < n && j < m) {

                 if (arr1[i] < arr2[j]) {

                      ans[idx] = arr1[i];

                      i += 1;
                      idx += 1;

                 } else {

                     ans[idx] = arr2[j];

                     j += 1;
                     idx += 1;

                 }
             }

             while (i < n) {

                 ans[idx] = arr1[i];
                 i += 1;
                 idx += 1;

             }

             while (j < m) {

                 ans[idx] = arr2[j];
                 j += 1;
                 idx += 1;
             }

             return ans;
    }
}
