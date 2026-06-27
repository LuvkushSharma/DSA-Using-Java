package Lec_3;

import java.util.*;

/*

Given a linked list with n nodes. Find the kth element from last without computing the length of the linked list.

Input Format
First line contains space separated integers representing the node values of the linked list. The list ends when the input
comes as '-1'. The next line contains a single integer k.

Constraints
n < 10^5

Output Format
Output a single line containing the node value at the kth element from last.

Sample Input
1 2 3 4 5 6 -1
3
Sample Output
4
Explanation
The linked list is 1 2 3 4 5 6. -1 is not included in the list. So the third element from the last is 4



---------------------------- Intuition ----------------------

Take two pointers : fast and slow

first move fast pointer till k nodes i.e if k = 3 then move fast pointer from head to 3 nodes.

Then start slow pointer from head. As , we had created a gap of k nodes between fast and slow.
So, if fast is reached to the end of the linkedlists then slow will be at the desired node.


 */

class LinkedLists {

    class Node {

        // Data Members
        int val;
        Node next;

        public Node (int item) {

            this.val = item;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addlast (int item) {

        Node nn = new Node (item);

        if (head == null) {

            head = nn;
            tail = nn;
            size += 1;

        } else {

            tail.next = nn;
            tail = nn;
            size += 1;
        }
    }

    public int kLast (int k) {

        Node fast = head;
        Node slow = head;

        // First Moving fast till k nodes. So, that a gap of k nodes will remain b/w
        // slow and fast.

        for (int i = 0 ; i < k ; i++) {

            fast = fast.next;
        }

        while (fast.next != null) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }
}

public class kth_element_from_last {

    public static void main (String args[]) {

        Scanner sc = new Scanner (System.in);

        LinkedLists ls = new LinkedLists();

        int num = 0;
        while (num != -1) {

            num = sc.nextInt();
            ls.addlast (num);

        }

        int k = sc.nextInt();

        int ans = ls.kLast(k);

        System.out.println (ans);

    }
}