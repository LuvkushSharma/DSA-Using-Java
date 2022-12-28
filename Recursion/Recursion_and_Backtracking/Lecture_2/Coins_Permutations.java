package Recursion_and_Backtracking_2;

//  We have infinite supply of coins and by using these coins we have to print all these
// permutations to make a given amount.


// Not a Backtracking problem.
// After visualizing the intuition we get to know that their is no need of
// backtracking in this problem.

public class Coins_Permutations {

    public static void main(String[] args) {

        int coins[] = {2, 3, 5, 6};
        int amount = 10;

         // PrintPermutation(coins , amount , "");

        // Using backtracking
        PrintPermutationBacktrack(coins , amount , "");

    }


    // Isme reccursion hee puura UNDO kar raha hain so , no need of backtracking
    public static void PrintPermutation(int coins[] , int amount , String ans){

        // Base case
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        // Jitne coins utni possibility
        // Infinite supply hain isliye baar baar i = 0 se suru kiya hain.
        for (int i = 0; i < coins.length ; i++){

            if(amount >= coins[i]){

                PrintPermutation(coins , amount - coins[i] , ans + coins[i]);
            }
        }
    }


    // In this we are required to backtrack
    public static void PrintPermutationBacktrack(int coins[] , int amount , String ans){

        // Base case
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        // Jitne coins utni possibility
        // Infinite supply hain isliye baar baar i = 0 se suru kiya hain.
        for (int i = 0; i < coins.length ; i++){

            if(amount >= coins[i]){

                amount -= coins[i];
                PrintPermutation(coins , amount, ans + coins[i]);

                // Function frame main agar pehle amount kii value X thii aur hamne
                // recursive call se pehle agar uski value change kar dii thii i.e (X - Y) aur
                // hame call se aane ke baad X hee chaiye thii then we will do backtrack
                // i.e (X - Y + Y) ----> X
                amount += coins[i]; // Backtrack
            }
        }
    }

}
