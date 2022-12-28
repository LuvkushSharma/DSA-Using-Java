import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class User_input_in_ArrayList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> lst = new ArrayList<>();

        for(int i = 0; i < 4 ; i++){

            // M-1
            // lst.add(sc.nextInt());

            // M-2
            int element = sc.nextInt();
            lst.add(element);
        }

       for(int val : lst){
           System.out.println(val);
       }

        System.out.println("\nPrinting list : " + lst);

       // Sorting the ArrayList
        Collections.sort(lst);

        System.out.println("Printing Sorted list : " + lst);


        /*

        Internal Working of ArrayList

                 ArrayList           |          Capacity increases by 2times
        --------------------------------------------------------------------
                   10                        Size = 1 and Let Capacity = 1

                   Puurana data pehle copy kiya jaayega
                   10 20                     Size = 2 and Capacity = 2

                   10 20 30                  Size = 3 and Capacity = 4

                   10 20 30 40               Size = 4  and Capacity = 4

                   10 20 30 40 50            Size = 5 and Capacity = 8




         */
    }
}
