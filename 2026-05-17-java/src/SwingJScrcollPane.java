import javax.swing.*;
import java.awt.*;

public class SwingJScrcollPane {
    public static void main(String[] args){
        //jscrollpane是一个带有滚动条的面板
        //先添加窗口
        JFrame jf=new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        //放置面板,可以放置多个，面板里面可以放组件(按钮)
        JPanel jp=new JPanel(new FlowLayout()); //流式布局
        //创建组件add进面板里
        JButton jb1=new JButton("王者");
        JButton jb2=new JButton("荣耀");
        jp.add(jb1);
        jp.add(jb2);
        //创建jscrollpane(只能有一个)
        JScrollPane js =new JScrollPane(jp);
        jf.add(js);

    }
}
