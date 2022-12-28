
/*

Take as input N, the size of array. Take N more inputs and store that in an array.
Take as input “target”, a number. Write a function which prints all triplets of numbers which sum to target.

Input Format

First line contains input N.
Next line contains N space separated integers denoting the elements of the array.
The third line contains a single integer T denoting the target element.

Constraints
Length of Array should be between 1 and 1000.

Output Format
Print all the triplet present in the array in a new line each. The triplets must be printed as A, B and C where A,B and C are the elements of the triplet ( A<=B<=C) and all triplets must be printed in sorted order. Print only unique triplets.

Sample Input
9
5 7 9 1 2 4 6 8 3
10

Sample Output
1, 2 and 7
1, 3 and 6
1, 4 and 5
2, 3 and 5

Explanation
Array = {5, 7, 9, 1, 2, 4, 6 ,8 ,3}. Target number = 10. Find any three number in the given array which sum to target number.



 */

/*

---------------------------- Code Explanation --------------------------

Array : 5 7 9 1 2 4 6 8 3 and Target = 10

Sort the array :-

1 2 3 4 5 6 7 8 9

initially : i = 0 , j = 1 and k = 8 (n - 1)

Fix the i and use two pointer approach with the help of j and k on the left array i.e from j to k

So, while( j < k){

        Same as Array Target Sum Pairs
    }


 */




import java.util.Arrays;
import java.util.Scanner;

public class Array_Target_Sum_Triplets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n ; i++){

            arr[i] = sc.nextInt();

        }

        int Target = sc.nextInt();

        // Sorting the array
        Arrays.sort(arr);

        TargetSumTriplets(arr , Target);

    }


    public static void TargetSumTriplets(int arr[] , int Target){

        for(int i = 0; i < (arr.length - 2) ; i++){

            int j = i + 1;
            int k = arr.length - 1;

            while(j < k){

                if(arr[i] + arr[j] + arr[k] == Target){

                    System.out.println(arr[i] + " , " + arr[j] + " and " + arr[k]);

                    j += 1;
                    k -= 1;

                }else if(arr[i] + arr[j] + arr[k] > Target){

                    k -= 1;

                }else{

                    j += 1;
                }
            }
        }

    }
}
