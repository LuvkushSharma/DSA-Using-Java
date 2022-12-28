
// Since above approach is better for leetcode but not optimal i.e we assume the 2D matrix into 1D
// and applying binary search on it.

// Write an efficient algorithm that searches for a value target in an m x n integer matrix.
// This matrix has the following properties:

// ----->  Integers in each row are sorted from left to right.
// ----->  The first integer of each row is greater than the last integer of the previous row.


//      1    3   5   7
//      10   11  16  20
//      23   30  34  50


// Target = 30


// Assigned index to all the numbers i.e 1 is at index 0 , 3 is at 1 , .... 7 at 3,
// 10 at 4, 11 at 5 ,... 20 is at 7, 23 at 8,....

//  Index :    0   1   2   3   4   5   6   7   8   9   10  11
//  values :   1   3   5   7   10  11  16  20  23  30  34  50

// Now Assume this 2D array as 1D sorted array. Hence apply Binary search in this case.

// low = 0 and high = arr.length - 1
// mid = (0 + 11)/2 i.e 5. 5 is the index assuming the matrix as 1D
// Getting real index : row = 5/4 and column = 5 % 4
// Hence to get the index : row = 1D index / arr[0].length and column = 1D index % arr[0].length

// i.e row = 1 and column = 1 i.e (1,1). Value at (1,1) is 11 < 30.
// Now , low = mid + 1 i.e 6

// low = 6 and high = 11
// Now , mid = (6 + 11)/2 i.e 8
// i.e row = 8/4 and column = 8 % 4 i.e (2,0)

// Value at (2,0) is 23. 23 < 30.
// So, low = mid + 1 i.e 9
// Hence low = 9 and high = 11
// mid = 10
// i.e row = 10/4 and 10 % 4 i.e (2,2)
// Value at (2,2) is 34. And 34 > 30 so,
// high = mid - 1

// Now , low = 9 and high = 9
// mid = 9
// i.e row = 9/4 and column = 9 % 4. i.e (2,1)
// Value at (2,1) is 30. And 30 == 30.
// Hence target found.

// Time complexity is : O(log2(row X col))
// Space complexity is : O(1)



public class Search_in_2D_Matrix_2_Level_1 {

    public static void main(String[] args) {

        int[][] arr = { { 10, 20, 30, 40}, { 15, 25, 35, 45}, { 27, 29, 37, 48}, {32, 33, 39, 50},
        };

        int item = 22;
        System.out.println(Search(arr, item));
    }

    // Applying imaginary binary search
    public static boolean Search(int mat[][] , int item){

        // In case of empty matrix
        if(mat.length == 0)return false;

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = (n * m) - 1; // last imaginary index

        while(low <= high){

            int mid = (low + (high - low)/2); // To avoid overflow

            int row = mid / m;
            int col = mid % m;

            if(mat[row][col] == item){

                return true;

            }

            // Search on the right half
            if(mat[row][col] < item){

                low = mid + 1;

            }else{ // Search on the left half

                high = mid - 1;
            }

        }

        return false;

    }
}
