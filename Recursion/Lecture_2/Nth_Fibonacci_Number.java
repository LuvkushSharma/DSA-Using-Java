package Lecture_2;

public class Nth_Fibonacci_Number {

    public static void main(String[] args) {

       int n = 5;
       System.out.println(Fibonacci(n));
    }

    public static int Fibonacci(int n){

        // Base case
        if(n == 0 || n == 1){
            return n;
        }


        int f1 = Fibonacci(n-1); // (n-1)th fibo
        int f2 = Fibonacci(n-2); // (n-2)th fibo

        return (f1 + f2);
    }
}
