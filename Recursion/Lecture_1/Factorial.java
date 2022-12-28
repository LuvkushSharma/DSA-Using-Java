package Lecture_1;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        int ans = fact(n);

        System.out.println(ans);


    }


    public static int fact(int n){

        // Base case
        if(n == 1){

            return 1;
        }

        // Recursive call
        int fn = fact(n-1);

        return n*fn;
    }

}

