package Lecture_2;

public class Subsequence {

    public static void main(String[] args) {

        String s = "abc";

        PrintSubsequence(s , "");
    }

    public static void PrintSubsequence(String ques , String ans){

        if(ques.length() == 0){

            System.out.println(ans);
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
}
