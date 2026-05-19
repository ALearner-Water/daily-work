import javax.swing.*;
import java.awt.*;

public class buttonchoose1 {
    public static void main(String[] args){
        JFrame jf=new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(new FlowLayout()); //需要设成流式布局不然按钮会重合
        //单选按钮,需要把他们放到一个按钮组里
        JRadioButton jb1=new JRadioButton("我");
        JRadioButton jb2=new JRadioButton("你");
        JRadioButton jb3=new JRadioButton("他");
        //创建按钮组
        ButtonGroup bg=new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);
        bg.add(jb3);        //只是声明这些按钮是互斥的还需要把按钮添加进窗口
        //添加进窗体
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        //最后可见
        jf.setVisible(true);

    }
}
