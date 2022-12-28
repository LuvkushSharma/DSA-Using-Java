public class Lec2__Wave_Print {

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

        Display(arr);

        System.out.println();


        // Wave print approach :-
        // if column no. is odd then print column elements from bottom to top.
        // and if column no. is even then print column elements from top to bottom.

        // i.e print 0th index column from top to bottom and 1st index column from bottom to top.
        // Time complexity : O(n X m)

        for(int col = 0; col < arr[0].length ; col++){

            // Odd index : bottom to top
            if(col % 2 != 0){

                for(int row = arr.length - 1; row >= 0; row--){

                    System.out.print(arr[row][col] + " ");
                }

                System.out.println();

            }else{ // Even index : top to bottom

                for(int row = 0; row < arr.length; row++){

                    System.out.print(arr[row][col] + " ");
                }

                System.out.println();
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
