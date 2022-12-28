package Recursion_and_Backtracking_5;

public class Word_Search {

    public static void main(String[] args) {

        char maze[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // String word = "ABCCED";
        String word = "CEPC";

        for (int i = 0; i < maze.length ; i++){
            for (int j = 0; j < maze[0].length ; j++){

                // maze kaa ith aur jth character agar word ke char se match kar raha
                // toh recursive call lagao.

                /*

                K  L  M  A  L  S
                E  R  T  Z  L  Q
                P  X  V  D  G  M
                U  R  S  A  H  J

                Word  = "ALL"

                Isme agar main K se suru karu toh uska koi matlab hee nhi hain as
                K word main hain hee nhi toh uske left yaa fir right main dhudungaa
                toh koi matlab nhi hoga.
                Isliye ham pehle word ke character match karengye agar woh given maze
                main kisi bhi index par pade char se match karta hai toh hee main recursive
                call karunga else agli iteration par jao.

                Iss example main (0,3) index par jab iteration hogyi tab recursive call hoga.

                 */

                if(maze[i][j] == word.charAt(0)){

                    // Woh index bhejo jaha par word kaa 0th character match kar raha hain.
                    boolean ans = FindWord(maze , i , j, word, 0);

                    if (ans == true){

                        System.out.println(ans);
                        return;
                    }

                }

            }
        }

        System.out.println(false);
    }

    public static boolean FindWord(char maze[][] , int curr_row , int curr_col , String word , int idx){

        // Base case

        // It means hame saare characters mill gaye word ke.
        if (idx == word.length()){
            return true;
        }


        // Maze kii boundary cross ho rahi hain toh return kardo simply.
        // Aur character ---> given word main nhi hain toh return kardo aagye bhadne kii
        // requirement nhi hain.
        //  maze[curr_row][curr_col] != word.charAt(idx) <----
        // means , curr character word main jo idx index main hain woh maze main curr row
        // aur curr col se match nhi kar raha toh bhi return kardo.
        if(curr_col < 0 || curr_col >= maze[0].length || curr_row < 0 || curr_row >= maze.length ||
        maze[curr_row][curr_col] != word.charAt(idx)){

            return false;
        }

        // We have to move in 4 direction i.e using row and col array that helps
        // us to move in the maze in the four direction.
        // Jab tak woh specific nhi bole kii iss particular direction main jaana hain
        // tab tak ham row aur col waali array main pehle right fir left yaa fir pehle down ,... kar sakte hain

        int row[] = {0 , -1 , 0 , 1};
        int col[] = {1 , 0 , -1 , 0};

        /*

               K  L  M  A  L  S
               E  R  T  Z  L  Q
               P  X  V  D  G  M
               U  R  S  A  H  J

               Word = "MAM"

               Maan lo maine M mil gaya row = 0 main fir main right move kiya
               toh mujhe A mil gaya. Fir jab main A se M serach karunga toh woh peeche
               waale i.e left main jo M hain ussi ko le lega but woh toh visited hain.
               Aur hame unique characters lene hain ek hee character baar baar nhi use karna
               Hence ham jo pehle character ko visit karke aaye hain usse kuch aisa char
               dedo jisse A baapis left nhi jaa paaye.

               Isliye ham '*' kaa use kar rahe hain

               Par hamne iss frame main change kiya hain toh hame backtrack bhi karna hoga.
               As jab hame A se dusra M nhi mila toh ham return karengye aur first M
               i.e A kaa left waale M par aayengye. Aur hamne uss M ko * se replace kar diya thaa
               par main chahta huun kii jab main First M par jau toh fir main aur direction
               main A check karu par main ye nhi kar paunga as uss frame main * ho chuka hain M
               isliye main jab A se M par return karu toh woh waapis M ban jaaye.
               And this is done by backtrack.

         */
        maze[curr_row][curr_col] = '*';

        for (int i = 0; i < col.length ; i++){

            // Word main agar idx index waala character maze main mil gaya toh
            // abb bache chars check karne ke liye (idx + 1) kiya.
           boolean ans = FindWord(maze , curr_row + row[i] , curr_col + col[i] , word , idx + 1);

           // If we got the required word in the maze then aagye call lagaane kii jarurat nhi hain.
           if (ans == true){

               return ans;
           }
        }
        // UNDO : Backtrack
        maze [curr_row][curr_col] = word.charAt(idx);

        // Andarr se word nhi milla iska matlab word nhi mila
        return false;
    }
}
