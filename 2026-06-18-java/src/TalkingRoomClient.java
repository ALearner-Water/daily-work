
import javax.swing.*;

public class TalkingRoomClient {
    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog(null,
                "请输入您的昵称:");

        if (username == null || username.trim().isEmpty()) {
            username = "匿名用户";
        }

        final String name= username;

        SwingUtilities.invokeLater(() -> {
            new FrameToChat(name).setVisible(true);
        });
    }
}
