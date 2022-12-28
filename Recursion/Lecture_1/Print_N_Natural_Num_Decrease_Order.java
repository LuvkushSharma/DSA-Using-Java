package Lecture_1;

import java.util.Scanner;

// Print the number in the decreasing order
public class Print_N_Natural_Num_Decrease_Order {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Printing(n);

    }

    public static void Printing(int n){

        // Base case
        if(n == 0){

            return;
        }

        // Print the number
        System.out.println(n);

        // Decrease the number
        Printing(n-1);
    }
}
