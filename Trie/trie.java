import java.util.HashMap;

/*

It's a prefix tree. Used for common prefix.

Names : Raj , Raju , Ankit , Ankita , Anmol , Rajani , Shivani , Mukesh


RAJ , RAJU , RAJANI have the common prefix i.e. RAJ so, common prefix ko baar baar store karne kii jagye ham kuh aur karengye


                    X <----
                 / |   | \  \
               A   A   R  R  R
             /     |   |   \   \
            N      N   A    A    A
          /        |   |      \   \
        K          K   J       J    J
       /           |            \    \
      T            T             U    A
                   |                    \
                   A                     N
                                          \
                                           I





                                X (root)
                            /       |
                           A        R
                        /    \       |
                      P       N       A
                    /       /  |       |
                   P      M    K        J
                 /       /     |      /    \
                E       O      I     A       U
                     /         |    /
                    L          T    N
                               |    /
                               A   I

              1. RAJ add kar diya.
              2. RAJU and RAJ main RAJ common hain so, RAJ ke neeche U laga dengye.
              3. ANKITA , since A se kuch common nhi hain isliye new word dalega.
              4. ANMOL : Common word AN toh uske neeche daal do bache words.


             Har ek brach kii last node ko color kar dengye. Let's say we had added APPLE in the TRIE so, E is colored.

             Insert APP.

             Since , APP as a word nhi hain. Toh ham kaise identify kare APP as word hain ya nhi.

             So, isliye we will mark the last node as colored. APPLE kaa terminal node , ANKITA kaa terminal node ,.... colored kardo.


             So, first we will store the initial Letter of each word so, that dekh sake kii particular word kaa initial letter exists karta
             hain kii nhi.

             And we will store this in the HashMap.

             Schema :
             1. Root Node kaa data
             2. Childs of that root node.
             3. Terminal hain kya uss word kaa

             Root node kaa data let's say ham '*' le liye hain. i.e. all the words generates from it.

             i.e. '*' se hee sab words generate ho rahe hain.


             Insert RAJ

           1.
             X <---- ROOT node
             |
             R <---- since R nhi hain X ke child main isliye new node banega.


           So, now child of X becomes R

           2. X
              |
              R
              |
              A
              |
              J

            mark J as terminal node.





 */


public class trie {

    public class Node {

        char data;
        HashMap<Character, Node> children = new HashMap<>();
        boolean isterminal = false;
        int count = 0;

        public Node(char c) {

            this.data = c;
            this.count = 1;
        }

    }

    private Node root;

    public trie() {

        Node nn = new Node('*');
        this.root = nn;
    }

    public void insert (String word) {

        Node curr = this.root; // '*'

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (curr.children.containsKey(ch)) {

                curr = curr.children.get(ch);
                curr.count = curr.count + 1;

            } else {

                Node nn = new Node(ch);
                curr.children.put(ch, nn);
                curr = nn;

            }

        }

        curr.isterminal = true;// color yaha Word end ho raha h

    }

    // EX : APP
    // let's say APPLE HAIN butt APP nhi.
    // so, A hain --> yes
    // P hain --> yes
    // P hain ---> yes
    // But terminal true nhi hain isliye return false.

    // EX : API
    // A hain ---> yes
    // A kaa child P hain ---> yes
    // P kaa child I hain ---> No return false

    // So, 2 conditions main return false hoga.

    public boolean search(String word) {

        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.children.containsKey(ch)) {
                return false;
            } else {

                curr = curr.children.get(ch);

            }

        }
        return curr.isterminal;
    }

    // APP se start hone word check karengye. terminal bhale true naa ho i.e. as a string present hain then return true.
    public boolean startsWith(String prefix) {

        Node curr = this.root;

        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            if (!curr.children.containsKey(ch)) {

                return false;

            } else {

                curr = curr.children.get(ch);

            }

        }
        return true;
    }

    public int countword(String word) {

        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.children.containsKey(ch)) {

                return 0;

            } else {

                curr = curr.children.get(ch);

            }

        }
        return curr.count;


    }

}
