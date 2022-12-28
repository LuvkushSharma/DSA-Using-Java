package Recursion_and_Backtracking_5;

public class Word_Search_in_8_directn {

    public static void main(String[] args) {

        char maze[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // String word = "ABCCED";
        String word = "CEPC";

        for (int i = 0; i < maze.length ; i++){
            for (int j = 0; j < maze[0].length ; j++){

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

        if(curr_col < 0 || curr_col >= maze[0].length || curr_row < 0 || curr_row >= maze.length ||
                maze[curr_row][curr_col] != word.charAt(idx)){

            return false;
        }

        /*

        Searching in 8 direction means diagonally also

       Along this diagonal        and        Along this diagonal

                    1            2
                     \          /
                       \      /
                         \  /
                         / \
                       /     \
                     /         \
                    4           3

             These 4 numbers shows 4 more directions

         i.e : row - 1                           row - 1
               col - 1                           col + 1

               row + 1                           row + 1
               col - 1                           col + 1



               row

         */

        // These two arrays shows the 8 direction
        int row[] = {0 , -1 , 0 , 1 , -1 , 1 , 1 , -1};
        int col[] = {1 , 0 , -1 , 0 , 1 , 1 , -1 , -1};

        // If char in maze matches in the given word then mark this char as Visited.
        maze[curr_row][curr_col] = '*';

        for (int i = 0; i < col.length ; i++){

            boolean ans = FindWord(maze , curr_row + row[i] , curr_col + col[i] , word , idx + 1);

            if (ans == true){

                return ans;
            }
        }
        // UNDO : Backtrack
        // Again marking the char as Unvisited for further possibilities.
        maze [curr_row][curr_col] = word.charAt(idx);

        // Andarr se word nhi milla iska matlab word nhi mila
        return false;
    }
}
