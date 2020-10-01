import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class main {



    public static void main(String[] args) {

        new TaskFrame().setVisible(true);

    }



}

class TaskFrame extends JFrame

{

    int width = 800;
    int height = 800;
    int btnSize = 50;
    int score = 0;
    JLabel result = new JLabel("Score: 0");
    JButton btn1 = new JButton();



    String filePath = "";

    public TaskFrame()

    {
        setLayout(null);
        btn1.setBounds(100,100,100,100);
        btn1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {
                        btn1.setBounds((int)(Math.random()*(width-btnSize)),(int)(Math.random()*(height-btnSize)),btnSize,btnSize);
                        score ++;
                        result.setText("Score: " + score);
                        int r,g,b;
                        r = (int)(Math.random()*255);
                        g = (int)(Math.random()*255);
                        b = (int)(Math.random()*255);
                        btn1.setBackground(new Color(r,g,b));
                        getContentPane().setBackground(new Color((g+50)%255,(b+50)%255,(r+50)%255));
                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

                    }
                }
        );
        result.setBounds(0,0,100,20);
        add(btn1);
        add(result);
        setSize(width,height);
    }

}