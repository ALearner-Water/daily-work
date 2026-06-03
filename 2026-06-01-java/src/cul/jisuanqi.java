package cul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jisuanqi extends JFrame implements ActionListener {
    private JTextField jt;
    public jisuanqi() {
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("计算器");
        //设置对话框
        JPanel jp = new JPanel();
        jt=new JTextField(15);
        jt.setPreferredSize(new Dimension(100, 30));
        jt.setFont(new Font("粗体", Font.BOLD, 18));
        jt.setHorizontalAlignment(JTextField.RIGHT);
        jt.setEditable(false);
        jp.add(jt);
        this.add(jp, BorderLayout.NORTH);
        //设置按钮
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(4, 4,5,5));
        jp1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        String figure[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (int i = 0; i < 16; i++) {
            JButton jb = new JButton(figure[i]);
            jb.setFont(new Font("粗体", Font.BOLD, 20));
            jp1.add(jb);
            jb.addActionListener(this); //靠窗口监听
        }
        this.add(jp1, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonname=e.getActionCommand();
        jt.setText(jt.getText()+buttonname);
    }
}
