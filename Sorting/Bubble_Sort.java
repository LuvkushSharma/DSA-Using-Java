import java.util.Scanner;

public class Bubble_Sort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){

            System.out.println("Enter the element : ");
            arr[i] = sc.nextInt();
        }

        BubbleSort(arr);

        Display(arr);

    }

//    3 5 4 2 1

    public static void BubbleSort(int arr[]){

        for(int i = 1; i < arr.length ; i++){

            for(int j = 0; j < arr.length - i; j++){

                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void Display(int arr[]){

        for(int i = 0; i < arr.length; i++){

            System.out.print(arr[i] + " ");

        }
    }
}
