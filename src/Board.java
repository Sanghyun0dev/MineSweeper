import java.util.*;

public class Board {
    private int[][] board = new int[9][9];
    public int[][] cnts = new int[9][9];
    public int tool = 0; //0: flag, 1: shovel

    public Board() {
        Random rand = new Random();
        int i = 20;
        while (i != 0) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] == 0) {
                board[row][col] = 1;
                i--;
            }
        }
        for (i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 1) cnts[i][j] = -1;
                else {
                    cnts[i][j] = getValue(i - 1, j - 1) + getValue(i - 1, j) + getValue(i - 1, j + 1)
                            + getValue(i, j - 1) + getValue(i, j + 1)
                            + getValue(i + 1, j - 1) + getValue(i + 1, j) + getValue(i + 1, j + 1);
                }
            }
        }
    }

    int getValue(int r, int c) {
        if (r < 0 || r >= 9 || c < 0 || c >= 9) return 0;
        else return board[r][c];
    }
}