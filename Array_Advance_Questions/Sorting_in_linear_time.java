
/*

You will be given an array containing only 0s, 1s and 2s. you have sort the array in linear time that is O(N)
where N is the size of the array.

Input Format
The first line contains N, which is the size of the array. The following N lines contain either 0, or 1, or 2.

Constraints
1 <= N <= 10^6
Each input element x, such that x ∈ { 0, 1, 2 }.

Output Format
Output the sorted array with each element separated by a newline.

Sample Input
5
0
1
2
1
2

Sample Output
0
1
1
2
2

 */


/*

Dutch National Flag (DNF) - It is a programming problem proposed by Edsger Dijkstra.
The flag of the Netherlands consists of three colors: white, red, and blue.
The task is to randomly arrange balls of white, red, and blue in such a way that balls of the same color are placed together.
For DNF (Dutch National Flag), we sort an array of 0, 1, and 2's in linear time that does not consume any extra space.
We have to keep in mind that this algorithm can be implemented only on an array that has three unique elements.

ALGORITHM -
Take three-pointers, namely - low, mid, high.
We use low and mid pointers at the start, and the high pointer will point at the end of the given array.
CASES :
If array [mid] = 0, then swap array [mid] with array [low] and increment both pointers once.
If array [mid] = 1, then no swapping is required. Increment mid pointer once.
If array [mid] = 2, then we swap array [mid] with array [high] and decrement the high pointer once.


 */

//--------------------------- Dutch National Flag Algorithm (DNF) ------------------------------


/*

0 aur 2 ko correct position par laayengye aur 1 ape aap correct posn par aa jaayega.

Step-1 : Take two pointers left and right
         left = 0 and right = arr.length - 1

         ---> Left is used for 0's and right is used for 2's

         2 ko ham right main bhejengye yaani last main aur 0 ko starting main.


          ARR : 2  0   2   1    1  0   1  2

          int mid = 0;
          right = 7;

Step-2 :  if(arr[i] == 2)
            then swap(arr[i] , arr[7]);
                 right -= 1; --------------------> Agli baar 2 arr.length - 2 par aayega.

          We donot shift the 'i' becoz hame nhi pata kii jo number hamne swap kiya hain woh 0 hain kii 2. Agar 2 hua
          toh fir se swapping higyi.


Step-3 :  if(arr[i] == 2)
            then swap(arr[i] , arr[6]);
                 right -= 1; ------> i.e right = 5

          Arr now :   1  0   2   1    1  0   2  2


          -------> i = 1

Step-4 :  if(arr[i] == 1)    -------> 1 ke liye toh kuch sochna hee nhi hain
              then, i += 1;


Step-5 :  if(arr[i] == 0)
              then swap(arr[i] , arr[left]);
              left += 1;
              i += 1; ------> Becoz jo number maine swap kiya hoga woh 1 hee hoga.

           Arr now :   0  1   2   1    1  0   2  2

Step-6 :  if(arr[i] == 2)
             then swap(arr[i] , arr[right]);
             right -= 1;


             Arr now :   0  1   0  1   1  2   2  2


Step-7 : if(arr[i] == 0)
            then swap(arr[i] , arr[left]);
            left += 1;
            i += 1;


            Arr now :   0  0   1  1   1  2   2  2





 */

import java.util.Scanner;

public class Sorting_in_linear_time {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n ; i++){

            arr[i] = sc.nextInt();
        }

        Sorting(arr);

        // Printing the sorted array
        for(int i = 0; i < n ; i++){

            System.out.print(arr[i] + " ");
        }

    }

    public static void Sorting(int arr[]){

        int left = 0;
        int right = arr.length - 1;

        int mid = 0;

        while(mid <= right){

            if(arr[mid] == 2){

                int temp = arr[mid];
                arr[mid] = arr[right];
                arr[right] = temp;

                right -= 1;

            }else if(arr[mid] == 0){

                int temp = arr[mid];
                arr[mid] = arr[left];
                arr[left] = temp;

                left += 1;
                mid += 1;

            }else{

                mid += 1;
            }
        }
    }
}
