import javax.swing.*;
import java.awt.*;

public class Painting extends JFrame {


    public Painting() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("画板");
        this.setLocationRelativeTo( null);
        this.setLayout(null);

    }
    @Override
    public void paint(Graphics g)  {
        super.paint(g);
        Graphics2D g1= (Graphics2D) g;  //创建画笔
        g1.setStroke(new BasicStroke(5));   //调整画笔粗细
        g1.setColor(Color.red);
        g1.drawOval(250,100,100,100);
        g1.setColor(Color.blue);
        g1.drawOval(50,100,100,100);
        g1.setColor(Color.green);
        g1.drawOval(200,150,100,100);
        g1.setColor(Color.yellow);
        g1.drawOval(100,150,100,100);
        g1.setColor(Color.black);
        g1.drawOval(150,100,100,100);

    }
}
