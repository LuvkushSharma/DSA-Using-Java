import java.util.Scanner;

/*

Question :-

You are given an integer n. Find the square root of the number.

------------------------------------ Code Explanation ------------------------------------

Let's say n = 121


We will apply binary search as data is sorted. Since natural numbers are sorted

Now do binary search to find the square root of 121.

low = 1 and high = 121

------- Step - 1

mid = (1 + 121)/2  ---> mid = 61

if(61^2 <= 121)  ----> No

else{

   high = mid - 1 ---> high = 60
}


------- Step - 2

mid = (1 + 60)/2  ---> mid = 30

if(30^2 <= 121)  ----> No

else{

   high = mid - 1 ---> high = 29
}


------- Step - 3

mid = (1 + 29)/2  ---> mid = 15

if(15^2 <= 121)  ----> No

else{

   high = mid - 1 ---> high = 14
}


------- Step - 4

mid = (1 + 14)/2  ---> mid = 7

if(7^2 <= 121) {   ----> Yes

   x = 7;
   low = mid + 1; ----> Go for higher possibility i.e low = 8

}

------- Step - 5

mid = (8 + 14)/2  ---> mid = 11

if(11^2 <= 121) {   ----> Yes

   x = 11;
   low = mid + 1; ----> Go for higher possibility i.e low = 12

}

------- Step - 6

mid = (12 + 14)/2  ---> mid = 13

if(13^2 <= 121)   ----> No

else{

   high = mid - 1; --------> high = 12

}


----- As low = 12 and high = 12 i.e low <= high so, go out of the loop

And x = 11 i.e 11^2 <= 121


 */

public class Square_root {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        long n = sc.nextLong();

        long ans = SquareRoot(n);

        if(ans == -1){

            System.out.println("Square root of " + n + " is not possible.");

        }else{

            System.out.println("Square root of " + n + " is : " + ans);
        }

    }

    public static long SquareRoot(long num){

        // Square root of 0 is 0.
        if(num == 0){

            return 0;
        }

        long low = 1;
        long high = num;

        long x = -1;

        while(low <= high){

            // long mid = (low + high)/2;+
            long mid = low + (high - low)/2;

            if(Math.pow(mid , 2) <= num){

                x = mid;

                low = mid + 1;

            }else{

                high = mid - 1;
            }
        }

        return x;
    }


}
