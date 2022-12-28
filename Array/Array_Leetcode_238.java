package S_150;

public class Array_Leetcode_238 {

//  ------------------  Prefix Algorithm ----------------------
    public static void main(String[] args) {

        /*

        Given Array : 3   4   2   4

        --------------------------------------------------------
        left Product Array : Empty initial

        3 ko chhodd kar useke left main saare elements kaa product lao

        1 (No elements in the left)

        4 ko chodd kar uske left main saare elements kaa products lao

        1  3

        2 ko chodd kar uske left main saare elements kaa products lao

        1  3  12

        4 ko chodd kar uske left main saare elements kaa products lao

         Left Product Array :  1  3  12  24

         Now Right Product Array : Empty initial

         4 ko chodd kar uske right main se saare elements kaa products lao

         1 (If no elements in the right)

         2 ko chodd kar uske right main se saare elements kaa products lao

         4

         Similarly , by doing this we get the right product array : 32 8 4 1

          -------------------------------------

          Left Product Array : 1 3 12 24
          Right Product Array : 32 8 4 1

          Multiply both we get :
          Ans : 32 24 48 24

         */

          int arr[] = {3,4,2,4};//{2,3,4,2,5,5,6};

          int ans[] = Array_Except_Self(arr);

          for(int i = 0; i < ans.length ; i++){

              System.out.println(ans[i] + " ");
          }

    }

    public static int[] Array_Except_Self(int arr[]){

        // Initializing the left array
        int leftProduct[] = new int[arr.length];
        leftProduct[0] = 1; // Since no elements before arr[0]

        for(int i = 1; i < leftProduct.length ; i++){

            leftProduct[i] = arr[i-1]*leftProduct[i-1];
        }

        int rightProduct[] = new int[arr.length];
        rightProduct[arr.length - 1] = 1; // As

        for(int i = rightProduct.length - 2 ; i >=0 ; i--){

            rightProduct[i] = arr[i+1]*rightProduct[i+1];
        }

        // At the end multiply both the array values
        for(int i = 0; i < rightProduct.length ; i++){

            leftProduct[i] = leftProduct[i]*rightProduct[i];
        }

        return leftProduct;
    }
}
