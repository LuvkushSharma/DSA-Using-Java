
/*

You are provided n numbers (both +ve and -ve). Numbers are arranged in a circular form.
You need to find the maximum sum of consecutive numbers.

Input Format
First line contains integer t which is number of test case.
For each test case, it contains an integer n which is the size of array and next line contains n space separated integers
denoting the elements of the array.

Constraints
1<=t<=100
1<=n<=1000
|Ai| <= 10000

Output Format
Print the maximum circular sum for each testcase in a new line.

Sample Input
1
7
8 -8 9 -9 10 -11 12

Sample Output
22

Explanation
Maximum Circular Sum = 22 (12 + 8 - 8 + 9 - 9 + 10)


 */


/*

Represent all the numbers of the array on the circle and we can go to the index-0 from the last index of the array.

---> arr : -2   -3  5   -7   -4
     In the above array we get the max sum = 5 in the linear

---> arr : 2  3   -5   -7   11   2    3

     Linear main Max sum : 11 + 2 + 3
     Circular main Max sum :  11 +  2 +  3 +  2  + 3

     So, in this array we get the max sum from the circular array.

 */

import java.util.Scanner;

public class Maximum_Circular_Sum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n ; i++){

                arr[i] = sc.nextInt();
            }

            int ans = MaxSubarraySum(arr);

            System.out.println(ans);
        }
    }

    public static int MaxSubarraySum(int arr[]){

        // Ek answer linear se mangaa lo aur ek answer circular se jo max ho usse return kar do.

        int linear_kadane = Kadane(arr);

        /*

        In case of circular sum :

        Agar main array ko open karu toh beech kaa part negative sum de raha hoga usse hame hataana hain i.e

        arr : 2  3   -5   -7   11   2    3  -----> Here -5 and -7 is the middle part of the array which contributes negative sum.

        Step-1 : Take the sum of whole array : (2 + 3 -5 -7 + 11 + 2 + 3) = 3

        Step-2 : To remove the middle part just invert the sign of the array i.e
                 -2   -3    5    7    -11   -2    -3

                 If we apply kaden's on this array then we will get the sum of the middle part i.e (5 + 7)

                 Then add this sum to the whole array sum to get the Circular sum.


         */

        // Getting the total sum of the array and inverting the array
        int Total_array_sum = 0;

        for(int i = 0; i < arr.length ; i++){

            Total_array_sum += arr[i];

            // Inverting the sign of the element
            arr[i] = -1 * arr[i];
        }

        int Inverted_array_sum = Kadane(arr);

        // Removing/Cancelling the middle part sum
        int Circular_sum = Total_array_sum  + Inverted_array_sum;


        // Now, Comparing the linear sum and Circular sum

        int ans = Math.max(linear_kadane , Circular_sum);

        return ans;
    }

    public static int Kadane(int arr[]){

          // Applying Kaden's algo for assuming array as linear

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length ; i++){

            sum += arr[i];
            ans = Math.max(sum , ans);

//           Jab total sum negative ho jaayega tabhi sum ko zero karengye.
            if(sum < 0){
                sum = 0;
            }

        }

        return ans;
    }
}
