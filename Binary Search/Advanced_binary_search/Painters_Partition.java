package Advance_Binary_Search;

/*

Given K painters to paint N boards where each painter takes 1 unit of time to paint 1 unit of boards i.e. if the length of a particular board is 5, it will take 5 units of time to paint the board. Compute the minimum amount of time to paint all the boards.

Note that:

Every painter can paint only contiguous segments of boards.
A board can only be painted by 1 painter at maximum.
Input Format
First line contains K which is the number of painters. Second line contains N which indicates the number of boards. Third line contains N space separated integers representing the length of each board.

Constraints
1 <= K <= 10
1 <= N <= 10
1<= Length of each Board <= 10^8

Output Format
Output the minimum time required to paint the board.

Sample Input
2
2
1 10
Sample Output
10



 */

import java.util.Scanner;

public class Painters_Partition {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0;i < n;i++)
        {
            arr[i] = sc.nextInt();
        }
        long ans = Min_time(arr,k);
        System.out.println (ans);
    }
    public static long Min_time(int arr[],int k)
    {
        long low = 0l;
        long high = 0l;
        for(int i = 0 ; i < arr.length ; i++)
        {
            high += arr[i];
        }

        long ans = 0l;
        while(low <= high)
        {
            long mid = (low + high)/2l;

            System.out.println(mid + " unit length board is tried to painted.");

            if(isitpossible(arr,mid,k) == true)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isitpossible(int arr[],long mid,int k)
    {
        int painter = 1;
        long paint_kiya = 0l;

        for(int i = 0;i < arr.length;)
        {

            // Each painter will paint "mid" length of board.
            if(paint_kiya + arr[i] <= mid)
            {
                paint_kiya += arr[i];
                i++;
            }
            else
            {
                paint_kiya = 0;
                painter++;
            }
            if(painter > k) {

                System.out.println("Painters needed in case of " + mid +" are : " + painter);
                return false;
            }

        }
        return true;
    }
}
