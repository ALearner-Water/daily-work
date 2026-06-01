import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cauculator extends JFrame implements ActionListener {  //实现监听功能
    private JTextField jt = new JTextField(20);
    public Cauculator() {
        //设置窗体
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("计算器");
        this.setDefaultCloseOperation(3);
        //使用网格布局
        this.setLayout(new BorderLayout());
        //禁止调整窗口大小
        this.setResizable(false);
        //设置两个面板
        JPanel panel1 = new JPanel();   //计算器按钮面板
        JPanel panel2 = new JPanel();   //计算器文本框面板
        panel1.setLayout(new GridLayout(4, 4, 3, 3)); //设置成网格布局
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //设置面板边距
        //添加文本框
        jt.setPreferredSize(new Dimension(50, 30));  //设置文本框大小
        jt.setFont(new Font("Arial", Font.PLAIN, 16));  //设置文本框字体
        jt.setHorizontalAlignment(JTextField.RIGHT);    //使文本从右边开始输入
        jt.setEditable(false);  //设置成只能通过按钮输入
        panel2.add(jt);
        this.add(panel2, BorderLayout.NORTH);
        //添加按钮
        String buttonName[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (int i = 0; i < 16; i++) {
            JButton jb = new JButton(buttonName[i]);
            jb.setFont(new Font("Arial", Font.PLAIN, 20));
            jb.addActionListener(this); //添加监听器
            panel1.add(jb);
        }
        this.add(panel1, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();   //获取按钮名称
        jt.setText(buttonName);
    }
}
