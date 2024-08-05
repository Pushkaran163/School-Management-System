import javax.swing.*;
import java.awt.*;

public class SchoolManagementSystem extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SchoolManagementSystem() {
        setTitle("School Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        AdminPanel adminPanel = new AdminPanel(this);
        mainPanel.add(adminPanel, "AdminPanel");

        setContentPane(mainPanel);
        cardLayout.show(mainPanel, "AdminPanel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SchoolManagementSystem frame = new SchoolManagementSystem();
            frame.setVisible(true);
        });
    }
}