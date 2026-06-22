package Exercise.work5;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;

public class ChatClient extends JFrame {
    private JTextPane chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    private boolean connected = false;
    private String nickname;
    private StyledDocument document;

    public ChatClient() {
        this.nickname = promptForNickname();
        initUI();
        connectToServer();
    }

    private String promptForNickname() {
        String name = JOptionPane.showInputDialog(
            null,
            "请输入您的昵称：",
            "设置昵称",
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (name == null || name.trim().isEmpty()) {
            return "匿名用户";
        }
        return name.trim();
    }

    private void initUI() {
        setTitle("欢迎使用 软件171 XXX 1234 聊天室应用 - " + nickname);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeConnection();
                System.exit(0);
            }
        });

        chatArea = new JTextPane();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        document = (StyledDocument) chatArea.getDocument();
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        inputField = new JTextField();
        inputField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        sendButton = new JButton("发送");
        sendButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 8888);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            connected = true;

            writer.println(nickname);
            
            appendSystemMessage("已连接到聊天室服务器");

            Thread receiveThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    receiveMessages();
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "无法连接到服务器，请确保服务器已启动！\n错误信息: " + e.getMessage(),
                "连接失败", 
                JOptionPane.ERROR_MESSAGE);
            connected = false;
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                String finalMessage = message;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        parseAndDisplayMessage(finalMessage);
                    }
                });
            }
        } catch (IOException e) {
            if (connected) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        appendSystemMessage("与服务器的连接已断开");
                    }
                });
            }
        }
    }

    private void parseAndDisplayMessage(String fullMessage) {
        if (fullMessage.startsWith("[系统]")) {
            String content = fullMessage.substring(4);
            appendSystemMessage(content);
        } else if (fullMessage.matches("\\[.*?\\].*")) {
            int endBracket = fullMessage.indexOf("]");
            String sender = fullMessage.substring(1, endBracket);
            String content = fullMessage.substring(endBracket + 2);
            
            if (sender.equals(nickname)) {
                appendMyMessage(content);
            } else {
                appendOtherMessage(sender, content);
            }
        } else {
            appendSystemMessage(fullMessage);
        }
    }

    private void appendSystemMessage(String message) {
        try {
            SimpleAttributeSet centerAttr = new SimpleAttributeSet();
            StyleConstants.setAlignment(centerAttr, StyleConstants.ALIGN_CENTER);
            StyleConstants.setForeground(centerAttr, Color.GRAY);
            StyleConstants.setFontSize(centerAttr, 12);
            
            document.insertString(document.getLength(), "\n" + message + "\n", centerAttr);
            chatArea.setCaretPosition(document.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void appendMyMessage(String message) {
        try {
            document.insertString(document.getLength(), "\n", null);
            
            SimpleAttributeSet rightAttr = new SimpleAttributeSet();
            StyleConstants.setAlignment(rightAttr, StyleConstants.ALIGN_RIGHT);
            StyleConstants.setForeground(rightAttr, new Color(255, 255, 255));
            StyleConstants.setBackground(rightAttr, new Color(0, 132, 255));
            StyleConstants.setFontSize(rightAttr, 14);
            StyleConstants.setFontFamily(rightAttr, "微软雅黑");
            
            String displayText = message + "  [" + nickname + "]";
            document.insertString(document.getLength(), displayText + "\n", rightAttr);
            chatArea.setCaretPosition(document.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void appendOtherMessage(String sender, String message) {
        try {
            document.insertString(document.getLength(), "\n", null);
            
            SimpleAttributeSet leftAttr = new SimpleAttributeSet();
            StyleConstants.setAlignment(leftAttr, StyleConstants.ALIGN_LEFT);
            StyleConstants.setForeground(leftAttr, new Color(51, 51, 51));
            StyleConstants.setBackground(leftAttr, new Color(240, 240, 240));
            StyleConstants.setFontSize(leftAttr, 14);
            StyleConstants.setFontFamily(leftAttr, "微软雅黑");
            
            String displayText = "[" + sender + "]  " + message;
            document.insertString(document.getLength(), displayText + "\n", leftAttr);
            chatArea.setCaretPosition(document.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty() && connected) {
            writer.println(message);
            inputField.setText("");
        }
    }

    private void closeConnection() {
        connected = false;
        try {
            if (writer != null) writer.close();
            if (reader != null) reader.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatClient().setVisible(true);
            }
        });
    }
}
