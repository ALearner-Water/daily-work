package Exercise.work5;

import java.io.*;
import java.net.Socket;

public class ChatThread extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String nickname;

    public ChatThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            this.nickname = reader.readLine();
            if (nickname == null || nickname.trim().isEmpty()) {
                this.nickname = "匿名用户";
            }
            this.setName(nickname);

            ChatServer.addClient(writer, nickname);
            
            System.out.println("[" + nickname + "] 已连接");
            ChatServer.broadcastMessage("系统", nickname + " 加入了聊天室", null);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("[" + nickname + "] 收到消息: " + message);
                ChatServer.broadcastMessage(nickname, message, "user");
            }
        } catch (IOException e) {
            System.out.println("[" + nickname + "] 客户端断开连接");
        } finally {
            if (writer != null) {
                ChatServer.removeClient(writer);
            }
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
