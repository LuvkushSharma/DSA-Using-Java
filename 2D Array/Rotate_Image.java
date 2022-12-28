
//  1   2   3          7  4  1
//  4   5   6   ---->  8  5  2
//  7   8   9          9  6  3


// Approach-1:
// Take a new matrix and copy 1st col from bottom into the 1st row of new matrix
// Similarly, copy 2nd col values from bottom and paste it into the 2nd row of new matrix.

// Time complexity : O(n^2)
// Space complexity : O(n^2)


// Approach-2:
// Take the transpose of the given matrix
// and then reverse each rows to get the resultant matrix.

// Time complexity : O(n^2)
// Space complexity : O(1)


public class Rotate_Image {

    public static void main(String[] args) {

        // int[][] matrix = { { 1, 2 , 3}, {4 , 5 , 6}, {7 , 8 , 9}};

//        int matrix[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        int matrix[][] = {{1,2,3,4} , {5,6,7,8} , {9,10,11,12} , {13,14,15,16}};

        Display(matrix);

        System.out.println();

        Transpose(matrix);

        for(int i = 0; i < matrix.length ; i++){

            int j = 0;

            while(j < matrix.length/2){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;

                j += 1;
            }
        }

        Display(matrix);
    }

    public static void Transpose(int arr[][]){

        for(int row = 0; row < arr[0].length ; row++){

            for(int col = row; col < arr.length ; col++){

                int temp = arr[row][col];
                arr[row][col] = arr[col][row];
                arr[col][row] = temp;

            }
        }
    }

    public static void Display(int arr[][]){

        for(int i = 0; i < arr.length ; i++){

            for(int j = 0; j < arr[0].length ; j++){

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
