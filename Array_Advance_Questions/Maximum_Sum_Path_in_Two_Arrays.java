
/*

You are provided two sorted arrays. You need to find the maximum length of bitonic subsequence.
You need to find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays.
You can switch from one array to another array only at common elements.

Input Format
First line contains integer t which is number of test case. For each test case,
it contains two integers n and m which is the size of arrays and next two lines contains n and m space separated integers
respectively.

Constraints
1<=t<=100 1<=n,m<=100000

Output Format
Print the maximum path.

Sample Input
1
8 8
2 3 7 10 12 15 30 34
1 5 7 8 10 15 16 19

Sample Output
122

Explanation
122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34


*/

/*

arr1 -----> 2 3 7 10 12 15 30 34
arr2 -----> 1 5 7 8 10 15 16 19

Take two pointers : i pointer on Arr1 and j pointer at Arr2

Step-1 : Compare arr1[i] and arr2[j]. arr1[i] > arr2[j] i.e 2 > 1
         Jo value chotta hain uska pointer aagye bhadaa do.
         i.e j += 1;

Step-2 : Now i = 0 on arr1 and j = 1 on arr2.
         Compare arr1[i] and arr2[j]. arr1[i] < arr2[j] i.e 2 < 5
         Jo value chotta hain uska pointer aagye bhadaa do.
         i.e i += 1;

Step-3 : Now, i = 1 on arr1 and j = 1 on arr2
         Compare arr1[i] and arr2[j]. arr1[i] < arr2[j] i.e 3 < 5
         Jo value chotta hain uska pointer aagye bhadaa do.
         i.e i += 1;

Step-4 : Now, i = 2 on arr1 and j = 1 on arr2
         Compare arr1[i] and arr2[j]. arr1[i] > arr2[j] i.e 7 > 5
         Jo value chotta hain uska pointer aagye bhadaa do.
         i.e j += 1;


Step-5 : Now, i = 2 on arr1 and j = 2 on arr2
         Compare arr1[i] and arr2[j]. arr1[i] == arr2[j]  ------> Common elements
         Abb i = 0 se leke i = 2 tak kaa arr1 kaa sum nikaalo. i.e 2 + 3 + 7 = 12
         Aur j = 0 se leke j = 2 tak kaa arr2 kaa sum nikaalo. i.e 1 + 5 + 7 = 13

         Max sum hain 13 abhi tak, hamaara jo path hoga abhi tak kaa woh hoga 1 + 5 + 7 waala

Step-6 : Abb i aur j dono ko ek se aagye bhadaa do. i.e i = 3 and j = 3
         Compare arr1[i] and arr2[j]. arr1[i] > arr2[j] i.e 10 > 8
         Jo value chotta hain uska pointer aagye bhadaa do.
         i.e j += 1;

Step-7 : Now, i = 3 on arr1 and j = 4 on arr2
         Compare arr1[i] and arr2[j]. arr1[i] == arr2[j]  ------> Common elements
         Abb i = 3 se leke i = 3 tak kaa arr1 kaa sum nikaalo. i.e 10
         Aur j = 3 se leke j = 4 tak kaa arr2 kaa sum nikaalo. i.e 8 + 10 = 18

         Aur agar main 13 main 10 add karunga toh woh sum chotta hoga as compare to agar main 13 main 18 add karunga.
         i.e We'll choose below path. 13 + 18 = 31

         Max sum hain 31 abhi tak, hamaara jo path hoga abhi tak kaa woh hoga 13 + 8 + 10 waala.
         Aur i and j ko aagye bhadaa do ek ek index.

Step-8 : Now, i = 4 on arr1 and j = 5 on arr2
         Compare arr1[i] and arr2[j]. arr1[i] < arr2[j] i.e 12 < 15
         Jo value chotta hain uska pointer aagye bhadaa do.
         i.e i += 1;


Step-9 : Now, i = 5 on arr1 and j = 5 on arr2
         Compare arr1[i] and arr2[j]. arr1[i] == arr2[j]

         Abb i = 4 se leke i = 5 tak kaa arr1 kaa sum nikaalo. 12 + 15 i.e 27
         Aur j = 5 se leke j = 5 tak kaa arr2 kaa sum nikaalo. i.e 15

         Aur agar main 31 main 15 add karunga toh woh sum chotta hoga as compare to agar main 31 main 27 add karunga.
         i.e We'll choose above path i.e 12 + 15.

         Max sum hain 58 abhi tak, hamaara jo path hoga abhi tak kaa woh hoga 31 + 12 + 15 waala.
         Aur i and j ko aagye bhadaa do ek ek index.


Step-10 : Now, i = 6 on arr1 and j = 6 on arr2
          Compare arr1[i] and arr2[j]. arr1[i] > arr2[j] i.e 30 > 16
          Jo value chotta hain uska pointer aagye bhadaa do.
          i.e j += 1;


Step-11 : Now, i = 6 on arr1 and j = 7 on arr2
          Compare arr1[i] and arr2[j]. arr1[i] > arr2[j] i.e 30 > 19
          Jo value chotta hain uska pointer aagye bhadaa do.
          i.e j += 1;

Step-12 : Abb array khatam ho gaya hain. Toh i = 6 se lekar i = 7 tak kaa sum. i.e 30 + 34 = 64
          Aur j = 6 se lekar j = 7 tak kaa sum. i.e 16 + 19 = 35

          So, Agar main 58 main 64 add karunga toh max sum banega as compare to agar main 58 main 35 add karu toh.

          Hence, 58 + 64 = 122


          And 122 is the answer.

          And the path is :

          1      5     7       8       10        12         15           30           34
          -------------------------------        ------------           -----------------
                        |                             |                         |
                       arr2                         arr1                       arr1



         Condition : Common elements tak kaa sum nikaalo aur previous sum main add kardo.
                     After common elements i aur j dono ko bhadaa do.
                     if value at i is less than value at j then i += 1
                     if value  at j is less than value at i then j += 1


 */




