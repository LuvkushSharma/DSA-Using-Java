import java.util.Scanner;

public class Lec1 {

    public static void main(String[] args) {

     //  After sorting the array we can apply the Binary Search
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
//        int arr[] = new int[n];

//        for(int i = 0; i < n; i++){
//
//            arr[i] = sc.nextInt();
//        }

        int arr[] = {2,3,5,7,8,9,11,12,13,14,16,18};
        int item = 7;

        int ans = Search(arr , item);

        if(ans == -1){

            System.out.println("Element Not Found");

        }else{

            System.out.println("Element Found at : " + ans);
        }

    }

    public static int Search(int arr[] , int item){

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = (low + high)/2;

            if(arr[mid] == item){

                return mid;
            }

            else if(arr[mid] > item){

                high = mid - 1;
            }

            else{

                low = mid + 1;
            }
        }
        return -1;
    }
}


// Go to first bad version Soln on leetcode.