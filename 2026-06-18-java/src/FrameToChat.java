import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class FrameToChat extends JFrame {
    private JTextField jtf;     // 输入框  写成成员变量可以在整个类中使用
    private JTextArea jta;      // 显示框  如果直接new一个对象,那么这个对象只能使用一次
    private JButton jb;         // 发送按钮
    private String name;        // 私有化用户名,则外部不可随意修改
    private BufferedWriter writer;  // 创建一个缓冲字符输出流对象
    private BufferedReader reader;  // 创建一个缓冲字符输入流对象 可以重复使用
    private Socket socket;      // 创建一个Socket对象
    // 在构造方法中写入总体的布局
    public FrameToChat(String name) {
        this.name = name;
        //将设置窗体抽取成方法,使得构造方法更加简洁
        setFrame(); // 调用自己写的方法对窗体进行各种设置
        connectToServer();  // 连接服务器
        startReceiveThread();   // 开启接收线程
    }

    private void setFrame() {
        //对窗体进行设计
        setTitle("欢迎使用计科251黄奕涵32409100017聊天室应用");
        setSize(400, 400);
        setLocationRelativeTo(null);    // 居中显示
        setResizable(false);            // 禁止改变窗体大小
        setLayout(new BorderLayout());  // 设置窗体的布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭模式
        //对文本域进行设计
        jta = new JTextArea();
        jta.setEditable(false);         // 设置文本域不可编辑
        jta.setFont(new Font("微软雅黑", Font.PLAIN, 16));  // 设置字体
        JScrollPane jsp = new JScrollPane(jta);   // 添加滚动条来显示聊天记录
        //对输入框进行设计
        jtf = new JTextField();
        jtf.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        //对发送按钮进行设计
        jb = new JButton("发送");
        jb.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        //添加面板加入组件
        JPanel jp = new JPanel(new BorderLayout(10, 10));  // 设置面板的布局和间隔
        // 设置面板的边框,给周围留白
        jp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jp.add(jtf, BorderLayout.CENTER);    // 添加输入框
        jp.add(jb, BorderLayout.EAST);       // 添加发送按钮
        add(jsp, BorderLayout.CENTER);      // 添加文本域
        add(jp, BorderLayout.SOUTH);        // 添加面板
        //给发生按钮绑定事件(按按钮也可以发送,回车也可以发送)
        jb.addActionListener(e -> send());     //按按钮发送
        jtf.addActionListener(e -> send());    //按回车发送
    }

    private void send() {
        String msg = jtf.getText().trim(); // 获取输入框中的内容并去除空格
        try {
            writer.write(name + ": " + msg + "\n");
            writer.flush();
            appendMessage(name, msg);
            jtf.setText("");
        } catch (IOException e) {
            appendMessage("系统", "发送失败: " + e.getMessage());
        }
    }

    private void appendMessage(String sender, String message) {
        SwingUtilities.invokeLater(() -> {
            jta.append("[" + sender + "] " + message + "\n");
            jta.setCaretPosition(jta.getDocument().getLength());
        });
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 10012);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            appendMessage("系统", "已连接到服务器");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "无法连接到服务器: " + e.getMessage(),
                    "错误", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void startReceiveThread() {
        Thread receiveThread = new Thread(() -> {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    appendMessage("收到", message);
                }
            } catch (IOException e) {
                appendMessage("系统", "与服务器断开连接");
            }
        });
        receiveThread.setDaemon(true);
        receiveThread.start();
    }

}
