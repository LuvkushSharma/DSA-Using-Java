public class Lec1 {

    public static void main(String[] args) {

        int arr[][] = new int[3][4];

        System.out.println(arr); // Address of the 2D array
        System.out.println(arr[1]); // Address of the 1D array
        System.out.println(arr[1][2]); // Value at index 2 in the second 1D array.

        //          int arr[][] = new int[n][m] contains (n+1) 1D arrays

        System.out.println("Row Length : " + arr.length);
        System.out.println("Column Length : " + arr[0].length);

          for(int i = 0; i < arr.length ; i++){

              for(int j = 0; j < arr[0].length ; j++){

                  System.out.print(arr[i][j] + " ");

              }

                  System.out.println();

          }








    }
}
