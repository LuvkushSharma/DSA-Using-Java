package Lec_1;

public class LinkedList_Client {

    public static void main(String[] args) throws Exception{

        LinkedList ll = new LinkedList();

        /*
            Agar ham head ko private nhi kaarengye then koi bhi aakar head ko null kar dega and by which
            all the data of the linkedlists will get lost.

            i.e we had declared head pointer as private so that it can only be accessed within the class.
            ll.head = null;


         */



        ll.addfirst(10);
        ll.addfirst(14);
        ll.addfirst(16);
        ll.addfirst(18);
        ll.addfirst(30);

        ll.display();

//        ll.addlast(11);
//        ll.addlast(18);
//
//        ll.display();



        /*

        ll.addlast(34);
        // System.out.println(ll.getfirst());
        // System.out.println(ll.getlast());

        ll.addlast(32);
        ll.addfirst(55);
        ll.addlast(76);

        ll.display();
        System.out.println(ll.getatindex(3));
        System.out.println(ll.getatindex(1));
        // System.out.println(ll.getatindex(-1));

        */


        /*

        System.out.println(ll.removefirst());
        ll.display();

        System.out.println(ll.removelast());
        ll.display();
        System.out.println(ll.removelast());
        ll.display();
        System.out.println(ll.removelast());
        ll.display();

         */

        /*

        ll.display();
        //System.out.println(ll.removeatindex(1));
        //System.out.println(ll.removeatindex(3));
        //System.out.println(ll.removeatindex(0));
        ll.display();

         */

        /*

        ll.display();
        //ll.addatindex(106 , 2);
        ll.addatindex(108 , 4);
        ll.display();


         */

    }
}
