package Lecture_4;

public class Nokia_Phone {

    // Index 0 par kuch nhi rakhengye as we are not going to press 0
    // After pressing 1 we will get any of the three characters i.e abc

    // Global variable
    static String key[] = {"","abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};

    public static void main(String[] args) {

        String s = "12";
        PrintKeyPad(s , "");

    }

    public static void PrintKeyPad(String ques , String ans){

        if(ques.length() == 0){

            System.out.print(ans + " ");
            return;
        }

        // Initially 1 ayega

        char ch = ques.charAt(0);

        // ASCII : '1' --> 49
        // Agar direct 49 daalunga toh kuch nhi ayega as String corresponds to
        // 1 is at index-1. Hence to get the string corressponds to 1 subtract
        // ASCII Code of 0 i.e 48 from ASCII code of 1.

        // ASCII Code of 2 is 50 and ASCII code of 0 is 48
        // String at 2 = key[ASCII_2 - ASCII_1] i.e key[2]
        // number ko press karne ke baad kitne characters aa sakte hain
        String pressString = key[ch-48];


        for (int i = 0; i < pressString.length() ; i++){

                 PrintKeyPad(ques.substring(1),ans+pressString.charAt(i));
        }
    }
}
