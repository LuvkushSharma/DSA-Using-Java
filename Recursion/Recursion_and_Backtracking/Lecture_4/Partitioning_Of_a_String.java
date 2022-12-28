package Recursion_and_Backtracking_4;

public class Partitioning_Of_a_String {

    public static void main(String[] args) {

        String s = "NitiN";

        PrintPartition(s , "");
    }

    public static void PrintPartition(String ques , String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        for (int i = 1; i <= ques.length() ; i++){

            // Pehle N jaayega ans main aur i t i N --> ques main jaayega.
            // Fir Ni ans main and t i N --> ques main jaayega.
            PrintPartition(ques.substring(i) , ans + ques.substring(0 , i) + "| ");

        }
    }
}
