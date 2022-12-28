package Lecture_4;

public class Modified_Permutation_Of_a_String {

    public static void main(String[] args) {

        String s = "abca";

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
            boolean flag = true;

            // Check karo agar ith character agye mill raha hain toh
            // recursive call mat karo becoz it will create duplicate permutation.
            // Aur agar mujhe nhi milaa toh
            // flag <- True rahega i.e recursive call karengye.
            for (int j = i+1 ; j < ques.length() ; j++){

                if(ques.charAt(j) == ch){
                    flag = false;
                    break;
                }
            }

            if(flag){

                String new_ques = ques.substring(0 , i) + ques.substring(i+1);
                printPermutation(new_ques , ans + ch);
            }

        }

    }
}
