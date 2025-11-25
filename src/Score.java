import javax.swing.*;
import java.awt.*;

public class Score extends JLabel {
    private Frame frame;
    private int score;

    public Score(Frame f) {
        this.frame = f;
        this.score = 0;
        setBounds(10, 20, 60, 24);
        setFont(new Font("Arial", Font.BOLD, 16));
        setText(""+score);
    }

    public void findOne(){
        this.score++;
        setText(""+score);
        if (this.score == 81){
            frame.gameClear();
        }
    }
}