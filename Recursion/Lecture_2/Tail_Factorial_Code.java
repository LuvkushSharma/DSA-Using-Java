package Lecture_2;

import java.util.Scanner;

public class Tail_Factorial_Code {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        int ans = fact(n , 1);

        System.out.println(ans);


    }


    public static int fact(int n , int ans){

        // Base case
        if(n == 1){

            return ans;
        }

        // After recursive call immediate return i.e Tail recursion.
        return fact(n-1 , ans*n);
    }
}
