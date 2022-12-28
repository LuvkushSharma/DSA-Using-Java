

// Leetcode Problem Statement :-

// Write an efficient algorithm that searches for a value target in an m x n integer matrix.
// This matrix has the following properties:

// ----->  Integers in each row are sorted from left to right.
// ----->  The first integer of each row is greater than the last integer of the previous row.



//        Method-1 : Naive approach O(N X M)
//        Method-2 : Fix rows and do binary search if not found in the current row then change the row and again Binary search.
//        O(N X log(M)) will be the time complexity of the above approach.


// Search in 2D matrix level - 1 : For Leetcode and GFG both
// As this works

// Applying Method - 2:

public class Search_in_2D_Matrix_1_Level_1 {

    public static void main(String[] args) {


        int[][] Leetcode = { { 1, 3, 5, 7}, { 10 , 11 , 16, 20 }, { 23, 30, 34, 50} };

        // Here 10 is greater than the last integer of the previous row i.e 7

        int itemForLee = 11;

        System.out.println(Search(Leetcode, itemForLee));

    }

    public static boolean Search(int arr[][] , int item){

        // Applying binary search on each row
        for(int i = 0; i < arr.length ; i++){

            int low = 0;
            int high = arr[0].length - 1;

            while(low <= high){

                int mid = (low + high)/2;

                if(arr[i][mid] == item){
                    return true;
                }

                else if(arr[i][mid] > item){

                    high = mid - 1;
                }

                else{

                    low = mid + 1;
                }
            }
        }

        return false;
    }
}
