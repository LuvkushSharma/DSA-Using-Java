package Lecture_4;

public class Permutation_Of_A_String {

    public static void main(String[] args) {

        String s = "abcd";

        printPermutation(s , "");
    }

    public static void printPermutation(String ques , String ans){

        // Base case
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        // Jitne characters bache hongye utni baar recursive call karna hoga
        // i th character ko ans main add kardo aur i th character se pehle aur
        // baad waale characters ko ek saath concatenate kar do aur fir
        // ques main daal do.
        for (int i = 0; i < ques.length() ; i++){

            // ith character ko ans main add kardo.
            char ch = ques.charAt(i);

            // ith character kii pehli waali string aur ith character kii baad string
            // ko concatenate kardo.
            String new_ques = ques.substring(0 , i) + ques.substring(i+1);

            printPermutation(new_ques , ans + ch);
        }

    }

}
