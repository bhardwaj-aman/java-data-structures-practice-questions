package BackTracking;

import java.util.Stack;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
                /*{{0,0,1,0},
                        {4,0,0,0},{0,0,0,2},
                        {0,3,0,0}}*/;
        Stack<String> stack = new Stack<>();
        stack.push("a");
        System.out.println(stack.pop());
    }

    public static boolean Solve(int[][] board, int i, int j) {
     //   System.out.println("checking for: " + i + " ," + j);
        boolean solved = false;
        if (isFull(board)) {
            for (int a = 0; a < board.length; a++) {
                for (int b = 0; b < board.length; b++) {
                    System.out.print(board[a][b] + " ");
                }
                System.out.println("");
            }
            System.out.println(" ******");
            return true;
        }

        for (int a = i; a < board.length; a++) {
            for (int b = 0; b < board.length; b++) {
                if (board[a][b] == 0) {
                    for (int c = 1; c <= board.length; c++) {
                        if (isSafe(board, a, b, c)) {
                            board[a][b] = c;
                            //System.out.println(" for: "+c+" at "+a+" ," +b);
     boolean ans=                            Solve(board, a, b);

                          if (ans) {
                                solved = true;
                                break;
                            }
                            board[a][b] = 0;
                        }
                    }
                   if (solved) {
                        return true;
                    }
                }
                if (solved) {
                   return true;
                }

            }
            if (solved) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFull(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int[][] board, int i, int j, int n) {
        for (int x = 0; x < board.length; x++) {
            if (board[x][j] == n ) {
                return false;
            }
        }
        for (int x = 0; x < board.length; x++) {
            if (board[i][x] == n ) {
                return false;
            }
        }
        int l = 0;
        int r = 0;
        int t = 0;
        int b = 0;
        int x = (int) Math.sqrt(board.length);
      int y=1;
      while (true){
          if((x*y)>j){
              break;
          }
          y++;
      }
      l=x*(y-1);
      r=x*y;
         y=1;
        while (true){
            if(x*y>i){
                break;
            }
            y++;
        }
        t=x*(y-1);
        b=x*y;
       // System.out.println("for: "+i+","+j);
        //System.out.println(" range is: h-"+l+" to "+r);
        //System.out.println(" v: "+t+" to"+b);
        for (int a = t; a < b; a++) {
            for (int c = l; c < r; c++) {
                if (board[a][c] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
