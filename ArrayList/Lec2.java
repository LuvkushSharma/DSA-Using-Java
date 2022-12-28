import java.util.ArrayList;

public class Lec2 {

    public static void main(String[] args) {

        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(12);
        lst.add(13);
        lst.add(14);

        // lst size will give the total number of space elements occupied. Since, we have only three elements
        // i.e size  = 3
        System.out.println(lst.size());


        /*

        ----------------------- Capacity and Size --------------------

        Capacity of our class is 200 students

        But size of the super 150 student is 150.

        i.e 200 student beth sakte hain class main par 150 beth rahe hain.
        so, Capacity 200 thi par size abhi 150 hee hain.


         */


        //        Array list grows like this
        //        (old capacity + old capacity/2 + 1)


        /*

                 Initial Capacity of the array is 10
                 Array :  10    30   20    40    50      60       70     80      90
                 index :   0     1    3     4     5      6        7       8       9

                 Now, capacity is full so, capacity will increase

                 New capacity = (old capacity + old capacity/2 + 1)
                 New capacity = 10 + 10/2 + 1 => 16

                 Abb puura data firse copy kiya jaayega
                 Array :  10 30  20  40  50 60 70  80 90 110
                 index :   0  1  3    4  5   6  7  8   9  10  11  12  13  14  15


         */



        //        Jitna element hain utne index tak element ko rakh sakte hain.
        //        ArrayList<Integer> list = new ArrayList<>();
        //        list.add(2,-15);






    }
}
