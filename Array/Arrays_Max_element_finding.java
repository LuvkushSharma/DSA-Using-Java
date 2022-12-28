package S_150;

public class Arrays_Max_element_finding {

    public static void main(String[] args) {

        int arr[] = {1,3,1,3,2,4,422,99};

        System.out.println("Max value in the array : " + Max(arr));

    }

    public static int Max(int arr[]){

        int max = arr[0];

        for(int i = 1 ; i < arr.length ; i++){

            if(arr[i] > max){

                max = arr[i];
            }
        }

        return max;
    }
}
