// Deepak and Gautam are having a discussion on a new type of number that they call Coding Blocks Number or CB
// Number. They use following criteria to define a CB Number.
//
//        0 and 1 are not a CB number.
//        2,3,5,7,11,13,17,19,23,29 are CB numbers.
//        Any number not divisible by the numbers in point 2( Given above) are also CB numbers.
//        Deepak said he loved CB numbers.Hearing it, Gautam throws a challenge to him.
//
//        Gautam will give Deepak a string of digits. Deepak's task is to find the number of CB numbers in the string.
//
//        CB number once detected should not be sub-string or super-string of any other CB number.
//        Ex- In 4991, both 499 and 991 are CB numbers but you can choose either 499 or 991, not both.
//
//        Further, the CB number formed can only be a sub-string of the string.
//        Ex - In 481, you can not take 41 as CB number because 41 is not a sub-string of 481.
//
//        As there can be multiple solutions, Gautam asks Deepak to find the maximum number of CB numbers that can be formed from the given string.
//
//        Deepak has to take class of Launchpad students. Help him by solving Gautam's challenge.
//
//
//


//        Input Format
//        First line contain size of the string.
//
//        Next line is A string of digits.
//
//        Constraints
//        1 <= Length of strings of digits <= 17
//
//        Output Format
//        Maximum number of CB numbers that can be formed.
//
//        Sample Input
//        5
//        81615

//        Sample Output
//        2

//        Explanation
//        61 and 5 are two CB numbers.


//  692239


// Substrings starting with the 6

// 6   ---> Divisible by 3
// 69  ---> Divisible by 3
// 692
// 6922
// 69223
// 692239

// If this 692239 becomes a CB number then we get only one CB number as it includes all the CB numbers that can be possible.
// May be 223 be a CB number but we cannot count this as it is already calculated into the Long CB number.

// So, for the maximum CB numbers we have to go for the smaller numbers first.



// --------------- Substrings Length-wise ----------------------------


// Length 1      Length 2         Length 3        Length 4          Length 5         Length 6
// ----------------------------------------------------------------------------------------------------
// 6    (0,1)       69  (0,2)       692   (0,3)      6922   (0,4)    69223   (0,5)    692239  (0,6)
// 9                92              922              9233            92239   (1,6)
// 2                22              223              2239   (2,6)
// 2                23              239    (3,6)
// 3                39   (4,6)
// 9    (5,6)


// In (i,j) j increases with the length of the substring.


// 2 , 2 and 3 are CB numbers
// 69 is divisible by 3 i.e not a CB number
// 92 is also not a CB number as 2 is already counted.
// 22 is also not a CB number as it is divisible by 2 aur Saath hee 2 toh already counted hain.
// 23 is also not a CB number as 2 and 3 are already counted. Aur 23 divisible bhi hain 23 se.

// Jo ek baar CB number banne main use ho gaya woh fir se use nhi hoga.
// Ex, in 471, both 47 and 471 are CB numbers but 47 already CB number counted ho chukaa hain toh abb
// 471 count nhi hoga becoz isme 47 hain jo kii already CB number counted ho chukaa hain.

//--------------- Steps to solve the problem --------------

// Step-1: First of all generate lenfth-wise substrings
// Step-2: Check CB number
// Step-3: Already kisi aur ke saath CB number naa ho.
// Step-4: Agar kisi ke saath CB number nhi hain toh Visited mark kar do.

public class FindingCBnumber_______Important {

    public static void main(String[] args) {

//        String str = "692239";
          String str = "81615";

        PrintLengthWiseSubstring(str);


    }

    public static void PrintLengthWiseSubstring(String str){

        int count = 0;

//        Ye array string ke har ek character ka visited dekhega kii woh CB toh nhi bani.
//       If str = "692239" then at 0th index 6 will be considered , 9 is at index 1 ,....
        boolean Visited[] = new boolean[str.length()];


//         Increasing the length of the substrings
        for(int len = 1; len <= str.length() ; len++){

//            System.out.println("Substrings of length : " + len);

              for(int j = len; j <= str.length(); j++){

                  int i = j - len;
//                System.out.println(str.substring(i , j));

//                Step - 1 : length wise substring
                  String s = str.substring(i , j);

//                Converting string to number
                  long num = Long.parseLong(s);

//                 Step-2 : Check number is a CB number or not
                  if(isCBnumber(num) == true){

//                    Step-3:  Check CB is visited or not
                      if(IsVisited(Visited , i , j-1) == true){

                          count += 1;

                          // Step 4 : Marking CB number as visited in the array.
                          for (int k = i; k <= j-1 ; k++){

                              Visited[k] = true;

                          }
                      }
                  }
              }

//            System.out.println();
        }


        // Printing the answer
        System.out.println("Max CB number possibles are : " + count);
    }


    public static boolean isCBnumber(long num){

        if(num == 0 || num == 1){

            return false;
        }

        int arr[] = {2,3,5,7,11,13,17,19,23,29};

//         If num is equal to any of them : 2,3,5,7,11,13,17,19,23,29
        for(int i = 0; i < arr.length; i++){

            if(num == arr[i]){

                return true;
            }
        }

//         If num divisible by the numbers : 2,3,5,7,11,13,17,19,23,29 then not a CB number
        for(int i = 0; i < arr.length; i++){

            if(num % arr[i] == 0){

                return false;
            }
        }


        return true;
    }

    public static boolean IsVisited(boolean Visited[] , int i , int j){

        for (int k = i ; k <= j ; k++){

            if(Visited[k] == true){

                return false;
            }
        }

        return true;

    }


}


