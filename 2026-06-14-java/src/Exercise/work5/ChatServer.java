package Exercise.work5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ChatServer {
    private static List<PrintWriter> clientWriters = new ArrayList<>();
    private static Map<PrintWriter, String> clientNicknames = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("聊天室服务器已启动，监听端口 8888...");
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("有新客户端连接: " + socket.getInetAddress());
            
            ChatThread chatThread = new ChatThread(socket);
            chatThread.start();
        }
    }

    public static void addClient(PrintWriter writer, String nickname) {
        synchronized (clientWriters) {
            clientWriters.add(writer);
            clientNicknames.put(writer, nickname);
        }
    }

    public static void removeClient(PrintWriter writer) {
        synchronized (clientWriters) {
            String nickname = clientNicknames.remove(writer);
            clientWriters.remove(writer);
            if (nickname != null) {
                broadcastMessage("系统", nickname + " 离开了聊天室", null);
                System.out.println("[" + nickname + "] 已断开连接");
            }
        }
    }

    public static void broadcastMessage(String sender, String message, String type) {
        String formattedMessage;
        if ("system".equals(type)) {
            formattedMessage = "[系统] " + message;
        } else if ("user".equals(type)) {
            formattedMessage = "[" + sender + "] " + message;
        } else {
            formattedMessage = message;
        }
        
        System.out.println("广播消息: " + formattedMessage);
        
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                try {
                    writer.println(formattedMessage);
                    writer.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
