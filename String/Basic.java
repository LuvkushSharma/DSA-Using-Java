public class Basic {

    public static void main(String[] args) {

//        String is a class in java and a non-primtive data type.

          String s = "name"; // String literal (i.e without new keyword)

          String s1 = new String("name");  // forms in the heap

          // In this a == b address will be compaired not the content.

        String str = "Hello";

        // Important :
        // String ke liye ek special area hain heap main jisse ham String Pool or Intern Pool bolte hain.
        // Aur iske andarr kisi location par jaake "Hello" store hoga let's say 6k address par.
        // Ye 6k ----> str main store hoga.
        // i.e str contains 6k address.

        String str1 = "Hello";
        // Ye Hello ----> heap main intern pool/ string pool main jaayega aur check karega kii
        // Hello naam kaa string hain kya. Agar hain toh dono string same hee location ko point karengye.
        // i.e 6k

        /*

        Summary : str1 pool main create nhi hoga as it is matched with str so, same address will be assigned to str1 also.
                  Store str aur str1 dono main address hee hoga but print content hee hoga.

         */

        /*

        Note :

        Jab String new keyword ke through create kiya jaata hain toh string kabhi pool main nhi create hoga.

        Ye string pool se bahaar par heap main banega.

         */


    }
}
