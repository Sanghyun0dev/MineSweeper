import java.util.*;

public class Board {
    private int[][] board = new int[9][9];
    public int tool = 0; //0: flag, 1: shovel

    public Board() {
        Random rand = new Random();
        int i=20;
        while (i!=0){
            int row=rand.nextInt(9);
            int col=rand.nextInt(9);
            if (board[row][col]==0){
                board[row][col]=1;
                i--;
            }
        }
    }

    int getValue(int r, int c) {
        if (board[r][c]==1) return -1;
        return board[r-1][c-1]+board[r-1][c+1]+board[r-1][c]
                +board[r][c-1]+board[r][c+1]
                +board[r+1][c-1]+board[r+1][c]+board[r+1][c+1];
    }
}