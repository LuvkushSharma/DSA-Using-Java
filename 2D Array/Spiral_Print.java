public class Spiral_Print {

    public static void main(String[] args) {


        int arr[][] = new int[5][4];

        int num = 1;

        // Putting elements in the 2D array.
        for(int i = 0; i < arr.length ; i++){

            for(int j = 0; j < arr[0].length ; j++){

                arr[i][j] = num;
                num += 1;
            }
        }

        for(int i = 0; i < arr.length ; i++){

            for(int j = 0; j < arr[0].length ; j++){

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");

        // Spiral Print Approach :-
        // 1. Print Starting row and move starting row to next row.
        // 2. Print Ending column and move ending column to the left column.
        // 3. Print Ending row and move ending row to the upper row.
        // 4. Print Starting column and move starting column to the right column.

        //  1   2   3
        //  4   5   6
        //  7   8   9

        // Print Starting row i.e 1 2 3 then move starting row to the next below row i.e 1
        // Now, print ending column i.e 6 9 (We have moved the row at 1 already in the above case i.e 3 will not be printed). Ending column = 1 now.
        // Print ending row now i.e 7 8 (9 will not be printed as ending column is upto 8 only). Ending row = 1 now.
        // Print starting column i.e 4. And starting column now will be 1.
        // Repeat this process.


        // Time complexity : O(n X m)
        SpiralPrinting(arr);
    }

    public static void SpiralPrinting(int arr[][]){

        int row = arr.length;
        int col = arr[0].length;

        int count = 0;
        int Total = row*col; // Total elements

        // indexes initialization
        int starting_row = 0;
        int ending_column = col - 1;
        int ending_row = row - 1;
        int starting_col = 0;

        // Loop runs till all the elements will not be printed
        while (count < Total){

            // Print starting row
            for(int index = starting_col ; count < Total && index <= ending_column ; index++){

                System.out.print(arr[starting_row][index] + " ");
                count += 1;

            }

            // Moving starting row to the bottom row
            starting_row += 1;

            // Print ending column
            for(int index = starting_row ; count < Total && index <= ending_row ; index++){

                System.out.print(arr[index][ending_column] + " ");
                count += 1;

            }

            // Moving ending column to the left
            ending_column -= 1;

            // Print ending row
            for(int index = ending_column ; count < Total && index >= starting_col  ; index--){

                System.out.print(arr[ending_row][index] + " ");
                count += 1;

            }

            // Moving ending row to the just upper row
            ending_row -= 1;


            // Print starting column
            for(int index = ending_row ; count < Total && index >= starting_row ; index--){

                System.out.print(arr[index][starting_col] + " ");
                count += 1;

            }

            // Moving starting column to the right
            starting_col += 1;

        }


    }
}
