package Lecture_1;

import java.util.Scanner;

public class Power {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans = power(a,b);

        System.out.println(ans);

    }

    public static int power(int a, int b){

        // Base case
        if(b == 0){
            return 1;
        }

        int ans = power(a, b-1); // a^b-1

        return a*ans;
    }

}
