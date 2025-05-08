package BackTracking;
/*Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells. */
public class SudokoSolver {
    public static boolean solve(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isValid(board,row,col,num)){
                            board[row][col]=num;
                            if(solve(board)) return true;
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;
            if(board[i][col]==num) return false;
            int boxRow = 3*(row/3)+i/3;
            int boxCol = 3*(col/3)+i%3;
            if(board[boxRow][boxCol]==num) return false;
        }
        return true;
    }
    public static void solveSudoko(char[][] board){
        solve(board);
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoko(board);
        printBoard(board);
    }
}
