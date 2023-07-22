/*

Find : x^N

Mujhe 3^18 nikaalna hain let's say so, agar main 3^9 main 3^9 multiply kar duu toh kaam ban jaayega.

So, ham recursion se bolengye kii x^(N/2) nikaalke dede mera kaam ban jaayega.

But mera N odd hua i.e 3^17 i.e 3^8 * 3^8 kia toh ye toh galat ho jaayega. i.e. above approach is correct when N is even.
But if we multiply 3 in 3^17 then again first approach ban gaya.

i.e. Odd number hoga multiply base kar lengye.

X^(N/2) ke liye recursion kahega X^(N/4) nikaal.
Similarly , X^(N/4) ke liye recursion kahega X^(N/8) nikaal

   X^(N/2)
    |
   X^(N/4)
    |
   X^(N/8)
    |
   X^(N/16)
    |
   X^(N/32)
    |
    .
    .
    .

  TC : O(logn)




 */



public class Pow_logn {

    public static void main(String[] args) {

        int x = 3;
        int n = 5;

        int ans = pow (x , n);
        System.out.println(ans);
    }

    // TC : O(logn)
    public static int pow (int x , int n) {

        // Base Case
        if (n == 0)
            return 1;

        int ans = pow (x , n/2); // ----> He recursion x^n/2 nikaal ke dede
        ans = ans * ans; // i.e. x^n/2 * x^n/2

        if (n % 2 != 0) {
            ans *= x;
        }

        return ans;
    }
}
