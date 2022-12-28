
/*

Given an array Arr[], Treat each element of the array as the digit and whole array as the number.
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order i.e, sorted in an ascending order.

Note: The replacement must be in-place, do not allocate extra memory.

Input Format
The First Line contains the Number of test cases T.
Next Line contains an Integer N, number of digits of the number.
Next Line contains N-space separated integers which are elements of the array 'Arr'.

Constraints
1 <= T <= 100
1 <= N <= 1000
0 <= Ai <= 9

Output Format
Print the Next Permutation for each number separated by a new Line.

Sample Input
2
3
1 2 3
3
3 2 1

Sample Output
1 3 2
1 2 3

Explanation
Possible permutations for {1,2,3} are {1,2,3} , {1,3,2} , {2,1,3} , {2,3,1}, {3,1,2} and {3,2,1}. {1,3,2} is the immediate next permutation after {1,2,3}.
For the second testcase , {3,2,1} is the last configuration so we print the first permutation as its next permutation.


 */


/*

---------------- TestCase Explanation -------------------

arr : 1 2 3

Forming numbers with 123 : 231 , 312 , 321 , 132

But 132 is the next greater number of 123

arr : 3 2 1

In this case we never get the next greater number of 321 on arranging the digits.
So, print the smallest number i.e reverse the array nad print it. Or print the array in the reverse.


 */

/*

----------------------------------------- Code Explanation -----------------------------------------

Let's say num = {4,3,2,7,4,3,1}

i.e 4327431

Step-1 : Place a pointer arr.length - 2 i.e at 3. So, i = 5
         Then check whether arr[i] < arr[i+1]. If arr[i] is less than arr[i+1] the swap them to get the bigger number.


Step-2 :  Since, value at i = 5 is not less than value at i = 6. So, decreament i. i.e i = 4.
          Check : arr[i] < arr[i+1] or not. 4 < 3 ---> No i.e we donot swap them.
          Again i -= 1;

Step-3 :  Since, value at i = 5 is not less than value at i = 6. So, decreament i. i.e i = 4.
          Check : arr[i] < arr[i+1] or not. 4 < 3 ---> No i.e we donot swap them.
          Again i -= 1;

Step-4 : Now, i = 3.
         Check : 7 < 4 ---> No
         Again i -= 1;

Step-5 : Now, i = 2.
         Check : 2 < 7 -----> Yes

         Now, we have to swap 2 with the digit in the subarray : {7,4,3,1} but we donot swap it with 7.
         As after swapping we will get the big number not the next greater number.

         Store this index in p. i.e p = 2


Step-6 : Abb loop lagao peeche se aur check karo se pehla bada number konsa hain.
         Since numbers are in the sorted fashion isliye peeche se suru kiya.
         i.e iss array main {7,4,3,1} 1 se suru karo.
         1 > 2 ---> No
         3 > 2 ---> Yes now store the index of 3 in q

         Now, swap 2 and 3 or arr[p] and arr[q]

         {4,3,3,7,4,2,1} --> Still not a next greater number but a greater number itself

         Reverse the array from 7 to 1 to get the next greater number.

         i.e ans = {4,3,3,1,2,4,7}


 Crux :

 -----> Peeche se suru karo aur check karo arr[i] < arr[i+1]
        Agar aisa hain toh uss ith index ko store kar do p main.

 -----> Fir peeche se loop chalao i.e i = arr.length - 1 se lekar i > p tak.
        Aur arr[p] i.e 2 here se just bada number dekho aur usse 2 se swap kar do.

 -----> Then reverse kar do from i = (p+1) to i = arr.length


 Example-2 : arr : {5,7,9,3,5,4,2,1}

 ----> 3 < 5 at i = 3 so, p = 3.
 ----> Now, check a number in the subarray : {5,4,2,1} which is just greater than 3.
       And this is 4 at index 5 so, store this in q. i.e q = 5
       So, swap 3 and 4 or arr[p] and arr[q]
       {5,7,9,4,5,3,2,1}

 -----> Now, reverse the array from p+1 to arr.length-1
         ans = {5,7,9,4,1,2,3,5}


 */


import java.util.Scanner;

public class Next_Permutation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int num[] = new int[n];

            for(int i = 0; i < n; i++){

                num[i] = sc.nextInt();
            }

            Permutation(num);

            // Printing the next greater number
            for(int i = 0; i < num.length ; i++){

                System.out.print(num[i]);
            }

            System.out.println();
        }

    }

    public static void Permutation(int arr[]){

        int p = 0; // Index where arr[i] < arr[i+1]
        int q = 0;

        // Not works for {3,2,1}
        for(int i = arr.length - 2 ; i >= 0; i--){

            if(arr[i] < arr[i+1]){

                p = i;
                break;
            }
        }

        // Finding q
        // Not works for {3,2,1}
        for(int i = arr.length - 1 ; i > p ; i--){

            if(arr[i] > arr[p]){

                q = i;
                break;
            }
        }

        // If number is already the biggest number i.e 321 and we cannot make it's next greater number with it's digit.
        // So, in this case just reverse the whole array.
        if(p == 0 && q == 0){

            // Reverse the whole array
            ReverseInARange(arr , 0 , arr.length - 1);
            return;
        }

        // Swapping value at p and q
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;

        // Now reversing the array from i = (p+1) to arr.length - 1
        ReverseInARange(arr , p+1 , arr.length - 1);

    }



    public static void ReverseInARange(int arr[] , int i , int j){

        while(i < j){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i += 1;
            j -= 1;
        }
    }
}
