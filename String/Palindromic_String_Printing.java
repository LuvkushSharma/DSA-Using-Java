public class Palindromic_String_Printing {

    public static void main(String[] args) {

        String str = "nitin";

        printSubString(str);


    }

    public static void printSubString(String str){

        for(int i = 0; i < str.length(); i++){

            for(int j = i+1; j <= str.length(); j++){

                String temp = str.substring(i , j);

                // Printing Palindromic Substring
                if(isPalindromicSubString(temp)){

                    System.out.println(temp);
                }

            }
        }
    }

    public static boolean isPalindromicSubString(String str){

        int i = 0;
        int n = str.length();
        int j = n - 1;

        while(i < j){

            if(str.charAt(i) != str.charAt(j)){

                return false;
            }

            i += 1;
            j -= 1;
        }

        return true;
    }
}
