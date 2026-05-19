import javax.swing.*;
import java.awt.*;

public class jcombobox {
    public static void main(String[] args){
        JFrame jf=new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        //创建下拉框
        JComboBox jc=new JComboBox();
        jc.addItem("java");
        jc.addItem("python");
        jc.addItem("c++");
        jf.add(jc);
        jf.setVisible(true);
    }
}
