import java.util.Scanner;

public class OddEvenPlaceChar {

        public static void main(String args[]) {
            // Your Code Here

            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine();

            String ans = OddEvenChar(s);

            System.out.println(ans);
        }

        public static String OddEvenChar(String s){

            String str = "";

            // Traversing the string
            for(int i = 0; i < s.length() ; i++){

                // Even character
                if(i % 2 == 0){

                    char c = (char)((int)s.charAt(i) + 1);
                    System.out.println(c);


                }else{

//                    str += (s.charAt(i) - 1);
                }
            }

            return str;
        }
    }


