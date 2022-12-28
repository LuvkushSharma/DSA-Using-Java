package Lecture_2;

public class First_Occurrence_Of_Element {

    public static void main(String[] args) {

        int arr[] = {2,13,7,5,3,4,5,6,3,9,3};

        System.out.println(FirstIndex(arr , 0 , 3));
    }

    public static int FirstIndex(int arr[] , int i, int item){

        // Base case - 1
        // If whole the array is traversed and still we didn't get the element
        // then in that case return -1;
        if(i == arr.length){
            return -1;
        }

         // Base case - 2
        // When we got our answer
        if(arr[i] == item){
            return i;
        }

        return FirstIndex(arr , i+1 , item);
    }
}
