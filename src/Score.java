import javax.swing.*;
import java.awt.*;

public class Score extends JLabel {
    private Frame frame;
    private int score;

    public Score(Frame f) {
        this.frame = f;
        this.score = 20;
        setLocation(30,20);
        setBounds(30,20,24,24);
        setText(""+score);
    }

    public void findOne(){
        this.score--;
        setText(""+score);
        if (this.score == 0){
            frame.gameClear();
        }
    }
}