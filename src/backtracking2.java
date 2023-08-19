//n queens problem
public class backtracking2 {
    static int count=0;

    public static boolean isSafe(char board[][],int r,int c){
        //check vertically above
        for(int i=r-1; i>=0;i--){
            if(board[i][c]=='Q'){
                return false;
            }
        }

        //check left diagonally up
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //check right diagonally up
        for(int i=r-1,j=c+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][],int row){
        if(row==board.length){
            count++;
            printBoard(board);
            return;
        }

        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j]='.'; //backtracking
            }
        }
    }

    public static void printBoard(char board[][]){
        System.out.println("----chess board---");
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n=5;
        char board[][] = new char[n][n];

        //initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        nQueens(board,0);
        System.out.println("Total No of ways = " + count);
    }
}
