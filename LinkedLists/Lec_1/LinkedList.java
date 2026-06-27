package Lec_1;
// Stores data in the non-contiguous manner

public class LinkedList {

    // Creating class for the node of a linked lists
    public class Node{

        // We are not making them as private becoz for accessing them
        // we have to make getters and setters so, to access them
        // without getters and setters we will not set data and
        // next as private.
        int data;
        Node next;

        // Constructor
        public Node (int data){
            this.data = data;
        }

    }

    private Node head; // Start point of linked-lists not a node.
    private int size;
    private Node tail; // Points to the last node of the Linked lists.

    public void addfirst(int item){

        // Making a node
        Node nn = new Node(item);

        // Means zero nodes
        if (this.size == 0) {

            this.head = nn;
            this.tail = nn;
            this.size += 1;

        } else {

           nn.next = this.head;
           this.head = nn; // Moving head on left as we are adding nodes on the left.
           this.size += 1;
        }
    }

    public void addlast(int item){

        // Means zero nodes
        if(this.size == 0){

            addfirst(item);

        } else {


            // Making a node
            Node nn = new Node(item);

            this.tail.next = nn;
            this.tail = nn;
            this.size += 1;
        }
    }

    public void addatindex(int item , int index) throws Exception
    {

        if(index < 0 || index > size){

            throw new Exception("Index out of bound !!! Pgl index sahi se de");

        }else if(index == 0){

            addfirst(item);

        } else if(index == size){

            addlast(item);

        } else{

             Node nn = new Node(item);

             Node prev = GetNode(index-1);

             nn.next = prev.next;
             prev.next = nn;

             this.size += 1;
        }
    }

    // Printing the data of the first node
    public int getfirst() throws Exception {

        if(head == null){

            throw new Exception("pgl LinkedList khaali hain !!!");

        } else {

            return this.head.data;
        }
    }

    // Printing the data of the last node
    public int getlast() throws Exception {

        if(head == null){

            throw new Exception("pgl LinkedList khaali hain !!!");

        } else {

            return this.tail.data;
        }
    }

    // Assuming head at the 0th index
    public int getatindex(int index) throws Exception{

            if(index == 0){ // For the first node

                return getfirst();

            } else if(index == this.size - 1){ // For the last node

                return getlast();
            }

            return GetNode(index).data;

    }

    // Used to get the address of any node in a linkedlists
    private Node GetNode (int index) throws Exception{

        if(index < 0 || index >= size){

            throw new Exception("Index out of bound !!! Pgl index sahi se de");

        }
            Node temp = head;

            for (int i = 1 ; i <= index ; i++){

                temp = temp.next;
            }

          return temp;
    }

    //  O(1)
    public int removefirst() throws Exception{

        if(head == null){

            throw new Exception("Pgl pehle nodes toh bana fir delete maario !!!");

        } else if (size == 1) {

            Node temp = this.head;
            head = null;
            tail = null;

            // decreasing the size of the linked lists
            this.size -= 1;

            // returning deleted data
            return temp.data;// decreasing the size of the linked lists


        } else {

            Node temp = this.head;
            this.head = this.head.next;

            // Breaking friendship
            temp.next = null;

            // decreasing the size of the linked lists
            this.size -= 1;

            // returning deleted data
            return temp.data;
        }

    }

    public int removelast() throws Exception{

        if(head == null){

            throw new Exception("Pgl pehle nodes toh bana fir delete maario !!!");

        } else if(this.size == 1){

            return removefirst();

        } else {

            Node temp = GetNode(this.size-2);
            int removed_data = this.tail.data;

            this.tail = temp;

            // Breaking the friendship
            this.tail.next = null;

            // decreasing the size of the linked lists
            this.size -= 1;

            // returning deleted data
            return removed_data;
        }
    }

    public int removeatindex(int index) throws Exception {

        if(index < 0 || index >= size){

            throw new Exception("Index out of bound !!! Pgl index sahi se de");

        } else if(index == 0){

            return removefirst();

        } else if(index == this.size - 1){

            return removelast();

        } else {

            Node prev = GetNode(index-1);
            Node to_delete = prev.next;

            int deleted_data = to_delete.data;

            // Building bond btw nodes
            prev.next = to_delete.next;

            // Breaking the bonds
            to_delete.next = null;

            // decreasing the size of the linked lists
            size -= 1;

            return deleted_data;
        }
    }

    public void display(){

        Node temp = this.head;

        while (temp != null){

            System.out.print(temp.data + "-->");

            temp = temp.next;
        }

        System.out.println("null");
    }
}
