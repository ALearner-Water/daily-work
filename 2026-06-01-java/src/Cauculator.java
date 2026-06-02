import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cauculator extends JFrame implements ActionListener {  //实现监听功能
    //定义计算需要使用的变量
    private String FirstNum = "";   //当前输入的数字
    private String LastNum = "";    //记录第二个数字
    private String Operator = "";   //记录运算符
    private boolean startNumber = true;   //是否开始输入新数字
    private double result = 0;
    private JTextField jt = new JTextField(20);

    public Cauculator() {
        //设置窗体
        this.setSize(350, 300);
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
        jt.setFont(new Font("粗体", Font.PLAIN, 18));  //设置文本框字体
        jt.setText("0");
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

        //遇到数字或者小数点的时候
        if (buttonName.matches("[0-9.]")) {
            if (startNumber == true) {  //输入新数字
                FirstNum = buttonName;
                startNumber = false;    //等下面重置才重新输入下一个数字
            } else {
                if (buttonName.equals(".") && FirstNum.contains(".")) { //不能输入多个小数点
                    return;
                }
                FirstNum += buttonName;
            }
            //将运算符和数字都显示在文本框内
            if (!Operator.isEmpty()) {
                jt.setText(LastNum + Operator + FirstNum);
            } else {
                jt.setText(FirstNum);
            }
        } else if (buttonName.equals("+") || buttonName.equals("-") || buttonName.equals("*") || buttonName.equals("/")) {
            //做到能连续运算
            if (!Operator.isEmpty() && !FirstNum.isEmpty() && !LastNum.isEmpty()) {
                result = Cauculate();
                LastNum = String.valueOf(result);
            } else {
                LastNum = FirstNum;
            }
            Operator = buttonName;
            jt.setText(LastNum + Operator);
            startNumber = true;   //开始输入新数字
        } else if (buttonName.equals("=")) {
            double cauculate = Cauculate();
            jt.setText(String.valueOf(cauculate));
            Operator = "";
            LastNum = "";
            startNumber = true;
        }
    }

    public double Cauculate() {
        double defult = 0;
        Double num1 = Double.parseDouble(LastNum);
        Double num2 = Double.parseDouble(FirstNum);
        switch (Operator) {
            case "+" -> defult = num1 + num2;
            case "-" -> defult = num1 - num2;
            case "*" -> defult = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    jt.setText("除数不能为0");
                    return 0;
                }
                defult = num1 / num2;
            }
        }
        return defult;
    }
}
