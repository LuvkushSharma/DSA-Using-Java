import java.util.Scanner;

public class kth_root {

//    X^k <= n
//    Find the largest value of x if k and n are given already.

//    Ex : k = 3 and n = 43
//    1^3 <= 43
//    2^3 <= 43
//    3^3 <= 43
//    4^3 not less than 43 so x = 3 is the largest value which satisfies the above mathematical expression.

//    Use binary search for this.

//    Agar mujhe sorted array main ans ban raha tha aur mujhe min chaiye toh main uske left main jaunga.
//    i.e isBad version main ham ans ke left main jaa rahe the

//    And if i got the answer and i want the max then go to the right.


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 67;
        int k = 3;

        int ans = kthroot(n , k);

        System.out.println(ans);

    }

    public static int kthroot(int n , int k){

        int low = 1;
        int high = n;
        int ans = 0;

        while(low <= high){

            int mid = (low + high)/2;

            if(Math.pow(mid , k) <= n){

                ans = mid;
                low  = mid + 1; // abb ans se badi value

            } else{

                high = mid - 1;

            }
        }
        return ans;
    }
    
}
