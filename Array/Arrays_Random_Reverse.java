package S_150;

import java.util.Scanner;

public class Arrays_Random_Reverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = {1,3,1,3,2,4,422,99 ,77};

        int start = sc.nextInt();
        int end = sc.nextInt();
        Reverse(arr , start , end);

        Display(arr);
    }

    public static void Display(int arr[] ){

        for(int i = 0; i < arr.length ; i++){

            System.out.print(arr[i] + " ");
        }
    }

    public static void Reverse(int arr[], int start , int end){

        int i = start;
        int j = end;
        while(i < arr.length/2){

            int temp = arr[i];
            arr[i] = arr[j - i - 1];
            arr[j - i - 1] = temp;

            i += 1;
            j -= 1;
        }
    }
}
