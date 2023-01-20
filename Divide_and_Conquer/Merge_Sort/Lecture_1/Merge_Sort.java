package Lecture_1;

// Time Complexity : O(nlogn)

public class Merge_Sort {

    public static void main(String[] args) {

        int arr[] = { 7 , 3 , 2 , 15 , 7 , 1};

        int ans [] = mergersort(arr , 0 , arr.length - 1);

        // Displaying the ans array
        for (int i = 0; i < ans.length ; i++) {

            System.out.print(ans[i] + " ");
        }
    }

    public static int [] mergersort(int arr[] , int low , int high) {

        // Base case
        if (low == high) {

             int a[] = new int[1];
             a[0] = arr[low];

             return a;
        }

        int mid = (low + high)/2;

        int part1[] = mergersort(arr , low , mid);
        int part2[] = mergersort(arr , mid+1 , high);

        // Conquering the divided arrays using MergeTwoSortedArray function.
        return MergeTwoSortedArray(part1 , part2);

    }


    // Used to conquering the arrays.
    public static int[] MergeTwoSortedArray(int arr1[] , int arr2[]) {

        int n = arr1.length;
        int m = arr2.length;

        int ans[] = new int[n+m];

        int i = 0; // arr1
        int j = 0; // arr2
        int idx = 0; // ans

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {

                ans[idx] = arr1[i];

                i += 1;
                idx += 1;

            } else {

                ans[idx] = arr2[j];

                j += 1;
                idx += 1;

            }
        }

        while (i < n) {

            ans[idx] = arr1[i];
            i += 1;
            idx += 1;

        }

        while (j < m) {

            ans[idx] = arr2[j];
            j += 1;
            idx += 1;
        }

        return ans;
    }
}
