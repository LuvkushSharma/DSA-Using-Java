public class StringReverse {

    public static void main(String[] args) {

        String s = "MADAM";

        System.out.println("Is string s is a palidrome : " + Reverse(s));


    }

    public static boolean Reverse(String s){

//        One pointer approach
        int i = 0;

        while(i <= s.length()/2){

            if(s.charAt(i) != s.charAt(s.length() - i - 1)){

                return false;

            }

            i += 1;
        }

        return true;
    }
}
