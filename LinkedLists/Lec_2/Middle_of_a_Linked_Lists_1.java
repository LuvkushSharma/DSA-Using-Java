package Lec_2;

public class Middle_of_a_Linked_Lists_1 {

}

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }


  class Solution {
    public ListNode middleNode(ListNode head) {

      ListNode fast = head;
      ListNode slow = head;

      // First condition is for even no. of nodes
      // Second condition is for odd no. of nodes
      while (fast != null && fast.next != null) {

        fast = (fast.next).next;
        slow = slow.next;
      }

      return slow;
    }
  }

*/