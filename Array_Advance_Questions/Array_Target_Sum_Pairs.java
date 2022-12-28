
/*

Take as input N, the size of array. Take N more inputs and store that in an array. Take as input “target”, a number.
Write a function which prints all pairs of numbers which sum to target.

Input Format
The first line contains input N. Next N lines contains the elements of array and (N+1)th line contains target number.

Constraints
Length of the arrays should be between 1 and 1000.

Output Format
Print all the pairs of numbers which sum to target. Print each pair in increasing order.

Sample Input
5
1
3
4
2
5
5

Sample Output
1 and 4
2 and 3

Explanation
Find any pair of elements in the array which has sum equal to target element and print them.



 */



/*

---------------------------------- Code Explanation -------------------------------------

M-1 :
Using Two loops


M-2 :

arr = {1 , 3 , 4 , 2 , 5}; and target = 5

Step - 1: Sort the array ----> 1 2 3 4 5

Step - 2: Take two pointers --->  i , j where i = 0 and j = n-1
          So, i at 1 and j at 5

Step - 3 : arr[i]  + arr[j] i.e 1 + 5 > target
           So, j -= 1 ----> Because value at j is greater

Step - 4 : Now , arr[i] + arr[j] i.e 1 + 4 == 5

           print(arr[i]) and print(arr[j])

           i += 1 and j -= 1;
           i.e i = 1 and j = 2;

Step - 5 : arr[i]  + arr[j] i.e 2 + 3 == target

           print(arr[i]) and print(arr[j])

           i += 1 and j -= 1;
           i.e i = 2 and j = 1;

           Since, i > j so, stop

 */


import java.util.Arrays;
import java.util.Scanner;

public class Array_Target_Sum_Pairs {

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

        TargetSum(arr , Target);

    }

    public  static void TargetSum(int arr[] , int Target){

        int i = 0;
        int j = arr.length - 1;

        while(i < j){

            if((arr[i] + arr[j]) == Target){

                System.out.println(arr[i] + " and " + arr[j]);

                i += 1;
                j -= 1;

            }
            else if((arr[i] + arr[j]) > Target){

                j -= 1;

            } else{

                i += 1;
            }

        }

    }
}
