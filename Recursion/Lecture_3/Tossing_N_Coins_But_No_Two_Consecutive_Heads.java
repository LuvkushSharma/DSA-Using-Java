package Lecture_3;

public class Tossing_N_Coins_But_No_Two_Consecutive_Heads {

    public static void main(String[] args) {

        int N = 3;

        Cointoss(N , "");
    }

    public static void Cointoss(int n , String ans){

        if(n == 0){

            System.out.println(ans);
            return;
        }

        // If last character is H then donot go for this recursive call.
        if(ans.length() == 0 || ans.charAt(ans.length() - 1) != 'H'){
            Cointoss(n-1 , ans + "H");
        }

        Cointoss(n-1 , ans + "T");

    }
}
