public class Selection_Sort {

    public static void main(String[] args) {

/*
        Array : 2  5   7   1  4  3

        Step 1 : Sabse minimum value array main  jo 2 se bhi chotta ho usse swap kardo.
        1  5   7   2  4  3

        Step 2 : Sabse minimum value array main jo 5 se bhi chotta ho usse swap kardo.
        1  2   7   5  4  3

        Step 3 : Sabse minimum value array main jo 7 se bhi chotta ho usse swap kardo.
        1  2   3   5  4  7

        Step 4 : Sabse minimum value array main jo 5 se bhi chotta ho usse swap kardo.
        1  2   3   4  5  7



 */

        int arr[] = {2,5,7,1,4,3};

        SelectionSort(arr);


    }

    public static void SelectionSort(int arr[]){

        for(int i = 0; i < arr.length ; i++){

            int Min = i;
            for(int j = i+1 ; j < arr.length ; j++){

                if(arr[j] < arr[Min]){

                    Min = j;
                }

            }

            int temp = arr[i];
            arr[i] = arr[Min];
            arr[Min] = temp;
        }
    }

    public static void Display(int arr[]){

        for(int i = 0; i < arr.length; i++){

            System.out.print(arr[i] + " ");

        }
    }
}
