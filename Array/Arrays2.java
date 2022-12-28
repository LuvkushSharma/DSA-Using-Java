package S_150;

public class Arrays2 {

    public static void main(String[] args) {

        int arr[] = {10,20,30,40,50};
        int other[] = {100 , 200 , 300 , 400, 500};
        System.out.println(arr[0] + " " + other[0]);
        Swap(arr , other);

//        No changes will occur
        System.out.println(arr[0] + " " + other[0]);
    }

//    Creating a new variable arr and other
//    Note : new array nahi bani hain arr will point to the arr array in the stack whereas
//    other will point to the other array.
    public static void Swap(int arr[] , int other[]){

        int temp[] = arr;
        arr = other;
        other = temp;



    }
}
