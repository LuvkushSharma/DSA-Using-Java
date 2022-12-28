package Lecture_2;

import java.util.ArrayList;

public class Find_All_Occurrence_Of_Element {

    public static void main(String[] args) {

//        int arr[] = {2,3,7,3,3,7,6,3};
//          int arr[] = {2,33,7,23,73,7,6,13};
        int arr[] = {2,33,7,23,43,7,6,3};

        int item = 3;

        ArrayList<Integer> Indexes = new ArrayList<Integer>();
        All_Occurrences(arr , 0 , item, Indexes);

        if(Indexes.size() == 0){
            System.out.println(-1);

        }else{

            for(int i = 0; i < Indexes.size() ; i++){

                System.out.print(Indexes.get(i) + " ");
            }
        }
    }

    public static void All_Occurrences(int arr[] , int i , int item , ArrayList<Integer> Indexes){

        // If whole array is traversed
        if(i == arr.length){
            return;
        }

        if(arr[i] == item){
            Indexes.add(i);
        }

        All_Occurrences(arr , i+1 , item , Indexes);
    }
}
