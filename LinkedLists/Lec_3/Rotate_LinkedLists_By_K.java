package Lec_3;

// For better Clarity do watch out this video : https://www.youtube.com/watch?v=9VPm6nEbVPA


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

/*

class Solution{

    public Node  getNode (Node head , int idx) {

        Node temp = head;
        int i = 1;

        while (temp != null) {

            if (idx == i) return temp;

            temp = temp.next;
            i += 1;
        }

        return temp;
    }

    public int getLen (Node head) {

        Node temp = head;
        int len = 0;

        while (temp != null) {

            len += 1;
            temp = temp.next;
        }

        return len;
    }


    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {

        // Minor Cases
        if (head == null || head.next == null || k == 0) return head;

        // Get the length of the LinkedLists
        int len = getLen (head);

        // Find the index where we need to break the link
        int to_break = (k % len);

        if (to_break == 0) return head;

        // Get the node where we need to break the link.
        Node nn = getNode (head , to_break);
        Node temp = nn.next;

        // Making Linked Lists Circular
        Node last = getNode (head , len);
        last.next = head;

        nn.next = null;
        head = temp;

        return head;
    }
}

*/