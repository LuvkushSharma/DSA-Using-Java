package S_150;

import java.util.*;

public class Array3 {

    public static void main(String[] args) {

        //    Array searching

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n ; i++){

            System.out.println("Enter the element : ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the element to be searched : ");
        int element = sc.nextInt();
        int ans = Search(arr , element);
        System.out.println("Element found at : " + ans);


    }

    public static int Search(int arr[] , int element){

        int ans = -1;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] == element){

                ans = i;
                break;
            }
        }

        return ans;

    }
}
