import javax.swing.*;
import java.awt.*;

public class jlabel {
    static void main() {
        JFrame jf=new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        //创建标签
        JLabel label=new JLabel("欢迎来到王者荣耀", JLabel.CENTER); //居中放置文本
        label.setFont(new Font("微软雅黑",Font.BOLD,20));   //调整字体大小和样式
        jf.add(label);  //添加标签
    }
}
