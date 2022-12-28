package Recursion_and_Backtracking_5;

import java.awt.*;

public class N_Queen {

    public static void main(String[] args) {

          int n = 4;

          // Jaha par queen bhethengyi usse mark kar dengye True se
          boolean board[][] = new boolean[n][n];

          PrintPath(board , 0 , n);
    }

    public static void PrintPath(boolean board[][] , int row , int total_queen) {

        // Base case : Sbahi queens safely baith gayi
        if(total_queen == 0){

            Display(board);
            return;
        }

        // Queen boundary paar nhi kar sakti board kii.
        if(row == board.length){

            return;
        }

        // Har ek queen col = 0 se baithegyi.
        // aur  agar column = col par safe nhi hain toh agle column par bethengyi. i.e
        // ham queen ko right main shift kar rahe the naa jab tak woh boundary cross
        // naa kare. To find the possibilities
        // Aur jitne column utne hee queen ke paas chances to move in the right direction.
        for (int col = 0; col < board.length ; col++){

            // Kya queen ko baithaana possible hain.
            // Kya uss cell main baithaana possible hain
            // i.e 8 direction main check karna
            if(isitPossible(board , row , col) == true){

                // Yes ,  possible
                // so, mark that place as True and call for another queen
                // queen ko baithaa do safe hain jagye.
                board[row][col] = true;
                PrintPath(board , row + 1 , total_queen - 1);

                // UNDO : Backtrack
                // For more possible ways we will undo mark
                // agar (0,1) se aur path ban sakte hain toh
                board[row][col] = false;
            }
        }

    }

    public static boolean isitPossible(boolean board[][] , int row , int col){

         // ----------------- Upper Direction -----------------
            // Upar waali direction ke liye code
           //  Iss direction maj
            int r = row;

            // Upar waali direction main row vary kar raha hain aur column
           //  same hain.
            while (r >= 0) {

                // Queen baithi hain
                if(board[r][col] == true){
                    return false;
                }

                r -= 1;
            }

         // ------------------- Upper left Diagonal Direction -----------------

            r = row;
            int c = col;

            // row aur col dono kam hongye
            while (r >= 0 && c >= 0){

                // Queen baithi hain
                if(board[r][c] == true){
                    return false;
                }

                r -= 1;
                c -= 1;

            }

        // ------------------- Upper right Diagonal Direction -----------------

        r = row;
        c = col;

        // row kam hogyi aur col increament hoga.
        while (r >= 0 && c < board[0].length){

            // Queen baithi hain
            if(board[r][c] == true){
                return false;
            }

            r -= 1;
            c += 1;

        }

        // Baithaana safe hain
        // teeno direction check karli
        return true;

    }

    public static void Display(boolean board[][]){

        for(int i = 0; i < board.length ; i++){

            for(int j = 0; j < board[0].length ; j++){

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("**************************************\n");
    }
}
