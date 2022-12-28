package Lecture_5;

public class Tower_Of_Hanoi {

    public static void main(String[] args) {

        int n = 3;

        // Sending 'n' number of discs , to the rods named as source , helper and destination.
        printSteps(n,"src","hel","des");

    }

    public static void printSteps(int n , String s, String h, String d){

        // s is src , h is hel and d is des

        // Base case
        if(n == 0){
            return;
        }

        // Starting kii (n-1) discs ke liye helper "des" waali rod hogyi
        // aur destination : helper waali rod hogyi.
        printSteps(n-1,s , d , h);

        System.out.println("Move "+ n +"th disc from "+ s + " to " + d);

        // Moving (n-1) discs from helper to the destination.
        printSteps(n-1,h , s , d);


    }
}
