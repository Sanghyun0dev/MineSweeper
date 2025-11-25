import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Flag_btn extends JButton implements ActionListener{
    Board board;
    Frame frame;

    public Flag_btn(Board b, Frame f){
        this.board = b;
        this.frame = f;
        setPreferredSize(new Dimension(24, 24));
        setIcon(new ImageIcon("src/images/flag.png"));

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        board.tool=0;
        frame.select();
    }

    public void changeColor(Color c){
        setBackground(c);
    }
}
