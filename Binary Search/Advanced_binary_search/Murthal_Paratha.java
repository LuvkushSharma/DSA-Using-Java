package Advance_Binary_Search;

/*

The coding blocks members went to the success party of their first ever online boot-camp at Murthal.
They ordered P number of paranthas. The stall has L cooks and each cook has a rank R. A cook with a rank R can cook 1 parantha
in the first R minutes 1 more parantha in the next 2R minutes, 1 more parantha in 3R minutes and so on(he can only cook a
complete parantha) ( For example if a cook is ranked 2 he will cook one parantha in 2 minutes one more parantha in the next
4 mins and one more in the next 6 minutes hence in total 12 minutes he cooks 3 paranthas. In 13 minutes also he can cook only
3 paranthas as he does not have enough time for the 4th parantha). Calculate the minimum time needed to cook all the paranthas.

Input Format
First line contains P, the number of pratha ordered. In the next line the first integer denotes the number of cooks L and L integers follow in the Next line each denoting the rank of a cook.

Constraints
P <= 1000
L <= 50
1 <= R <= 8

Output Format
Print an integer which tells the number of minutes needed to get the order done.

Sample Input
10
4
1 2 3 4
Sample Output
12
Explanation
First cook with rank 1 cooks 4 paranthas in 10 minutes (1+2+3+4).
Second cook with rank 2 cooks 3 paranthas in 12 minutes (2+4+6)
Third cook with rank 3 cooks 2 paranthas in 9 minutes (3+6) Fourth cook with rank 4 only needs to cook one last remaining parantha. He can do that in 4 minutes.
Since these cooks cook parallely, the total time taken will be the maximum of the four i.e. 12 minutes.



 */

import java.util.Arrays;
import java.util.Scanner;

public class Murthal_Paratha {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int L = sc.nextInt();
        int rank[] = new int[L];
        for(int i = 0;i < L;i++)
        {
            rank[i] = sc.nextInt();
        }

        System.out.println(parantha_ban_payega_kya(rank,P,L));


    }
    public static int parantha_ban_payega_kya(int rank[],int P,int L)
    {

        Arrays.sort(rank);
        int p = P;
        int low = 0;
        int high = 0;

        int x = 1;
        int y = rank[rank.length-1];

        while(p > 0)
        {
            high += y * x;// saare paranthe sabse zada rank wala chef hi banaaye
            x++;
            p--;
        }

        int ans = 0;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(isitpossible(rank , P , mid) == true)
            {
                high = mid - 1;
                ans = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isitpossible(int []rank,int P,int mid)
    {
        int paranthe = 0;
        int sum = 0;
        for(int i = 0;i < rank.length;i++)
        {
            int x = rank_parantha(rank[i],mid);
            paranthe += x;


            if(paranthe >= P)
                return true;
        }
        return false;
    }
    public static int rank_parantha(int rank,int mid)
    {
        int sum = 0;
        int x = 0;
        while(sum < mid)
        {
            int y = x * rank;
            if(sum + y <= mid)
                sum += y;
            else break;
            x++;
        }
        if(x <= 0)return 0;
        return --x;
    }
}
