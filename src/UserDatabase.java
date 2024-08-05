import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase {
    private Connection connection;

    public UserDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "Sayanyellow12!_");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String userId, String name, String role) {
        try {
            String query = "INSERT INTO users (user_id, name, role) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userId);
            statement.setString(2, name);
            statement.setString(3, role);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String userId, String name, String role) {
        try {
            String query = "UPDATE users SET name = ?, role = ? WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, role);
            statement.setString(3, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String userId) {
        try {
            String query = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String userId) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getString("user_id"), resultSet.getString("name"), resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}