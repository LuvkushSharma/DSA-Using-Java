
/*

    3   5    2   4    6

    for i = 1 to arr.length
       picked = arr[i]
       j = i-1;

       while (j >= 0 && arr[j] > picked) {

               arr[j+1] = arr[j];
               j--; --------> Peeche waale patto se bhi check karo.
       }

       arr[j+1] = picked

   ------------------------- Dry Run ---------------------------------------------

    -----> i = 1
    picked = 5;
    j = 0;

    while (j > = 0 && 3 > 5) --> false

    ------> i = 2
    picked = 2
    j = 1

    while (1 >= 0 && 5 > 2) { ----> true

         arr[2] = arr[1]; ---> arr[2] = 5
         j-- i.e j = 0 -----> Peeche agar numbers hongye toh ham picked patta unse bhi compare karengye.

          3   5   5   4    6

    }

    while (0 >= 0 && 3 > 2) { ----> true

         arr[1] = arr[0]; ---> arr[1] = 3
         j-- i.e j = -1 -----> Now abb patte khatam peeche.

         3   3    5   4    6

    }

    arr[j+1] = picked -----> arr[0] = 2;


    ------> i = 3
    picked = 4
    j = 2

    while (2 >= 0 && 5 > 4) { ----> true

         arr[3] = arr[2]; ---> arr[3] = 5
         j-- i.e j = 1 -----> Peeche agar numbers hongye toh ham picked patta unse bhi compare karengye.

          2   3   5   5    6

    }

     while (1 >= 0 && 3 > 4) ----> false

     arr[j+1] = picked ; ------> arr[2] = 4

     2   3   4   5    6


    ------> i = 4
    picked = 6
    j = 3

    while (3 >= 0 && 5 > 6) ------> false

    arr[4] = 6;

    2   3   4   5    6

 */


public class Insertion_Sort {

    public static void main(String[] args) {

        int arr[] = {2 , 13 , -4 , 5 , 7};

        Sort(arr);

        // Display the array
        for (int i = 0 ; i < arr.length ; i++) {

            System.out.print(arr[i] + " ");
        }
    }

    public static void Sort (int arr[]) {

        // Single element always sort hoga i.e due to this reason loop 1 se start hoga.
        for (int i = 1 ; i < arr.length ; i++) {
            int picked = arr[i]; // Hand picked card
            int j = i - 1;

            while (j >= 0 && arr[j] > picked) {

                arr[j + 1] = arr[j];
                j--; // Picked patte ko peeche waale patto se bhi compare karengye.

            }

            arr[j + 1] = picked;

        }
    }
}
