package labs.client.windows;

import javax.swing.*;

public class RegisterWindow extends JFrame {
    public RegisterWindow() {
        super("Register");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JTextField nameField = new JTextField(15);
        nameField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JButton submitButton = new JButton("submit");
        submitButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JButton registerButton = new JButton("register");
        registerButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        panel.add(nameField);
        panel.add(passwordField);
        panel.add(submitButton);
        panel.add(registerButton);
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterWindow::new);
    }
}
