package S_150;

//        Forward moving data in the array should be considered as the subarray of the array.
//        Array : {2 , -4 , -1 , 5 , 7}

//          So, -4 and -1 is a subarray
//              -1 and 4 is not a subarray.
//

public class Maximum_Subarray_Sum {

    public static void main(String[] args) {

//        int arr[] = {2 , -5 , -6 , 5 , 7};

          int arr[] = {-2,-5,-6,-5,-7};

        int Ans = MaxSum(arr);

        System.out.println(Ans);
    }

    public static int MaxSum(int arr[]){

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length ; i++){
            int Sum = 0;
            for(int j = i; j < arr.length ; j++){
                Sum += arr[j];
                ans = Math.max(Sum , ans);

            }
        }

        return ans;
    }

}


