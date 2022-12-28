package Lecture_2;

// In case of recursion if we have to print and count simultaneously then we will
// create a global variable for the count :- M-1

//

public class Count_Number_Of_Subsequences {

    // Global variable :- Always written inside the class not a function
    static int count = 0;

    public static void main(String[] args) {

        String s = "abc";

        // 1st way
//        PrintSubsequence(s , "");
//        System.out.println(count);

        int count = PrintSubsequence1(s , "");
        System.out.println("\n"+count);
    }

    // 1st way by creating a global variable
    /*
    public static void PrintSubsequence(String ques , String ans){

        if(ques.length() == 0){

            System.out.println(ans);
            count += 1;
            return;
        }

        // Pehle a niklega fir b then c
        char ch = ques.charAt(0);

        // Two possibilities :-

        // char add mat karo
        PrintSubsequence(ques.substring(1) , ans);

        // char add kardo
        PrintSubsequence(ques.substring(1) , ans + ch);

    }

    */

    // 2nd way
    public static int PrintSubsequence1(String ques , String ans){

        if(ques.length() == 0){

            System.out.print(ans + " ");
            return 1;
        }

        // Pehle a niklega fir b then c
        char ch = ques.charAt(0);

        // Two possibilities :-

        // char add mat karo
        int ct1 = PrintSubsequence1(ques.substring(1) , ans);

        // char add kardo
        int ct2 = PrintSubsequence1(ques.substring(1) , ans + ch);

        return ct1 + ct2;

    }
}
