package S_150;

import java.util.Scanner;

public class Array_Rain_water_trap {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T > 0){

            int N = sc.nextInt();
            int arr[] = new int[N];

            for(int i = 0; i < N ; i++){

                arr[i] = sc.nextInt();
            }

            int ans = Trapped_Water(arr);

            System.out.println(ans);


            T -= 1;
        }

    }

    public static int Trapped_Water(int arr[]){

        int N = arr.length;

        int Left[] = new int[N];

        // ------------------------ Prefix Max -----------------------

        // Since no number before 0th index i.e initializing Left[0] by arr[0]
        Left[0] = arr[0];

        for(int i = 1; i < N ; i++){

            Left[i] = Math.max(arr[i], Left[i-1]);
        }

        int Right[] = new int[N];

        // ------------------------ Suffix Max -----------------------

        // Since no number after (N-1)th index i.e initializing Right[N-1] by arr[N-1]
        Right[N-1] = arr[N-1];

        for(int i = (N-2); i >= 0 ; i--){

            Right[i] = Math.max(arr[i], Right[i+1]);
        }

        int ans = 0;

        for(int i = 0; i < N ; i++){

            int Min = Math.min(Left[i] , Right[i]);
            ans += (Min-arr[i]);
        }

        return ans;
    }

}
