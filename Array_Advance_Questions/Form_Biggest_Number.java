/*

You are provided an array of numbers. You need to arrange them in a way that yields the largest value.

Input Format
First line contains integer t which is number of test case.
For each test case, you are given a single integer n in the first line which is the size of array A[] and next line
contains n space separated integers denoting the elements of the array A .

Constraints
1<=t<=100

1<=m<=100

1<=A[i]<=10^5

Output Format
Print the largest value.

Sample Input
1
4
54 546 548 60
Sample Output
6054854654
Explanation
Upon rearranging the elements of the array , 6054854654 is the largest possible number that can be generated.




 */



public class Form_Biggest_Number {

    public static void main(String[] args) {

        int arr[] = {54 , 546 , 548 , 60};

        Sort(arr);

        for (int i = 0; i < arr.length ; i++){

            System.out.print(arr[i]);
        }

    }

    public static void Sort(int arr[]){

        for(int i = 0; i < arr.length; i++){

            for(int j = i+1; j < arr.length; j++){

                if(compare(arr[i], arr[j]) > 0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static long compare(int x , int y){

        String xy = "" + x + y;
        String yx = "" + y + x;

        return Long.parseLong(yx) - Long.parseLong(xy);
    }
}
