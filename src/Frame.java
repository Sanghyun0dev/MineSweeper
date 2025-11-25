import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private Board board;
    private Cell[][] cells = new Cell[9][9];
    private Score score;
    private Flag_btn flag;
    private Shovel_btn shovel;

    public Frame(Board board) {
        this.board = board;
        JFrame f = this;

        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setTitle("Mine Sweeper");
        f.setSize(24*9+20, 24*9+74);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                cells[r][c] = new Cell(board,this,r*10+c);
                f.add(cells[r][c]);
            }
        }
        score = new Score(this);
        f.add(score);
        flag = new Flag_btn(board,this);
        f.add(flag);
        shovel = new Shovel_btn(board,this);
        f.add(shovel);

        f.setVisible(true);
    }

    public void find(){
        score.findOne();
    }

    public void select(){
        if (board.tool==0){ //flag
            flag.changeColor(Color.GRAY);
            shovel.changeColor(Color.WHITE);
        }
        else { //shovel
            flag.changeColor(Color.WHITE);
            shovel.changeColor(Color.GRAY);
        }
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(null, "Game Over");
    }

    public void gameClear(){
        JOptionPane.showMessageDialog(null, "Game Clear!");
    }
}
