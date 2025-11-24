import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cell extends JButton implements ActionListener {
    private Board board;
    private Frame frame;
    private int number;

    public Cell(Board b, Frame f, int n) {
        this.board = b;
        this.frame = f;
        this.number = n;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (board.tool==0){ //flag

        }
        else { //shovel

        }
    }
}
