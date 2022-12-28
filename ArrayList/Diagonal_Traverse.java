
// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

/*

Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105

 */

/*

Number of diagonals in n*m matrix : (n + m - 1)

We have to make a loop on each diagonal i.e

total loops = total diagonals

 */


/*


Assume diagonals goes from top to bottom

diagonal = 0

Col index  0    1     2
           |    |     |
           V    V     V

           1    2     3   <----  Row = 0

           4    5     6   <----  Row = 1

           7    8     9   <----  Row = 2


 When :  d < m
 then row = Diagonal starting points : (0,0) (0,1) (0,2)
                                       (1,2) (2,2)

 Jab diagonal kaa satrting point i.e d less than col hain tab tab row = 0 hain.
 Aur jab diagonal 0 hain toh col = 0 hain. Jab diagonal 1 hain tab col = 1 hain i.e col = d in that case.


 When : d > m
 then row starts from 1 and col is fixed i.e (m-1)
 (1,2) , (2,2)

 diagonal 4 starts from (1,2) where row = diagonal - m + 1 => 3 - 3 + 1 => 1
 diagonal 5 starts from (2,2) where row = diagonal - m + 1 => 4 - 3 + 1 => 2

  -------------> Abhi tak saara direction Upar se neeche thaa
  ---> Par real main hame diagonal zig-zag print karaana hain

  Pehle Upar se neeche hain fir neeche se upar and so on...
  Ham dekh rahe hain kii dusre diagonal main row plus ho rahi hain aur column kam ho rahe hain


  Col index  0    1     2
           |    |     |
           V    V     V

           1    2     3   <----  Row = 0

           4    5     6   <----  Row = 1

           7    8     9   <----  Row = 2


           i.e 2 ,4 in this 2 at (0,1) and 4 at (1,0)
           i.e row increase hui aur column kam hua.

           Similarly, 3 , 5 , 7

  Odd diagonal :
  Upar se neeche atte main row += 1 and col -= 1
  while(row < n && col >= 0){

     list.add(arr[row][col]

     row += 1;
     col -= 1;

     }

   Even Diagonal :
   Neeche se upar aane main row -= 1 and col += 1

   i.e jo upar waale loop nain values daali hain unhe reverse kardo



 */

import java.util.ArrayList;
import java.util.Collections;

public class Diagonal_Traverse {

    public static void main(String[] args) {

            int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

            int ans[] = findDiagonalOrder(arr);

            for(int val : ans){

                System.out.print(val + " ");
            }
    }

    public static int[] findDiagonalOrder(int mat[][]){

        int n = mat.length;
        int m = mat[0].length;

        int ans[] = new int[n*m];
        int i = 0; // -----------> Tracks the last index of the arraylist till that we have putted the values.


        // Total loop runs = total diagonals
        for(int d = 0; d < (n + m - 1) ; d++){

            int row = 0;
            int col = 0;

            // When diagonals starts from 0th row
            if(d < m){

                row = 0;
                col = d;

            }else{ // When col is fixed and row changes

                col = (m-1);
                row = (d - m + 1);
            }

            // Stores the diagonal from top to bottom.
            // Later we will reverse if diagonal is even
            ArrayList<Integer> list = new ArrayList<>();

            // For the odd diagonal :
            // We are going from top to bottom in the slanted form
            while(row < n && col >= 0){

                list.add(mat[row][col]);

                // Row increase ho raha hain aur column decrease ho raha hain upar se neeche waale diagonals main
                row += 1;
                col -= 1;
            }

            // For the even diagonal :
            // Just reverse the ArrayList
            if(d % 2 == 0){

                // In case of even we have to go from bottom to top in the slanted form
                Collections.reverse(list);

            }

            // ans waali array main daal do ArrayList ke elements
            for(int val : list){

                ans[i] = val;
                i += 1;
            }
        }

        return ans;
    }
}
