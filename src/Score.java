import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    private Frame frame;
    private int score;

    public Score(Frame f, int score) {
        this.frame = f;
        this.score = score;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(10, 10, 30, 10);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 10);
    }

    public int getScore() {
        return score;
    }

    public void findOne(){
        this.score--;
        this.set
        if (this.score == 0){
            frame.gameClear();
        }
    }
}