import java.util.Scanner;

public class Maximum_Sum_Path_in_Two_Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int m = sc.nextInt();

            int arr1[] = new int[n];
            int arr2[] = new int[m];


            for(int i = 0; i < n ; i++){

                arr1[i] = sc.nextInt();
            }

            for(int i = 0; i < m ; i++){

                arr2[i] = sc.nextInt();
            }

            int ans = MaxSumPath(arr1 , arr2);

            System.out.println(ans);
        }
    }

    public static int MaxSumPath(int arr1[] , int arr2[]){

        int i = 0;  // Pointer on the arr1
        int j = 0;  // Pointer on the arr2

        int p = 0; // arr1 main sequence kaha se start ho raha hain woh bataayega ye
        int q = 0; // arr2 main sequence kaha se start ho raha hain woh bataayega ye

        int ans = 0;

        while(i < arr1.length && j < arr2.length){

            if(arr1[i] < arr2[j]){
                i += 1;
            }
            else if(arr1[i] > arr2[j]){
                j += 1;

            }
            else{  // When we get the common elements

                int sum1 = 0;
                int sum2 = 0;

                // Pehli array kaa sum nikaalo
                for(int iter = p; iter <= i; iter++){

                    sum1 += arr1[iter];
                }

                // Dusri array kaa sum nikaalo
                for(int iter = q; iter <= j; iter++){

                    sum2 += arr2[iter];
                }

                ans = ans + Math.max(sum1 , sum2);

                // After getting common elements increament both the pointers
                i += 1;
                j += 1;

                // Updating p and q
                p = i;
                q = j;
            }
        }

        // Abb koi naa koi ek array khatam ho gayi hogyi aur ek reh gayi hogyi.

        // Means arr2 is left
        if(i == arr1.length){

            for(int k = q; k < arr2.length; k++){

                ans += arr2[k];
            }
        }

        // arr1 is left
        if(j == arr2.length){

            for(int k = p; k < arr1.length; k++){

                ans += arr1[k];
            }
        }

       return ans;
    }
}
