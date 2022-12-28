public class Basic_functions {

    public static void main(String[] args) {

        String s = "HelloHey";

        System.out.println(s.charAt(3));

        System.out.println(s.length());

//        Substring is a contigious and forward moving part of the string.

//        Last index is not included in this substring function.
//        i.e we will get the characters from 2 to 4.
        System.out.println(s.substring(2,5));

//      Empty string will be printed.
        System.out.println(s.substring(1,1));

//        Compare two strings in the dictionary way i.e lexicographically way.
        String s1 = "Kunal";
        String s2 = "Komal";

//        if s1 bada then positive value will be returned.
//        if s2 bada then negative value will be returned.
//        And if both are equal then 0 will be returned.

//        As s1 is big i.e positive value will be returned.
        System.out.println(s1.compareTo(s2));
    }
}
