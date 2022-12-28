

/*

It is Alex’s birthday and she wants to go shopping. She only has ‘A’ units of money and she wants to spend all of her money.
However, she can only purchase one kind of item. She goes to a shop which has ‘n’ types items with prices A0,A1,A2,…,An-1.
The shopkeeper claims that he has atleast ‘k’ items she can choose from. Help her find out if the shopkeeper is correct or not.

Input Format

The first line contains an integer ‘n’ denoting the number of items in the shop.
The second line contains ‘n’ space-separated integers describing the respective price of each item.
The third line contains an integer ‘q’ denoting the number of queries.
Each of the subsequent lines contains two space-separated integers ‘A’ and ‘k’

Constraints
1 <=n, Ai, A <= 105 where 0<=i

1 <= q <= 2*n
1 <= k <= n
The array may contain duplicate elements.

Output Format
For each query, print Yes on a new line if the shopkeeper is correct; otherwise, print No instead.

Sample Input
4
100 200 400 100
5
100 2
200 3
500 4
600 4
800 4

Sample Output
Yes
Yes
No
No
Yes

Explanation
In query 1, Alex has 100 units of money. The shopkeeper claims that she can choose to buy from 2 kinds of items i.e.
            item 1 and item 4 each priced at 100.

In query 2, The shopkeeper claims that she can choose to buy from 3 kinds of items i.e item 1 and item 4 each priced at
            100(she can buy 1 from either of the two), or item 2 priced at 200(she can buy one)

In query 3, she has 500 units of money. She can either buy item 1 or item 4 ( 5 of each kind respectively).
            Thus, she has only 2 kinds of items to choose from.

In query 5, she has 800 units of money. She can either buy item 1 or item 4 ( 8 of each kind respectively)
            or item 2(she can buy 4 of these) or item 3(2 of these). Thus, she has 4 kinds of items to choose from.


 */


// ------------- Note : Alex jo item khareed rahi hain us parr puura money invest hona chaiye. Agar Aisa hain toh woh item uski choice hain

/*

---- Question explanation

4
100 200 400 100
5
100 2       ----> Alex has 100 Rs and Shopkeeper ne bola hain kii woh 100 Rs ke item 2 tareeke se le sakti hain. Ek index 0 waala item le le aur ussi par apne puure 100 Rs kharch kar de yaa fir index 3 waala item le le aur uss par puure rupay kharch kar de.Index 1 and 2 waale item woh khareed nhi paayegyi i.e she had only 2 choices and shopkeeper aslo said k = 2. i.e shopkeeper is true. Yes
200 3       ----> Alex has 200 Rs and Shopkeeper ne bola hain kii woh 200 Rs ke item 3 tareeke se le sakti hain. 0th index waala 2 item le le i.e (100 + 100) aur uss par puure rupay kharch de. Aur index 1 waala item le le tab bhi puure rupay kharch. And index 3 waala 2 item le le. Par index 2 waala nhi le paayegi hence she had only 3 choices to fully invest her money and shopkeeper also said this. i.e Yes
500 4       ----> Alex first index waale item par puure rupay kharch kar sakti hain (100 + 100 + 100 + 100 + 100) paach item khareed kar. Alex puure 500 rupay kharch nhi kar paayegyi on index 1 item. Because she can buy 2 items of index 1 and still she is left with 100 Rs. Same with index 2 alex can invest 400 Rs only and left with 100. But alex can buy 5 items on last index having cost of 100. Hence she had only 2 choices to fully invest all her money but shopkeeper said that she had 4 choices. i.e No
600 4       ----> Alex had only 3 choices. Whether she can buy 6 items of index 0 or 3 items of index 1 and 6 items of index 4. So, Alex donot have 4 choices to fully invest her money. Hence No
800 4       ----> Alex can invest all 800 rupees on item at index 0 by buying 8 items. Alex can invest her 800 rupees on item at index 1. Alex can invest her 800 rupees on item at index 2 and index 3. Hence she has 4 choices to invest all her money.

 */


import java.util.Scanner;

public class Alex_Goes_Shopping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int price[] = new int[n];

        for(int i = 0; i < n; i++){

            price[i] = sc.nextInt();
        }

        int q = sc.nextInt();

        while(q > 0){

            int A = sc.nextInt(); // Total Money alex have
            int k = sc.nextInt(); // Shopkeeper said that she has k choices

            if(isPossible(price , A , k)){

                System.out.println("Yes");

            }else{

                System.out.println("No");
            }

            q -= 1;
        }

    }

    public static boolean isPossible(int price[] , int A , int k){

        int count = 0;

        for (int i = 0; i < price.length ; i++){

            // Alex can invest all her money on index i or not
            if(A % price[i] == 0){

                // Alex can invest all her money on index i.
                count += 1;

            }
        }

        // Alex has atleast k choices as said by the shopkeeper. i.e shokeeper was true
        if(count >= k){

            return true;

        } // Alex has less choices as said by the shopkeeper.

            return false;
    }
}
