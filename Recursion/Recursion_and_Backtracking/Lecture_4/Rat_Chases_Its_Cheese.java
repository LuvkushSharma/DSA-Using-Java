package Recursion_and_Backtracking_4;

/*

You are given an N*M grid. Each cell (i,j) in the grid is either blocked , or empty.
The rat can move from a position towards left, right, up or down on the grid.
Initially rat is on the position (1,1). It wants to reach position (N,M) where it's cheese is waiting
for. There exists a unique path in the grid. Find that path and help the rat reach its cheese.

Input Format

First line contains 2 integers N and M denoting the rows and columns in the grid.
Next N line contains M characters each. An 'X' in position (i,j) denotes that the cell
is blocked and ans 'O' denotes that the cell is empty.

Constraints

1 <= N , M <= 10

Output Format

Print N lines, containing M integers each. A 1 at a position (i,j) denotes that the
(i,j)th cell is covered in the path and a O denotes that the cell is not covered in the path.
If a path does not exists then print "NO PATH FOUND"

Sample Input

  5  4
  OXOO
  OOOX
  XOXO
  XOOX
  XXOO

Sample Output

   1  0  0  0
   1  1  0  0
   0  1  0  0
   0  1  1  0
   0  0  1  1


 */

import java.util.Scanner;

public class Rat_Chases_Its_Cheese {

    static boolean f = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- Input taking ---------
        int n = sc.nextInt();
        int m = sc.nextInt();

        char maze[][] = new char[n][m];

        for (int i = 0; i < maze.length; i++){

            String s = sc.next();
            for (int j = 0 ; j < s.length() ; j++){

                maze[i][j] = s.charAt(j);

            }

        }


        int ans[][] = new int[n][m];

        PrintPath1(maze , 0 , 0 , ans);

        if(f == false){
            System.out.println("NO PATH FOUND");
        }


    }

    // M-1
    // Not writing multiple recursive calls
    public static void PrintPath1(char maze[][] , int curr_row , int curr_col , int ans[][]){

        // Base case
        if(curr_col == maze[0].length-1 && curr_row == maze.length - 1){

            // Last waale cell par 1 daalengye
            // becoz rercursion last cell main 1 daalne se pehle print kara hain aur return kar raha hain.
            if (maze[curr_row][curr_col] == 'O') {
                f = true;
                ans[curr_row][curr_col] = 1;
                Display(ans);
                ans[curr_row][curr_col] = 0;
            }
              return;
        }

        // Agar ye edge cases pass ho rahe hain tabhi recursive call lagegyi else nhi
        // Patah chale up jaate jaate ham row ke index se bahaar chale jaaye i.e row kaa
        // upar waala last index 0 hain i.e -1 hote hee return ho jaayengye ham.
        // Similarly , column main right and left boundary cross ho rahi hain toh return karo.

        // And , agar hame X mil jaaye toh hame return karna hoga i.e uss path par nhi jaana
        if(curr_col < 0 || curr_col >= maze[0].length  || curr_row < 0 || curr_row >= maze.length ||
                maze[curr_row][curr_col] == 'X'){

            return;
        }

        // row[0] and col[0] is used for moving rat in right direction.
        // row[1] and col[1] is used for moving rat in upward direction.
        // row[2] and col[2] is used for moving rat in left direction.
        // row[3] and col[3] is used for moving rat in downward direction.

        /*


    0 -->    0    X    0    0
    1 -->    0    0    0    X
    2 -->    X    0    X    0
    3 -->    X    X    0    X
    4 -->    X    X    0    0

        Let's say ham (1,0) cell visit karke (1,1) cell par gaye waha par O thaa
        isliye rat waha par jaa sakta hain.
        Now, rat jab (1,1) par hoga tab uske paas 4 directions hogyi (1,0) <- left
        (0,1) <- up , (1,2) <- right and (2,1) <- down

        Abb rat agar left jaayega toh uskaa koi matlab nhi hoga i.e (1,0) as
        rat wahi se aya thaa. It means hame (1,0) waale ko visited marked karna
        hoga aur woh ham 'X' se kar saskte hain it means rat abb left main nahi jaa sakta.

        That, is why we have written the below lines in our code.

        maze[curr_row][curr_col] = 'X';

        Aur hame woh index ko ans main 1 mark karna hoga isliye

        ans[curr_row][curr_col] = 1;


        Now, Jab ham ussi function frame main ho toh hame changes nhi chaiye
        i.e Backtracking.

        maze[curr_row][curr_col] = 'O';
        ans[curr_row][curr_col] = 0;

         */

        int row[] = {0 , -1 , 0 , 1};
        int col[] = {1 , 0 , -1 , 0};

        // Marking cell as visited by giving 'X' as its value
        maze[curr_row][curr_col] = 'X';
        ans[curr_row][curr_col] = 1;

        for (int i = 0 ; i < col.length ; i++){

            PrintPath1(maze , curr_row + row[i] , curr_col + col[i] , ans);
        }

        // UNDO : Backtrack
        // Agar saare path print karaane hhongye toh backtrack jarurat hogyi.
        maze[curr_row][curr_col] = 'O';
        ans[curr_row][curr_col] = 0;


    }

    public static void Display(int ans[][]){

        System.out.println("Hello");

        // Printing the solution

        for (int i = 0; i < ans.length ; i++){

            for (int j = 0; j < ans[0].length ; j++){

                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }






    // M-2
    // Not using for loop : i.e we have to call 4 recursive functions
    public static void PrintPath2(char maze[][] , int curr_col , int curr_row , int ans[][]){

        if(curr_col < 0 || curr_col >= maze[0].length  || curr_row < 0 || curr_row >= maze.length ||
                maze[curr_row][curr_col] == 'X'){

            return;
        }


        PrintPath2(maze , curr_row , curr_col + 1 , ans); // right
        PrintPath2(maze , curr_row - 1, curr_col, ans); // up
        PrintPath2(maze , curr_row , curr_col - 1 , ans); // left
        PrintPath2(maze , curr_row + 1 , curr_col, ans); // down



    }

}
