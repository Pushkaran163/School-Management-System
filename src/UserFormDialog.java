import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFormDialog extends JDialog {
    private JTextField userIdField;
    private JTextField nameField;
    private JTextField roleField;
    private UserDatabase userDatabase;

    public UserFormDialog(JFrame parent, UserDatabase userDatabase, String title) {
        super(parent, title, true);
        this.userDatabase = userDatabase;

        setLayout(new GridLayout(4, 2));
        setSize(400, 200);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();
        add(userIdLabel);
        add(userIdField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        add(nameLabel);
        add(nameField);

        JLabel roleLabel = new JLabel("Role:");
        roleField = new JTextField();
        add(roleLabel);
        add(roleField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String name = nameField.getText();
                String role = roleField.getText();

                if (userId.isEmpty() || name.isEmpty() || role.isEmpty()) {
                    JOptionPane.showMessageDialog(parent, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (title.equals("Add User")) {
                    userDatabase.addUser(userId, name, role);
                    JOptionPane.showMessageDialog(parent, "User added successfully!");
                } else {
                    userDatabase.updateUser(userId, name, role);
                    JOptionPane.showMessageDialog(parent, "User updated successfully!");
                }

                dispose();
            }
        });
        add(new JLabel());
        add(submitButton);
    }
}