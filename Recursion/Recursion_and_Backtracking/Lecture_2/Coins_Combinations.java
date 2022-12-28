package Recursion_and_Backtracking_2;

public class Coins_Combinations {

    public static void main(String[] args) {

        int coins[] = {2, 3, 5, 6};
        int amount = 10;


        PrintCombination(coins , amount , "" , 0);

    }

    // Isme reccursion hee puura UNDO kar raha hain so , no need of backtracking
    public static void PrintCombination(int coins[] , int amount , String ans , int idx){

        // Base case
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        // Jitne coins utni possibility
        // Infinite supply hain isliye baar baar i = 0 se suru kiya hain.
        for (int i = idx; i < coins.length ; i++){

            if(amount >= coins[i]){

                PrintCombination(coins , amount - coins[i] , ans + coins[i] , i);
            }
        }
    }
}
