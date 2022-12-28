

// Code of String ----> CompareTo method.



public class Compare_two_strings {

    public static void main(String[] args) {

//        String s1 = "Kunal";
//        String s2 = "Komal";
//
//        System.out.println(compareTo(s1 , s2));

        String s1 = "Raj";
        String s2 = "Riya";

        System.out.println(compareTo(s1 , s2));

    }

    public static int compareTo(String s1 , String s2){

        int i = 0; // Points to s1
        int j = 0; // Points to s2

//        Ex : Raj and Riya

//        R and R matches so if condition will no run. i = 1 and j = 1 now.
//        a != i so if condition runs. And (a - i) comes negative, Hence s2 is bigger. [We are subtracting the ASCII codes of a and i]

//        Ex: Kunal and Komal
//        K and K are equal so, if condition will not run. i.e i = 1 and j = 1.
//        u != o so, if condition runs. return (u - o) and it comes positive. Hence Kunal is bigger as compare to Komal.

        while(i < s1.length() && j < s2.length()){

            if(s1.charAt(i)!= s2.charAt(j)){

                return s1.charAt(i) - s2.charAt(j);
            }

            i++;
            j++;
        }

        // If return comes positive then s1 is bigger
//        And if return comes negative then s2 is big.
        return s1.length() - s2.length();
    }
}
