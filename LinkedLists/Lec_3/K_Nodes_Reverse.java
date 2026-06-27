package Lec_3;

public class K_Nodes_Reverse {
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
 *


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        int iter = 0;
        ListNode ahead = head;
        ListNode curr = head;
        ListNode backward = null;

        ListNode temp = head;
        ListNode start = head;

        int len = ListLen (head);

        int req_len = len - (len % k);

        while (curr != null) {

            if (iter != k) {

                if (iter == 0) {

                    start = curr;
                }

                ahead = ahead.next;
                curr.next = backward;
                backward = curr;
                curr = ahead;

                iter += 1;
                count += 1;

                if (count == k) {

                    head = backward;
                    iter = 0;
                    backward = null;

                }

                if (iter == k && count > k) {

                    iter = 0;
                    temp.next = backward;
                    temp = start;
                    backward = null;

                }

                if (count == req_len) {

                    break;
                }
            }
        }

        if (curr != null) {

            start.next = curr;
        }



        return head;
    }

    public int ListLen (ListNode head) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {

            count += 1;
            temp = temp.next;
        }

        return count;
    }
}

 */