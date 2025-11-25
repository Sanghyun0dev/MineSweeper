import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cell extends JButton implements ActionListener {
    private Board board;
    private Frame frame;
    private int number; //cell id
    private boolean is_open = false;

    public Cell(Board b, Frame f, int n) {
        this.board = b;
        this.frame = f;
        this.number = n;
        addActionListener(this);

        int r=number/10, c=number%10;
        setBounds(r*24+10, c*24+40, 30, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (board.tool==0){ //flag
            if (!this.is_open){
                set_flag();
            }
            else {
                unset_flag();
            }
        }
        else { //shovel
            dig();
        }
    }

    public void set_flag(){
        this.setIcon(new ImageIcon("src/images/flag.png"));
    }

    public void unset_flag(){
        this.setIcon(null);
    }

    public void dig(){
        this.is_open = true;
        int cnt = board.getValue(this.number);
        if (cnt==-1){
            this.setIcon(new ImageIcon("src/images/bomb.png"));
            frame.gameOver();
        }
        else {
            this.setText(""+cnt);
            frame.find();
        }
    }
}
