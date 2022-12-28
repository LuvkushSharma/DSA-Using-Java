package Recursion_and_Backtracking_1;

// First refer to the Queen Permutation on Board

public class Queen_Combination_On_Board {

    public static void main(String[] args) {

        int n = 4;
        int num_of_queen = 2;

        // Stores kii queen kaha kaha par baith chuki hain.
        // boolean array is initialized by false (By default)
        boolean board[] = new boolean[n];

        Queen(board , num_of_queen , 0 , "" ,0);

    }

    public static void Queen(boolean board[] , int total_queen , int qpsf , String ans , int idx){

        /*

           qpsf : Queen placed soooo far

         */

        // Base case
        if(total_queen == qpsf){
            System.out.println(ans);
            return;
        }

       // Iss baar idx se suru hoga
        // i.e last time queen jaha se baith rhi hain usse aagye baiitha raha huun
        for (int i = idx; i < board.length ; i++){

            // it means queen placed nhi hain i.e enter the loop
            if(board[i] == false){

                // Placing queen
                board[i] = true;

                // ek queen baithaa dii isliye qpsf += 1
                // i+1 isliye kiya becoz q0 agar ith board par baithi hain toh bachi queens (i+1)th par baithengyi to give combinations.
                Queen(board , total_queen ,qpsf + 1 , ans + "b" + i + "q" + qpsf + " ",i+1);

                board[i] = false;
            }
        }


    }
}
