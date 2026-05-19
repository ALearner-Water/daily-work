import javax.swing.*;
import java.awt.*;

public class buttonchoosedouble {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(new FlowLayout());
        //可以设置复选按钮使用jcheckbox()  不需要添加按钮组buttongroup
        JCheckBox jb1=new JCheckBox("java");
        JCheckBox jb2=new JCheckBox("python");
        JCheckBox jb3=new JCheckBox("c++");
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.setVisible(true);
    }
}
