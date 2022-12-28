package Lecture_4;

public class Maze_Path {

    public static void main(String[] args) {

        int row = 3;
        int col = 3;

        PrintPath(row-1 , col-1 , 0 , 0 , "");
    }

    public static void PrintPath(int end_row , int end_col , int curr_row ,
                                 int curr_col , String ans){

        // Base case-1
        if (curr_row == end_row && curr_col == end_col){

            System.out.println(ans);
            return;
        }

          // Base case-2
         if(curr_row > end_row || curr_col > end_col){

             return;
         }



        // Recursive call for moving horizontal
        // In that case we are changing col i.e moving forward in a row i.e
        // increament the current column
        PrintPath(end_row , end_col , curr_row , curr_col+1,ans+"H");

        // Recursive call for moving vertical
        // In that case we are changing row i.e moving downward in a column i.e
        // increament the current row
        PrintPath(end_row , end_col , curr_row+1 , curr_col,ans+"V");
    }
}
