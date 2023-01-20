package Lecture_2;

public class Quick_Sort {

    public static void main(String[] args) {

         // int arr[] =  {7 , 5 , 3 , 1 , 9 , 4};

        int[] arr = { 9, 1, 56, -9, 56, 5, 2, 68, 5, 62, 3, 2, 1, 3, 7 };

        Quicksort(arr , 0 , arr.length-1);

        // Displaying the ans array
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }
    }

    public static void Quicksort(int arr[] , int low , int high) {

        // Base case
        if (low >= high) {
            return;
        }

        int idx = Partition_index(arr , low , high);
        Quicksort(arr , low , idx - 1); // Sorting left part of the pivot element.
        Quicksort(arr , idx + 1 , high); // Sorting right part of the pivot element.

    }



    // Gives the index where we can locate 4 in testcase1.
    // and gives the index where we can locate 7 in the testcase2.
    // i.e elements before this Index will be shorter than the last_element
    public static int Partition_index(int arr[] , int low , int high) {

        /*

        Pivot element can be first element of the array , mid element of the array
        , last element of the array and can be any index of the array.

         */

        int pivoteElement = arr[high]; // Pivot element and we had selected last element as the pivot element.
        int pivotIndex = low;

        for (int i = low; i < high ; i++) {
            if (arr[i] <= pivoteElement) {

                // Swapping
                int temp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = temp;

                pivotIndex += 1;
            }
        }

        // Swapping at the end
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        return pivotIndex;

    }
}
