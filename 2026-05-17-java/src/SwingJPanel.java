import javax.swing.*;
import java.awt.*;

public class SwingJPanel {
    public static void main(String[] args){
        //先添加窗口
        JFrame jf=new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        //创建组件add进面板里
        JButton jb1=new JButton("王者");
        JButton jb2=new JButton("荣耀");
        //放置面板,可以放置多个，面板里面可以放组件(按钮)
        JPanel jp=new JPanel(new FlowLayout()); //流式布局
        //jb1.setSize(200,200);不可以用setsize直接修改大小,因为有布局管理器的限制
        jp.add(jb1);
        jp.add(jb2);
        //将面板添加进窗口
        jf.add(jp);
    }
}
