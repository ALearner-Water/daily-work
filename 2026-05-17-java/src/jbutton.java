import javax.swing.*;
import java.awt.*;

public class jbutton {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);

        jf.setLayout(new FlowLayout()); //使用流式布局
        //创建按钮
        JButton jb=new JButton("按钮");   //默认网格布局,按钮会很大需要改成流式布局
        jf.add(jb);
        //使用流式布局不需要手动设置按钮大小和位置,会与布局冲突不会生效
        jb.setEnabled(true);    //设置按钮是否可用
        jb.setBorderPainted(true);  //按钮边界是否可见


        //最后可见
        jf.setVisible(true);
    }

}
