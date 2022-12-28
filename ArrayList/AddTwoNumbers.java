

/*

Take as input N, the size of array. Take N more inputs and store that in an array.
Take as input M, the size of second array and take M more inputs and store that in second array.
Write a function that returns the sum of two arrays. Print the value returned.



Sample Input
4
1 0 2 9
5
3 4 5 6 7


Sample Output
3, 5, 5, 9, 6, END


Explanation
Sum of [1, 0, 2, 9] and [3, 4, 5, 6, 7] is [3, 5, 5, 9, 6] and the first digit represents carry over , if any (0 here ) .



 */


import java.util.ArrayList;

public class AddTwoNumbers {

    public static void main(String[] args) {

        int arr[] = {1, 0, 4, 9, 6};
        int arr2[] = {3, 4, 5, 6, 7, 8, 3};

        TwoArraySum(arr , arr2);

    }

    public static void TwoArraySum(int arr1[] , int arr2[]){

        int i = arr1.length - 1;
        int j = arr2.length - 1;

        ArrayList<Integer> list = new ArrayList<>();
        int carry = 0;


        while(i >= 0 && j >= 0){

            int sum = 0;
            sum = arr1[i] + arr2[j] + carry;

            list.add(sum % 10);

            carry = sum/10;

            i--;
            j--;

        }

        // If arr1 is not finished but arr2 is finished
        // So, just copy paste the left elements of the arr1
        while (i >= 0){

            int sum = 0;
            sum = arr1[i] + carry;

            list.add(sum % 10);

            carry = sum/10;

            i--;

        }

        // arr2 is not finished but arr1 is finished
        // So, just copy paste the left elements of the arr2
        while (j >= 0){

            int sum = 0;
            sum = arr2[j] + carry;

            list.add(sum % 10);

            carry = sum/10;

            j--;

        }

        if(carry != 0){

            list.add(carry);
        }

        for (int k = list.size() - 1 ; k >= 0 ; k-- ){

            System.out.print(list.get(k) + ", ");
        }

        System.out.println("END");
    }
}
