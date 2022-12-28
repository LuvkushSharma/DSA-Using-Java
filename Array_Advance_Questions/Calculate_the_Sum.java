
/*

Raj is a very smart kid who recently started learning computer programming.
His coach gave him a cyclic array A having N numbers, and he has to perform Q operations on this array.
In each operation the coach would provide him with a number X.
After each operation, every element of the cyclic array would be replaced by the sum
of itself and the element lying X positions behind it in the cyclic array.
All these replacements take place simultaneously.
For example, if the cyclic array was [a, b, c, d], then after the operation with X = 1, the new array would be [a+d, b+a, c+b, d+c].
He needs to output the sum of the elements of the final array modulus 10^9+7. He made a program for it but it's not very efficient.
You know he is a beginner, so he wants you to make an efficient program for this task because he doesn't want to disappoint his coach.

Input Format
The first line of each test file contains a integer N. The next line contains N space separated integers which represent the elements of the cyclic array. The third line contains a integer Q representing the number of operations that will be applied to the array. Finally, Q lines follow, each one containing an integer X .

Constraints
1 <= N <= 100000
1 <= Ai<= 10^9
0 <= Q <= 1000000
0 <= X < N

Output Format
Your program should output to the standard output stream the sum of the elements of the final array modulus 10^9+7.

Sample Input
5
1 2 3 4 5
2
1
0

Sample Output
60

Explanation
After the 1st operation (X = 1), the array would be [1+5, 2+1, 3+2, 4+3, 5+4] =[6, 3, 5, 7, 9]
After 2nd operation (X = 0), the array would be [6+6, 3+3, 5+5, 7+7, 9+9] =[12, 6, 10, 14, 18]
Thus the correct answer would equal to = (12+6+10+14+18) % (10^9+7) = 60


 */


/*

---------------------------------------------- Code Explanation -------------------------------------------

array = {1 , 2 , 3 , 4 , 5}

Q = 3 and X = 1 , X = 0 and X = 3




------- When Q = 3 and X = 1

i = 0;

add value at i = 0 and value at 1 index before i = 0 i.e j.

j = i - x i.e j = 0 - 1 ---> j = -1

if j < 0{

  then, j = j + n;----> j = -1 + 5 i.e j = 4
}

i = 1;

add value at i = 1 and value at 1 index before i = 1 i.e j.

j = i - x; ----> j = 1 - 1 = 0


:
:
:

i = 4;

add value at i = 4 and value at 1 index before i = 4 i.e j.

j = i - x; ----> j = 4 - 1 = 3

Q -= 1;






--------- When Q = 2 and X = 0


i = 0;

add value at i = 0 and value at 0 index before i = 0 i.e j.

j = i - x i.e j = 0 - 0 ---> j = 0


i = 1;

add value at i = 1 and value at 0 index before i = 1 i.e j.

j = i - x; ----> j = 1 - 0 = 1


:
:
:

i = 4;

add value at i = 4 and value at 0 index before i = 4 i.e j.

j = i - x; ----> j = 4 - 0 = 4


Q -= 1;






----- When Q = 1 and X = 3


i = 0;

add value at i = 0 and value at 3 index before i = 0 i.e j.

j = i - x i.e j = 0 - 3 ---> j = -3

if j < 0{

  then, j = j + n;----> j = -3 + 5 i.e j = 2
}

i = 1;

add value at i = 1 and value at 3 index before i = 1 i.e j.

j = i - x; ----> j = 1 - 3 = -2

if j < 0{

  then, j = j + n;----> j = -2 + 5 i.e j = 3
}



:
:
:

i = 4;

add value at i = 4 and value at 3 index before i = 4 i.e j.

j = i - x; ----> j = 4 - 3 = 1


 */


import java.util.Scanner;

public class Calculate_the_Sum {

    public static void main(String[] args) {

           Scanner sc = new Scanner(System.in);

           int n = sc.nextInt();

           int arr[] = new int[n];

           // Array input taking by the user
           for(int i = 0; i < n ; i++){

               arr[i] = sc.nextInt();

           }

           int Q = sc.nextInt();

           while(Q-- > 0){

               int X = sc.nextInt();

               // Taking new array for each Q value.
               int temp[] = new int[n];

               for(int i = 0; i < n ; i++){

                   // Calculating X index before i.
                   int j = i - X;

                   if(j < 0){

                       j = j + n;

                   }

                   temp[i] = arr[i] + arr[j];
               }

               arr = temp;

           }



          // Calculating the sum of the resultant array
          int Sum = 0;

          for(int i = 0; i < n ; i++){

              Sum += arr[i];

          }


          int ans = Sum % 10000007;

          System.out.println(ans);
    }
}
