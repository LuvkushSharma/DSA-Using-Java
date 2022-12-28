package Lecture_3;

public class Possible_Outcomes_After_Tossing_N_Coins {

    public static void main(String[] args) {

        int N = 3;

        Cointoss(N , "");
    }

    public static void Cointoss(int n , String ans){

        // If number of coins left is 0 then print the ans and then return.
         if(n == 0){

             System.out.println(ans);
             return;
         }

         // Two possibilities :-

         // Add head
         Cointoss(n-1 , ans + "H");
         // Add tail
         Cointoss(n-1 , ans + "T");

    }
}
