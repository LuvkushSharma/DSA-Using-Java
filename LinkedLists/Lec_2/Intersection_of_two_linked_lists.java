package Lec_2;

/*

           Man1
            A1 ----> A2
                        \
                           A3 ----> A4 ----> A5-----> null
                         /
   B1 ----> B2 ----> B3

   Man2

  ----------->  Man1 = Man1.next  and Man2 = Man2.next
                Man1 reaches A2 and Man2 reaches B2


  ----------->  Man1 = Man1.next  and Man2 = Man2.next
                Man1 reaches A3 and Man2 reaches B3


  ----------->  Man1 = Man1.next  and Man2 = Man2.next
                Man1 reaches A4 and Man2 reaches A3

  ----------->  Man1 = Man1.next  and Man2 = Man2.next
                Man1 reaches A5 and Man2 reaches A4

                Man1 kaa raasta khatam nhi hua hain.

  ----------->  Man1 = Man1.next  and Man2 = Man2.next
                Man1 reaches null and Man2 reaches A5

                Man1 kaa raasta khatam but Man2 kaa raasta khatam nhi hua so, Man1 again head se suru karega.
                But Man1 suru karega Man2 ke head se.


   ----------->  Man1 = Man1.next  and Man2 = Man2.next
                 Man1 reaches B2 and Man2 reaches null

                 Man1 kaa raasta khatam nhi hua but Man2 kaa ho gaya i.e Man2 again starts from head but head of first Linked Lists.

   ----------->  Man1 = Man1.next  and Man2 = Man2.next
                 Man1 reaches B3 and Man2 reaches A2


   ----------->  Man1 = Man1.next  and Man2 = Man2.next
                 Man1 reaches A3 and Man2 reaches A3

                 Now both meets i.e out of while loop


    In , case both the linked lists donot intersect then they will meet at null and return null;


 */

public class Intersection_of_two_linked_lists {
}

/*

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // ------------------ Approach - 1 --------------
        // Pehle dono linked lists kaa size calculate karo : 5 , 6
        // Now , get the difference of both. (6 - 5) = 1
        // Jiska size bada hain usse difference tak agye chala do. i.e listB ko 1 times agye bhada do.
        // Iske baad parallel loop cahalao.


        // --------------- Approach - 2 --------------

        ListNode BF = headA;
        ListNode GF = headB;

        while (BF != GF) {

            if (BF == null) {

                BF = headB;

            } else {

                BF = BF.next;

            }


            if (GF == null) {

                GF = headA;

            } else {

                GF = GF.next;
            }
        }

        return BF;
    }
}

*/