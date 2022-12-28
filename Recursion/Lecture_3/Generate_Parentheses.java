package Lecture_3;

public class Generate_Parentheses {

    public static void main(String[] args) {

        int n = 3;

        Valid_Parentheses(n , 0 , 0 , "");
    }

    public static void Valid_Parentheses(int n ,int opening , int closing ,String ans){

        // Base case
        if(opening == n && closing == n){

            System.out.println(ans);
            return;
        }

        if(opening < n){

            Valid_Parentheses(n , opening+1, closing,ans+"(");
        }

        // Agar closing bracketes kam hain opening brackets se toh closing bracket laga do
        if(closing < opening){

            Valid_Parentheses(n , opening , closing+1,ans+")");
        }
    }
}
