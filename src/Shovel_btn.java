import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Shovel_btn extends JButton implements ActionListener {
    Board board;
    Frame frame;

    public Shovel_btn(Board b,  Frame f){
        this.board = b;
        this.frame = f;
        setBounds(182, 20, 24, 24);
        setIcon(new ImageIcon("src/images/shovel.png"));

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        board.tool=1;
        frame.select();
    }

    public void changeColor(Color c){
        setBackground(c);
    }
}
