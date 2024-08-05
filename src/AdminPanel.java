import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {
    private SchoolManagementSystem mainFrame;
    private UserDatabase userDatabase;

    public AdminPanel(SchoolManagementSystem mainFrame) {
        this.mainFrame = mainFrame;
        this.userDatabase = new UserDatabase();

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Admin Panel", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserFormDialog(mainFrame, userDatabase, "Add User").setVisible(true);
            }
        });
        buttonPanel.add(addUserButton);

        JButton updateUserButton = new JButton("Update User");
        updateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserFormDialog(mainFrame, userDatabase, "Update User").setVisible(true);
            }
        });
        buttonPanel.add(updateUserButton);

        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = JOptionPane.showInputDialog(mainFrame, "Enter User ID to delete:");
                if (userId != null && !userId.trim().isEmpty()) {
                    userDatabase.deleteUser(userId);
                    JOptionPane.showMessageDialog(mainFrame, "User deleted successfully!");
                }
            }
        });
        buttonPanel.add(deleteUserButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}