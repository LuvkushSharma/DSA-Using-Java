
// GFG Statement :-

// ---------- Search in a row wise and column wise sorted matrix -----------

// Given a m x n matrix and a number x, find the position of x in the matrix if it is present int it.
// Otherwise, print "Not Found".
// In the given matrix, every row and column is sorted in increasing order.

// Leetcode Statement :-

// Write an efficient algorithm that searches for a target value in an m X n integer matrix.
// The matrix has the following properties.

// -----> Integers in each row are sorted in ascending from left to right.
// -----> Integers in each column are sorted in ascending from top to bottom.



// Below Approach is the optimal soln for gfg and better soln for leetcode.

//      10   20  30  40
//      11   21  36  45
//      25   29  39  50
//      50   60  70  80

// Target = 25


// Fixed our pointer to 40 and bottom numbers are more than 40 and left numbers are less than 40.
// As, 25 is less than 40 i.e move our pointer to the left. As, 25 is less than 30 i.e move the pointer to the left again.
// Since, 25 is more than 20 i.e move pointer to the bottom. As, 21 is also less than 25 i.e again move the pointer to the bottom.
// As, 29 is more than 25 so, move the pointer to the left.
// As, 25 == 25. Hence target is found.

// And if the pointer moves out of bound to the matrix then the item is not found.


// Below soln also works for the Leetcode Search in 2 matrix Level 2.

public class Search_in_2D_Matrix_3_Level_2 {

    public static void main(String[] args) {

        int[][] arr = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };

        int item = 12;
        Search(arr, item);
    }

    public static void Search(int arr[][] , int item){

        // Initially pointer is at 1st row and last column.
        int row = 0;
        int column = arr[0].length - 1;

        while(row < arr.length && column >= 0){

            if(arr[row][column] == item){

                System.out.println(item + " found at (" + row + " , " + column + ")");
                return;
            }

            if(arr[row][column] > item){

                column -= 1; // Move to the left.

            }else{

                row += 1; // Move to the bottom.
            }
        }

        System.out.println(item + " is not found.");
    }
}
