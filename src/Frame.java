import javax.swing.*;

public class Frame extends JFrame {
    private Board board;
    private Cell[][] cells;
    private Score score;
    private Flag_btn flag;
    private Shovel_btn shovel;

    public Frame(Board board) {
        this.board = board;
        JFrame f = this;

        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setTitle("Mine Sweeper");
        f.setSize(24*9+20, 24*9+50);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                cells[r][c] = new Cell(board,this,r*10+c);
                f.add(cells[r][c]);
            }
        }
        score = new Score(this,0);
        f.add(score);
        flag = new Flag_btn(board);
        f.add(flag);
        shovel = new Shovel_btn(board);
        f.add(shovel);

        f.setVisible(true);
    }

    void gameOver() {
        JOptionPane.showMessageDialog(null, "Game Over");

    }

    void gameClear(){
        JOptionPane.showMessageDialog(null, "Game Clear!");

    }
}
