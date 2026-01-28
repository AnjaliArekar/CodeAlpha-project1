import javax.swing.SwingUtilities;

public class ChatbotApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatbotGUI().setVisible(true);
        });
    }
}
