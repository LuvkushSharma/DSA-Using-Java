package Lecture_5;

public class Lexico_Counting {

    public static void main(String[] args) {

        int n = 1000;
        printCounting(0,n);

    }

    public static void printCounting(int curr , int end){

        // Base case
        // If number greater than 1000 then return as we donot cross the end num.
        if(curr > end){
            return;
        }

        System.out.println(curr);
        int i = 0;

        // If 0 is their then we have to run the loop  9 times
        if(curr == 0){
            i = 1;
        }

        // We will move from 0 to 1 and 1 to 10 and 10 to 100 using below formula :-
        // (curr * 10 + i)

        // This loop will run for 9 times if curr_um is 0 els eit will run for
        // 10 times if number is not equal to 0.
        for (; i <= 9; i++){

            printCounting(curr*10 + i, end);
        }
    }
}
