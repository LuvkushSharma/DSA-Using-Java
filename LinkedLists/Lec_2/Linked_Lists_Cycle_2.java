package Lec_2;

/*

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the
next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is
not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

 */

/*
    --------------     -------------     --------------     ----------------     ---------------
    |  1   | 2k  |---->|  2  | 3k  |---->|  33   | 4k  |---->|   4   |  6k  |---->|   5  |  5k  |
    --------------     -------------     --------------     ----------------     ---------------
                                               ^                                         |
                                               |                                         |
                                               |                                         v
                                          --------------     -----------------     ---------------
                                          |  8  |  3k  |<----|   7   |   8k  |<----|  6  |  7k   |
                                          --------------     -----------------     ---------------


     Agar tail.next main head ke alaawaa aur koi address hoga then woh Cyclic hoga.
     And , if tail.next = head in that case Circular Linked lists will be their.

     M-1 :

     Putting addresses of each node in an Arraylist. And if same address present in the ArrayList then return that address

     Time-Complexity : O(n^2)


     M-2 :

     Time-Complexity : O(n)

 */

public class Linked_Lists_Cycle_2 {

}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }


public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = (fast.next).next;

            if (slow == fast){

                return true;
            }
        }

        return false;
    }
}

 */