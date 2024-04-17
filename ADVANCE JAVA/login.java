import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {
    // Components
    JLabel titleLabel, userLabel, passLabel;
    JTextField userTextField;
    JPasswordField passField;
    JButton loginButton;

    // Constructor
    public login() {
        // Frame setup
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Components initialization
        titleLabel = new JLabel("Login Form");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userTextField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Login");

        // Layout setup
        setLayout(new GridLayout(3, 2));

        // Adding components to frame
        add(titleLabel);
        add(new JLabel()); // Placeholder
        add(userLabel);
        add(userTextField);
        add(passLabel);
        add(passField);
        add(new JLabel()); // Placeholder
        add(loginButton);

        // Adding action listener to login button
        loginButton.addActionListener(this);
    }

    // Action performed when login button is clicked
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = new String(passField.getPassword());

        // Simple validation for demonstration purpose
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Open the Menu_Page
            Menu_Page menuPage = new Menu_Page(username); // Passing username to Menu_Page constructor
            menuPage.setVisible(true);
            dispose(); // Close the login form window upon successful login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }
    }
    public static void main(String[] args) {
        login login = new login();
        login.setVisible(true);
    }
}
