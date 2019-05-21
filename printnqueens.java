package RECURSION;

public class printnqueens {
    public static void main(String[] args){
        int[][] board = new int[4][4];
        printnqueens(board,0);
    }
    public static void printnqueens(int [][]board, int row){
        if (row==board.length){

            for (int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                   if (board[i][j]==1){
                       System.out.print ("{"+i+","+j+"} ");
                   }
                }
            }
            System.out.println(" ");
            return ;
        }
        for(int col=0;col<board[row].length;col++){

            if (isItSafe(board,row,col)){
                //System.out.println("isItSafe(board,row,col)");
                board[row][col]=1;

                 printnqueens(board,row+1);
                board[row][col]=0;
            }
        }

    }
    private static boolean isItSafe(int[][] b, int r, int c){
        for(int i=r;i>=0;i--){
            if(b[i][c]==1){
                return false;
            }
        }
        for(int i=r,j=c;i>=0&&j>=0;i--,j--){
            if (b[i][j]==1){
                return false;
            }

        }
        for(int i=r,j=c;i>=0&&j<b.length;i--,j++){

            if (b[i][j]==1){
                return false;
            }

        }
        return true;
    }
}
