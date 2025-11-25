import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cell extends JButton implements ActionListener {
    private Board board;
    private Frame frame;
    private int number; //cell id
    private boolean is_open = false;
    private boolean is_flag = false;

    public Cell(Board b, Frame f, int n) {
        board = b;
        frame = f;
        number = n;

        int r=number/10, c=number%10;
        setBounds(r*24+10, c*24+64, 24, 24);

        setMargin(new Insets(0, 0, 0, 0));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFont(getFont().deriveFont(Font.BOLD, 12f));

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (!is_open) {
            if (board.tool == 0) { //flag
                if (!is_flag) {
                    set_flag();
                } else {
                    unset_flag();
                }
            }
            else { //shovel
                dig();
            }
        }
    }

    public void set_flag(){
        setIcon(new ImageIcon("src/images/flag.png"));
        is_flag = true;
    }

    public void unset_flag(){
        setIcon(null);
        is_flag = false;
    }

    public void dig(){
        if (is_flag) {
            unset_flag();
        }
        int cnt = board.getValue(number);
        if (cnt==-1){
            setIcon(new ImageIcon("src/images/bomb.png"));
            frame.gameOver();
        }
        else {
            setText(""+cnt);
            frame.find();
        }
        is_open = true;
    }
}
