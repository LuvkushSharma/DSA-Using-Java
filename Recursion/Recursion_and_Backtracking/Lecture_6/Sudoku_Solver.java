package Recursion_and_Backtracking_6;

public class Sudoku_Solver {

    public static void main(String[] args) {

        int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        sudokuSolver(grid , 0 , 0);
    }

    public static void sudokuSolver(int[][] grid , int row , int col){

        // column end ho chuke hain isliye
        // abb agli row par jao aur firse col = 0 kardo
        if (col == 9) {
            row++;
            col = 0;
        }

        // Sabhi row filled ho chuki hain iska matlab
        // Abb Updated grid ko Display kardo.
        // Aur return ho jao.
        if (row == 9) {
            Display(grid);
            return;
        }

        // It means place already filled hain i.e
        // Agle place par jao i.e move in right or move on agla cell.
        if (grid[row][col] != 0) {
            sudokuSolver(grid, row, col + 1);

        }

        else {

            // In place of 9 recursive calls
            // we are trying to put recursive call ina loop
            // which itself calls for 9 times in each function frame.
            for (int val = 1; val <= 9 ; val++){

                // grid bhej do , position of value aur value bhi bhej do
                // Aur check karo kii main value jo rakh raha huun woh rakh paunga.
                // Check karo uss value ko in the same row , same column and in the 3 X 3
                // matrix.
                // Agar sahi hain toh rakh dunga.
                if(isitPossible(grid , row , col , val) == true){

                         // Value rakhna possible hain itmeans value rakh do.
                         grid[row][col] = val;
                         // Agye move kardo value fill karke
                         sudokuSolver(grid , row , col + 1);

                         // Backtrack
                         // Jaise kii jab main 6 ke baad koi number nhi fill kar paa
                         // raha thaa. Tab main peeche jaa raha thaa aur again fill
                         // kar raha tha. Toh again fill karne ke liye waha par 0 hona chaiye
                         // Isliye ham akhir main waapis 0 fill kar de rahe hain recursive function
                         // call hone ke baad.
                         grid[row][col] = 0;
                }

            }

        }


    }

    public static boolean isitPossible(int grid[][] , int row , int col , int val) {

        // Same row main check kar rahe hain
        int c = 0;
        while (c < 9) {

            // If val is present in the row = row and column = c then return false
            // i.e we cannot fill that place by val.
            if (grid[row][c] == val) {
                return false;
            }
            c++;
        }


        // Same column main check kar rahe hain.
        int r = 0;
        while (r < 9) {

            // If val is present in the column = col and row = r then return false
            // i.e we cannot fill that place by val.
            if (grid[r][col] == val) {
                return false;
            }
            r++;
        }


        // Now check in the (3 X 3) matrix
        // Hame , koi bhi row kaa index aur koi bhi column kaa index given hoga
        // Par hame starting of 3 X 3 matrix se suru karna hain check karna.
        // i.e Ex : we are at (3,7) and find the starting of 3 X 3 matrix for this particular index.
        // And we will find it by this formula.
        // r = 3 - 0 => 3
        // c = 7 - 1 => 6
        // i.e (3,6) is the starting of the  3 X 3 matrix in which (3,7) is present.
        r = row - row % 3;
        c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }

            }

        }


        // Same row , Same column aur same 3 X 3 matrix
        // main check karne ke baad main safe huun i.e Iss particular
        // row index , column index par ham value rakh sakte hain as it
        // is not present in the row = row , column = col
        // and also not present in the 3 X 3 matrix in which we are
        // going to fill 0 by val.
        return true;
    }

    public static void Display(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();

        }

    }
}
