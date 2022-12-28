package S_150;

public class Arrays_Reverse {

    public static void main(String[] args) {

        int arr[] = {1,3,1,3,2,4,422,99 ,77};

        Reverse(arr);

        Display(arr);

    }

    public static void Display(int arr[]){

        for(int i = 0; i < arr.length ; i++){

            System.out.print(arr[i] + " ");
        }
    }

    public static void Reverse(int arr[]){

        int i = 0;
        while(i < arr.length/2){

            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;

            i += 1;
        }
    }
}
