public class trie_client {

        public static void main(String[] args) {

            trie t = new trie();
            t.insert("apple");
            t.insert("go");
            t.insert("mango");
            t.insert("priya");
            t.insert("puneet");
            t.insert("raj");
            t.insert("ram");
            t.insert("rajesh");
            t.insert("gudi");
            t.insert("man");

            System.out.println(t.search("apple"));
            System.out.println(t.startsWith("app"));
            System.out.println(t.countword("app"));
            System.out.println(t.countword("man"));

        }

}

