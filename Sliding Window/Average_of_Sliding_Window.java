/*

You have to given a data stream terminated by -1 and the size of sliding window. For each variation
in sliding window you need to tell the average of data in current sliding window. Print 4 digits after the decimal point.

Input Format
First line contains an integer denoting the size of sliding window.
Second line has a data stream terminated by -1.

Constraints
None

Output Format
Print average of each sliding window.

Sample Input
5
51 62 24 51 79 33 72 78 84 42 -1

Sample Output
51.0000 56.5000 45.6667 47.0000 53.4000 49.8000 51.8000 62.6000 69.2000 61.8000

Explanation
None


 */


import java.util.ArrayList;
import java.util.Scanner;

public class Average_of_Sliding_Window {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        ArrayList<Integer> lst = new ArrayList<Integer>();

        while(true){

            int element = sc.nextInt();

            if(element == -1){

                break;
            }else{

                lst.add(element);
            }
        }


        float ans[] =  Average(lst , k);

        for(int i = 0; i < ans.length; i++){

            System.out.format("%.4f", ans[i]);
            System.out.print(" ");


        }
    }

    public static float[] Average(ArrayList<Integer> lst , int k){

        int n = lst.size();

        float ans[] = new float[n];

        int ind = 0; // ----> Tracks the ans array


        float sum = 0;

        // Form first window
        for(int i = 0; i < k ; i++){

            sum = sum + lst.get(i);

            float avg = sum/(i+1);

            ans[ind] = avg;
            ind += 1;

        }


        for(int i = k ; i < lst.size() ; i++){

            // Growing the window
            sum = sum + lst.get(i);

            // Shrinking the window
            sum = sum - lst.get(i - k);

            // Calculating the answer
            float avg = sum/k;
            ans[ind] = avg;
            ind += 1;

        }

        return ans;
    }
}
