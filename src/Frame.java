import javax.swing.*;

public class Frame extends JFrame {
    private Board board;
    private Cell[][] cells = new Cell[9][9];
    private int SIZE = 20;

    public Frame(Board board) {
        this.board = board;
        JFrame f = this;

        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setTitle("Mine Sweeper");
        f.setSize(SIZE*9+10, SIZE*9+10);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //cells
        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                cells[r][c] = new Cell(board,this,r*10+c);
                f.add(cells[r][c]);
            }
        }

        //remain mine

        //flag btn

        //shovel btn

        f.setVisible(true);
    }


}
