package S_150;

/*


Arr :   4   3    -2    6     -14       7     -1     4     5    7    -10    2    9    -10    -5     -9     6


Note-1 : Agar peeche se sum negative aa raha hain toh main train main nhi chadunga. Train mere se hee suru hogyi fir.
Note-2 : Agar peeche se sum positive aa raha hain fir curr element chaahe positive ho yaa fir negative woh peeche waali train main
         chadd jaayega. Woh toh kahi naa kahi kuch negative kam ho gaya naa isliye woh toh chadd jaayega.

Note-3 : Then compare overall_sum and curr_sum


        Curr_Best                                                        Overall_Best
     --------------------------------------------------------------------------------------

 --> Initializing       4                                                       4

     4,3 (Peeche se positive train thii i.e 4 isliye 3 chadd jaayega)           7 (4,3)
          agar 3 apne se train suru karega toh sum = 3 hoga but peeche se karega toh sum 7 hoga.

     4,3,-2                                                                     7 (4,3)
     (-2 agar puurane 7 main addon hoga toh banaayega 5 aur agar khud se suru karega toh banaayega
      sirf -2. Isliye woh peeche waali train main add ho jaayega)

      4,3,-2,6                                                                  11 (4,3,-2,6)
      (6 apni family start karega toh 6 banega par peeche waali family main add hoga toh 11 banega)

      4,3,-2,6,-14                                                              11 (4,3,-2,6)
      (-14 apni family start karega toh -14 banega par peeche waali train main bethega toh -3 banaayega)
       i.e -14 peeche waali train main beth jaayega.

 ----> Abb peeche waali train kaa sum negative ho gaya hain toh koi negative train main kyo bethega negative hone ke liye.
       i.e agar curr element +ve hua toh woh kam hee hoga aur -ve hua toh woh aur kam hoga. Toh kisi ko faayeda nhi hain.
       Apne se train suru hogyi.

       7                                                                        11

       7,-1                                                                     11

       7,-1,4                                                                   11

       7,-1,4,5                                                                 15


       7,-1,4,5,7                                                               22

       7,-1,4,5,7,-10                                                           22


       7,-1,4,5,7,-10,2                                                         22

       7,-1,4,5,7,-10,2,9                                                       23 (7,-1,4,5,7,-10,2,9)

       7,-1,4,5,7,-10,2,9,-10                                                   23

       7,-1,4,5,7,-10,2,9,-10,-5  (8)                                           23


       // Peeche se positive sum aa raha hain i.e 8. So, -9 khud kii family start karega toh sum = -9 hoga
       // Par agar peeche waali family main jaayega toh -1 banaayega i.e -9 peeche waali family main shaamil ho gaya.
       7,-1,4,5,7,-10,2,9,-10,-5,-9 (-1)


       // 6 peeche waali family main shaamil hoga toh 5 banaayega par khud kii family suru karega toh 6 banaayega.
       // i.e it will start it's own family.
       6                                                                        23

       6,1                                                                      23







 */

public class Kadens_Algorithm_Best_Explanation {

    public static void main(String[] args) {

        int arr[] = {4 ,  3 ,  -2 , 6 , -14 , 7 ,  -1 , 4 , 5 , 7 , -10 , 2 , 9 , -10 , -5 , -9 , 6};

        int ans = Kaden(arr);

        System.out.println(ans);
    }

    public static int Kaden(int arr[]){

        int curr_sum = arr[0];
        int overall_sum = arr[0];

        for(int i = 1 ; i < arr.length ; i++){

            // Agar peeche se sum positive aa raha hain toh woh ussi main saamil ho leta hain
            if(curr_sum >= 0){

                curr_sum += arr[i];

            }else {

                // Agar peeche se sum negative aa raha hain toh train hamii se suru hogyi.
                curr_sum = arr[i];
            }

            overall_sum = Math.max(curr_sum , overall_sum);
        }

        return overall_sum;
    }

}
