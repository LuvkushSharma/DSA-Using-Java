package Lecture_3;

public class Monkey_Jumps_To_Reach_At_N {

    public static void main(String[] args) {

        int n = 4;

//        int count = BoardPath(n , 0 , "");
//        System.out.println("\n" + count);

        // M-2
        System.out.println("\n" + BoardPath1(n , 0 , ""));
    }

    public static int BoardPath(int end , int curr , String ans){

        // Base case-1
        if(curr == end){

            System.out.println(ans);
            return 1; // To count the number of ways
        }

        // Base case-2
        if(curr > end){

            return 0;
        }

        // Three Possibilities i.e three recursive calls

        // One jump at a time i.e index increases by 1 i.e curr + 1
        // and concatenating 1 in the ans string
        int OneJump = BoardPath(end , curr+1, ans+1);

        // Two jump at a time i.e index increases by 2 i.e curr + 2
        // and concatenating 2 in the ans string
        int TwoJump = BoardPath(end , curr+2, ans+2);

        // Three jump at a time i.e index increases by 3 i.e curr + 3
        // and concatenating 3 in the ans string
        int ThreeJump = BoardPath(end , curr+3, ans+3);

        // Counting the number of ways and Printing simultaneously
        return OneJump + TwoJump + ThreeJump;

    }

    // Jab 3 , 4 ,... or 10 aur usse bhi jaada recursive calls lagaane ho toh
    // ham loop main rakh dengye  unn recursive calls ko.
    // Maan lo agar aapko exam main code likhna hain aur copy paste allowed nhi hain
    // fir agar ham kai saare recursive calls likhengye toh bahut time lagyegaa
    // i.e we will use loop in that case.

    public static int BoardPath1(int end , int curr , String ans){

        // Base case-1
        if(curr == end){

            System.out.println(ans);
            return 1; // To count the number of ways
        }

        // Base case-2
        if(curr > end){

            return 0;
        }

        int count = 0;

        for (int i = 1; i <= 3; i++){

           count += BoardPath1(end , curr + i, ans+i);
        }

        return count;
    }
}
