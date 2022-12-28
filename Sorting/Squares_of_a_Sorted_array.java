import java.util.*;
public class Squares_of_a_Sorted_array {
    public static void main (String args[]) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i = 0; i < N ; i++){

            arr[i] = sc.nextInt();
        }

        SquareSorted(arr);

        for(int i = 0; i < N ; i++){

            System.out.print(arr[i] + " ");
        }

    }

    public static void SquareSorted(int arr[]){

        int N = arr.length;

        // Squaring the elements of the array
        for(int i = 0; i < N ; i++){

            arr[i] = arr[i] * arr[i];
        }

        // Sorting using selection sort

        for(int i = 0; i < N ; i++){

            int Min = i;
            for(int j = i+1; j < N ; j++){

                if(arr[Min] > arr[j]){

                    Min = j;
                }

            }

            int temp = arr[i];
            arr[i] = arr[Min];
            arr[Min] = temp;

        }
    }
}