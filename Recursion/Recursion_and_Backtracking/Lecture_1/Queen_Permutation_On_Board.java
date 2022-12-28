package Recursion_and_Backtracking_1;

/*

Recursive function call karne se pehle jo function frame main values thii
kya woh recursive call end hone ke baad bhi same hain kii nhi
Agar nhi hain aur hame Original form main chaiye then we apply
Backtracking so that changes UNDO ho jaaye.

 */

public class Queen_Permutation_On_Board {

    static int Count_arrangement = 0;

    public static void main(String[] args) {

        int n = 4;
        int num_of_queen = 2;

        // Stores kii queen kaha kaha par baith chuki hain.
        // boolean array is initialized by false (By default)
       boolean board[] = new boolean[n];

       Queen(board , num_of_queen , 0 , "");

        System.out.println("\n" + "Total Queen Arrangements : " + Count_arrangement);

    }

    public static void Queen(boolean board[] , int total_queen , int qpsf , String ans){

        /*

           qpsf : Queen placed soooo far

         */

        // Base case
        if(total_queen == qpsf){
            System.out.println(ans);
            Count_arrangement += 1;
            return;
        }

        // Jitna board kaa size utni choice i.e 4 size ke board par q0 ke paas 4 choices hain.

        for (int choice = 0 ; choice < board.length ; choice++){

            // it means queen placed nhi hain i.e enter the loop
            if(board[choice] == false){

                // Placing queen
                board[choice] = true;

                // ek queen baithaa dii isliye qpsf += 1
                Queen(board , total_queen ,qpsf + 1 , ans + "b" + choice + "q" + qpsf + " ");

                // Baapas board khaali karengye
                // Recursion implicitly backtrack kar raha hain par ham forcefully backtrack karengye.
                // i.e changes UNDO karengye : Backtracking
                // After calling forcefully UNDO kar rahe hain.
                board[choice] = false;
            }
        }


    }
}
