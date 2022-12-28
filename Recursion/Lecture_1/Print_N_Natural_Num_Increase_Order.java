package Lecture_1;

import java.util.Scanner;

// Print the number in the increasing order
public class Print_N_Natural_Num_Increase_Order {

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

        // Decrease the number
        Printing(n-1);

        // Pehle Call Stack Bharega fir jaise hee n == 0 ho jaayega fir
        // Call stack khaali hoga aur print hoga.

        // Print the number
        System.out.println(n);
    }
}
