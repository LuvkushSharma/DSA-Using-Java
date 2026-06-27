package Lec_3.Cycle_Removal_Algorithm;

/*

Question :

If their is a Cycle in the LinkedLists then remove that cycle from the linkedlists. Other-wise print the linkedlists.

        start
    --------------     -------------     --------------     ----------------     ---------------
    |  1   | 2k  |---->|  2  | 3k  |---->|  3   | 4k  |---->|   4   |  5k  |---->|   5  |  6k  |
    --------------     -------------     --------------     ----------------     ---------------
          1k                 2k                ^                                         |
                                               |                                         |
                                               |                                         v
                                          --------------     -----------------     ---------------
                                          |  8  |  3k  |<----|   7   |   8k  |<----|  6  |  7k   |
                                          --------------     -----------------     ---------------
                                                                  meet
while (start != null) {

meet = hasCycle (ls);

while (temp.next != meet) {

  if (temp.next == start) {

     }

     temp = temp.next;
}
}

Abb main jab tak loop lagaunga jab tak jaahaan se start kiya wahi par naa aa jaau

7k is our meeting point of both slow and fast pointer.
temp = meet;

check -----> temp.next == start (1k)

temp.next --> 1k nhi milega aur puuri cycle ho jaayegyi

start = start.next

Similarly , check -----> temp.next == start (2k)

temp.next ---> 2k nhi milega.

start = start.next

Now, check ----------> temp.next == start (3k)

temp.next == start i.e we got the point.



// ------------------- Method - 2 ----------------------

In M_2.png -----------> Linear distance is n km and Circular distance is m km.

Ankit's GF travels : n + m
Ankit travels : n

Let's say : n = 10
            m = 15

Ankit's GF first travel m km
Then Ankit starts travelling and Ankit's GF also starts travel.

and they will meet at the starting of the circle.



// --------------- Method - 3 -----------------

       start
    --------------     -------------     --------------     ----------------     ---------------
    |  1   | 2k  |---->|  2  | 3k  |---->|  3   | 4k  |---->|   4   |  5k  |---->|   5  |  6k  |
    --------------     -------------     --------------     ----------------     ---------------
          1k                 2k                ^                                         |
                                               |                                         |
                                               |                                         v
                                          --------------     -----------------     ---------------
                                          |  8  |  3k  |<----|   7   |   8k  |<----|  6  |  7k   |
                                          --------------     -----------------     ---------------
                                                                    slow
                                                                    fast


Slow agar i distance cover kiya hoga toh fast 2i cover kiya hoga. -----> In Cycle Detection not in Cycle Removal

Fast Remaining i loop main chala hoga.

    Slow travelled = i
    Cycle Distance = i

    i.e jitna slow chala hain utna hee hain cycle kaa distance.

------>    now , slow = start;
           fast = meet

          fast.next = 8k and slow.next = 2k

          8k != 2k

          fast = fast.next;
          slow = slow.next;

 ----->   so, fast at 8k and slow at 2k

          fast.next = 3k and slow.next = 3k

          i.e 3k == 3k

          so, fast.next = null;

 */

public class Cycle_Removal_Algo {

    // Creating class for the node of a linked lists
    public class Node{

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
        if(this.size == 0){

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

    public void display(){

        Node temp = this.head;

        while (temp != null){

            System.out.print(temp.data + "-->");

            temp = temp.next;
        }

        System.out.println("null");
    }

    // Tail ke next main kisi other node kaa address daal do.
    private void CreateCycle() throws Exception{

        Node nn = GetNode(2);
        tail.next = nn;

    }

    // Checking whether cycle exists in the LinkedLists or not. If no then return null else return the meeting point.
    public Node hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = (fast.next).next;

            if (slow == fast){

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) throws Exception{

        Cycle_Removal_Algo cl = new Cycle_Removal_Algo();
        cl.addlast(10);
        cl.addlast(20);
        cl.addlast(30);
        cl.addlast(40);
        cl.addlast(50);
        cl.addlast(60);
        cl.addlast(70);
        cl.addlast(80);

        cl.display();

        // First we create the cycle in the linkedlists
        cl.CreateCycle();
        // cl.display();

        // cl.RemoveCycle ();
        cl.display();


    }

    // M-1
    // Time Complexity : O(n^2)
    public void RemoveCycle () {

        Node meet = hasCycle(head);

        // Cycle not exists
        if (meet == null) {

            System.out.println("Cycle not exists in the LinkedLists");
            return;
        }

        Node start = head;
        while (start != null) {

            Node temp = meet;
            while (temp.next != meet) { // ------------> Cycle Completed

                if (temp.next == start) {

                    temp.next = null;
                    return;
                }

                temp = temp.next;
            }
            start = start.next;

        }
    }

    // Time Complexity : O(n)
    public void RemoveCycle2 () {

        Node meet = hasCycle(head);

        // Cycle not exists
        if (meet == null) {

            System.out.println("Cycle not exists in the LinkedLists");
            return;
        }

        // Calculating the Circular path distance
        int count = 1;
        Node temp = meet;
        while (temp.next != meet) { // ------------> Cycle Completed

                count += 1;
                temp = temp.next;
        }

        // Ankit's GF travels 15km
        Node fast = head;

        for (int i = 0 ; i < count ; i++) {

            fast = fast.next;
        }

        // Abb Ankit and Ankit's GF starts and meet at the starting of the Circle.
        Node slow = head;
        while (slow.next != fast.next) {

            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;

    }

    // -------------- Method - 3 --------------
    // Faaltu kaa jo distance calculate kiya hain upar woh mat karo.
    public void floydCycleRemoval () {

        Node meet = hasCycle(head);

        if (meet == null) {

            return;
        }

        Node slow = head;
        Node fast = meet;
        while (slow.next != fast.next) {

            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;

    }

}
