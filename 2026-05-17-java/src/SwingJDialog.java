import javax.swing.*;
import java.awt.*;

public class SwingJDialog {
    public static void main(String[] args){
        //先创建窗体然后才有对话框
        JFrame game = new JFrame("游戏");
        game.setSize(603, 602);
        game.setLocationRelativeTo(null);
        //设置窗体关闭方式
        game.setDefaultCloseOperation(3);
        game.setVisible(true);  //可视化

        //初始化对话框
        JDialog jd=new JDialog(game,"提示");
        jd.setSize(300,300);    //设置对话框大小
        jd.setLocationRelativeTo(null);     //让对话框居中
        jd.setDefaultCloseOperation(1); //设置对话框关闭方式
        //在对话框中添加内容
        JLabel label=new JLabel("游戏结束",JLabel.CENTER);    //先创建标签使其居中
        label.setFont(new Font("微软雅黑",Font.BOLD,20));   //设置字体大小和样式
        jd.add(label);  //添加标签
        jd.setVisible(true);    //可视化
    }
}
