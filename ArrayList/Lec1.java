

/*

Before ArrayList we have to learn Wrapper Class.

 */


/*

                    ArrayList                                            Array
             ----------------------------------------------------------------------------
             1.     Dynamic (Run time par                                     Static
                    size grow hoga)

             2.     Internally ye bhi array                                   Ye toh array hain hee.
                    ko maintain kiya hain.

             3.     ArrayList< type_of_Non-Primitive_dataType > var_name;         int arr[];


 */


import java.util.ArrayList;

public class Lec1 {

    public static void main(String[] args) {

        // Creating a Integer class arraylist.
        // new ArrayList<>() creates memory allocation
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Size of the string : " + list.size());
        System.out.println(list); // Empty list will be created.

        // Adding the element from the rear position
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

        // Add at index
        list.add(1,50); // index kaa range 0 to size
        list.add(0 , 3440);
        // list.add(7 , 8990); ----> 7 is out of the range of 0 to size
        // size waale index main peeche se add karega
        list.add(5 , 8907);

        System.out.println(list);
        System.out.println("Size of the list : " + list.size());

        // Removing element from the list
        System.out.println(list.remove(4)); // index kaa range from 0 to size-1
        System.out.println(list);


        // Accessing value at a particular index
        System.out.println(list.get(3)); // index kaa range from 0 to size-1 i.e we can only access value at index btw 0 to size-1
        System.out.println("Getting the element : " + list.get(2));

        // Updating value at a particular index
        list.set(3,-90); // Value ko update karta hain
        System.out.println(list);

        System.out.println("\nArray elements printing : ");
        for(int i = 0; i < list.size() ; i++){

            System.out.println(list.get(i) + " at index : " + i);

        }
    }
}
