package QuickSort_Prerequisite;

public class Finding_index {

    public static void main(String[] args) {

        // int arr[] =  {7 , 5 , 3 , 1 , 9 , 4};

        int[] arr = { 9, 1, 56, -9, 56, 5, 2, 68, 5, 62, 3, 2, 1, 3, 7 };

       int idx =  Index(arr , 0 , arr.length-1);

        System.out.println(idx);
        // Displaying the ans array
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }
    }


    // Gives the index where we can locate 4 in testcase1.
    // and gives the index where we can locate 7 in the testcase2.
    // i.e elements before this Index will be shorter than the last_element

    // This function will be named as partition in the QuickSort
    public static int Index(int arr[] , int low , int high) {

        int last_element = arr[high];
        int pivotIndex = low;

        for (int i = low; i < high ; i++) {
            if (arr[i] <= last_element) {

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

