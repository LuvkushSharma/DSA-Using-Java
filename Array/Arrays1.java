package S_150;

// Java is the Call by value

import java.util.Scanner;

public class Arrays1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0; i < n; i++){

            System.out.println("Enter the number in the array : ");
            arr[i] = sc.nextInt();
        }

        Display(arr);

//        Hardcore array
        int arr2[] = {1,2,3,4,5,-6};

        System.out.println("Before swapping : " + arr[0] + " " + arr[1]);
        swap(arr , 0, 1);
        System.out.println("After swapping : " + arr[0] + " " + arr[1]);
    }

    public static void Display(int arr[]){

        for (int i = 0; i < arr.length ; i++){

            System.out.println(arr[i] + " ");

        }
    }

    public static void swap(int arr[] , int i,int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
