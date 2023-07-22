package Sieve_of_Eratosthenes;

/*

------------ Print prime numbers in the range 1 to n. --------------

If we want to check whether a number is prime or not then we have use two loops i.e. TC : O(n^2)

for (int i = 2 ; i <= n ; i++) {

   boolean flag = true;
   for (int j = 2 ; Math.sqrt(i) ; j++){   ------
                                                |
         if (i % j == 0) {                      |
                                                |
             flag = false;                      |------> Upar waala loop toh hata nhi sakte but yeah we can rmove this for loop and do something so, that TC : decreases.
             break;                             |
         }                                      |
    }                                      -----|

    if (flag == true)
      sout("Prime Number);
}

 */

/*

 If number is not prime then we can write it in the form : a X b = N

              a  X  b  =  N
           /      |        \
          /       |         \
      a == b    a > b        a < b

      Case-1 : if a == b then
      so, a = b = Sqrt(n)

      Proof : as a = b
          i.e a^2 = n so, a = sqrt(n)
         and  b^2 = n so, b = sqrt(n)

      Case-2 : if a > b then
               b < sqrt(n)

      Case-3 : if a < b then
               a < sqrt(n)

      Iska matlab ye hain kii agar koi factor hoga toh sqrt(n) tak mil jaayega.

 */


/*

2 to 100 tak ke sabhi numbers ko prime number maan lo initially.

Start from 2 :-
   so, 2 agar prime hain toh 2 ka koi bhi multiple prime nhi ban sakta. i.e 4 , 6 , 8 , 10 , 12 ,.... 100
   i.e. N/2 numbers cut kar diye hamne

Start from 3 :-
   as , 3 is also a prime number so, also cut it's multiple.
   i.e. we had cutted ---> N/3 numbers

Start from 4 :-
  Already cutted.

Start from 5 :-
  Since it is not cutted i.e a prime number
  Cut it's multiple. i.e. 25 , 35 , 55 ,...
  i.e. we had cutted N/5 numbers more

Start from 6 :-
  Already cutted.

Start from 7 :-
  not cutted i.e prime number.
  it will cut : N/7 numbers more.

Start from 8 :-
  Already cutted.

Start from 9 :-
  Already cutted.

Start from 10 :-
  Already cutted.

Abb isse aagye loop mat chalao because agar 100 katna hoga toh woh apnne sqrt tak kat gaya hoga i.e. 10 as we had seen this just above.

Hence :-

N/2 + N/3 + N/5 + N/7 ------> numbers cutted.

So, agar n = 100 hoga then ham ek array bana lengye 101 size kaa where indexing from 0 to 100

------------------------ Approach ---------------------

Step-1 : Puuri array main true daal do sirf 0 and 1 ko left kardo.
         ith index par true hain iska matlab 'i' prime number hain.

Step-2 : 2 se start karengye and sqrt(n) tak jaayengye. And kahi par true mil gaya toh uska multiple not prime ho.
         // for n = 100
                // for i = 2 inner loop runs : N/2 times
                // for i = 3 inner loop runs : N/3 times
                // for i = 5 inner loop runs : N/5 times
                // for i = 7 inner loop runs : N/7 times

         // for n > 100
                // then inner loop will also runs for N/11 times i.e when i = 11
                // N/13 for i = 13

        ------------ Calculating TC of Sieve ---------

        N/2 + N/3 + N/5 + N/7 + N/11 + N/13 + .....

        i.e.  N (1/2 + 1/3 + 1/5 + 1/7 + 1/11 + 1/13 + .....)

         (1/prime) kaa sum log(logN) hota hain

         so, N*log(logN)

         TC : N * log(logN)

 */

public class seive {

    public static void main(String[] args) {

        System.out.println(isPrime(67));
        Prime_Sieve(100);
    }

    public static boolean isPrime (int n) {

        int div = 2;
        while (div * div <= n) {

             if (n % div == 0) {

                 return false;
             }

             div += 1;
        }

        return true;
    }

    public static void Prime_Sieve (int n) {

        boolean []prime = new boolean[n+1];

        // Step-1 : Marked all numbers as prime
        for (int i = 2 ; i < prime.length ; i++)
            prime[i] = true;

        // Step-2 : Cutting
        for (int i = 2 ; i * i < prime.length ; i++) {

            // if i is prime number
            if (prime[i] == true) {

                // Let's say agar i = 3 hain toh hame : 3*2 , 3*3 , 3*4 , 3*5 ,....3*j where j < prime.length numbers ko not prime mark karna hain.

                // for n = 100
                // for i = 2 inner loop runs : N/2 times
                // for i = 3 inner loop runs : N/3 times
                // for i = 5 inner loop runs : N/5 times
                // for i = 7 inner loop runs : N/7 times

                // for n > 100
                // then inner loop will also runs for N/11 times i.e when i = 11
                // N/13 for i = 13
                for (int j = 2 ; i * j < prime.length ; j++) {

                    prime[i * j] = false;
                }
            }
        }

        // Step-3 : Print prime numbers
        for (int i = 2 ; i < prime.length ; i++) {

            if (prime[i] == true) {

                System.out.print (i + " ");
            }
        }

    }
}
