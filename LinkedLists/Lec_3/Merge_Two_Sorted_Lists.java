package Lec_3;

/*

Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.


--------------------------- Intuition -----------------------------
       headA
    --------------     -------------     --------------
    |  1   | 2k  |---->|  2  | 4k  |---->|  4   | null |
    --------------     -------------     ---------------
          1k                 2k                 4k

         headB
    --------------     -------------       --------------     ----------------     ---------------
    |  2   | 40k  |---->|  4  | 10k  |---->|  5   | 6k  |---->|   6   |  7k  |---->|   7  |  null |
    --------------      -------------       --------------     ----------------     ---------------
           8k                40k                  10k                 6k                  7k

Step-1 : Ek dummy node banao having 0 as item and null as address
         ---------------
         |  0  |  null |
         ---------------

         1 and 2 main se 1 is smaller.

         dummy.next = headA

    --------------     -------------
    |  0   | 1k  |---->|  1  | 2k  |
    --------------     -------------
                          dummy


  ---->  increament the dummy pointer and headA pointer.

Step-2 : headA.val == headB.val i.e else condition

         dummy.next = 8k i.e dummy.next = headB

    --------------     -------------     ----------------
    |  0   | 1k  |---->|  1  | 8k  |---->|  2   |   40k |
    --------------     -------------     ----------------
                                             dummy
                dummy = dummy.next;
                headB = headB.next;

Step-3 :  2 < 4

    --------------     -------------     ----------------    ----------------
    |  0   | 1k  |---->|  1  | 8k  |---->|  2   |   40k |---->|   2  |   4k |
    --------------     -------------     ----------------    ----------------
                           1k                  8k               2k  dummy

     dummy = dummy.next
     headA = headA.next;

Step-4 : 4 == 4 i.e else

    --------------     -------------     ----------------    ----------------     ----------------
    |  0   | 1k  |---->|  1  | 8k  |---->|  2   |   40k |---->|   2  |   4k |---->|   4  |  10k  |
    --------------     -------------     ----------------    ----------------     ----------------
                          1k                  8k                  2k                  40k dummy                                                 dummy

     dummy = dummy.next
     headB = headB.next;

Step-5 : 4 < 6 i.e if condition


    --------------     -------------     ----------------    ----------------     ----------------    ---------------
    |  0   | 1k  |---->|  1  | 8k  |---->|  2   |   40k |---->|   2  |   4k |---->|   4  |  4k  |---->|   4  |  null|
    --------------     -------------     ----------------    ----------------     ----------------    ---------------
                          1k                  8k                  2k                  40k              (4k)    dummy                                                 dummy

     dummy = dummy.next
     headA = headA.next;

 ---------------------------->







 */

public class Merge_Two_Sorted_Lists {

    public static void main(String[] args) {


    }

}

/*

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }




    public static void Merge (LinkedList list1 , LinkedList list2) {

       ListNode Dummy = new ListNode();
       LisNode temp = Dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {

                Dummy.next = list1;
                Dummy = Dummy.next;
                list1 = list1.next;

            } else {

                Dummy.next = list2;
                Dummy = Dummy.next;
                list2 = list2.next;

            }
        }

        if (list1 == null) {

            Dummy.next = list2;
        }

        if (list2 == null) {

           Dummy.next = list1;
        }

        return temp.next;

    }
}

*/
