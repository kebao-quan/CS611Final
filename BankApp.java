import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.Color;

public class BankApp extends JFrame {
    public BankApp() {
        setTitle("Bank Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new LoginPanel());

        this.pack();
    }

    private class LoginPanel extends JPanel {
        public LoginPanel() {
            setPreferredSize(new Dimension(400, 400));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(createUserField());
            add(createPasswordField());
            add(createLoginButton());
            add(createRegisterButton());
        }

        private JTextField createUserField() {
            JTextField userField = new JTextField(20);
            userField.setMaximumSize(new Dimension(300, 20));
            add(new JLabel("Username:"));
            add(userField);
            return userField;
        }

        private JPasswordField createPasswordField() {
            JPasswordField passwordField = new JPasswordField(20);
            passwordField.setMaximumSize(new Dimension(300, 20));
            add(new JLabel("Password:"));
            add(passwordField);
            return passwordField;
        }

        private JButton createLoginButton() {
            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(e -> {
                // Check the username and password
                // If they are correct, open the main application window
                // If they are incorrect, display an error message

            });
            return loginButton;
        }

        private JButton createRegisterButton() {
            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(e -> {
                // Open the registration window
                
            });
            return registerButton;
        }
    }
}