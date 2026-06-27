package Lec_3;

/*

Sort List
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]


Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]


Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105



 */

public class Sort_List {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {

      }
      ListNode(int val) {
          this.val = val;

      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;

      }

  }

}

// --------------- Solution same as Merge sort -------------------

/*

Jab do size kaa LinkedLists bachega tab Stack Over Flow hoga.

        --------------    -------------
        |  1  | 4k  |---->|  4  | 8k  |
        --------------    -------------
                              4k

              middle will give mid at 4k

              i.e left part as having mid.next = null

        --------------    -------------
        |  1  | 4k  |---->|  4  | null |
        --------------    -------------

        and Right part as null.

        i.e we got the same question again having two nodes. Which give Run Time error.

        i.e we have to modify the code of the Middle of the linkedlist.

        fast.next.next != null ------------> Condition for even modified.


 */

/*

class Solution {

    public ListNode sortList (ListNode head) {

        // Base case
        if (head == null || head.next == null) {

            return head;
        }

        ListNode mid = middleNode(head); // -----------> Finding mid of the linkedlists
        ListNode headb = mid.next;
        mid.next = null;

        ListNode l1 = sortList (head);
        ListNode l2 = sortList (headb);

        return Merge_Two_Sorted_Lists (l1 , l2);
    }

    // For finding the middle of the linked lists
    public ListNode middleNode(ListNode head) {

       ListNode slow = head;
       ListNode fast = head;

        // First condition is for even no. of nodes
        // Second condition is for odd no. of nodes
        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = (fast.next).next;

        }

        return slow;
    }

    // Merging two sorted lists
    public static LinkedList Merge_Two_Sorted_Lists (LinkedList list1 , LinkedList list2) {

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
