import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private Board board;
    public Cell[][] cells = new Cell[9][9];
    private Score score;
    private Flag_btn flag;
    private Shovel_btn shovel;

    public Frame(Board board) {
        this.board = board;

        setTitle("Mine Sweeper");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        score = new Score(this);
        topPanel.add(score);
        flag = new Flag_btn(board,this);
        topPanel.add(flag);
        shovel = new Shovel_btn(board,this);
        topPanel.add(shovel);
        add(topPanel, BorderLayout.NORTH);

        JPanel borderPanel = new JPanel(new GridLayout(9,9));
        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                cells[r][c] = new Cell(board,this,r*10+c);
                borderPanel.add(cells[r][c]);
            }
        }
        add(borderPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
        JOptionPane.showMessageDialog(this, "Game Over");
    }

    public void gameClear(){
        JOptionPane.showMessageDialog(this, "Game Clear!");
    }
}
