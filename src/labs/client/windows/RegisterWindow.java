package labs.client.windows;

import labs.commands.Executable;
import labs.send.ServerMessage;
import labs.structures.User;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class RegisterWindow extends JFrame {
    public RegisterWindow(Printer printer, ArgumentProvider<String> provider, Executable add, Executable delete, Executable history) {
        super("Register");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        JTextField nameField = new JTextField(15);
        nameField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(x -> {
            Deque<String> arg = new ArrayDeque<String>();
            arg.push("1");
            provider.addArguments(arg);
        });
        submitButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JButton registerButton = new JButton("register");
        registerButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        registerButton.addActionListener(x -> {
            User user = new User(nameField.getText(), passwordField.getText());
            printer.print(Serializer.serialize(new ServerMessage().setUser(user).setServerToken("check_user")));
            if(Integer.parseInt(provider.getArgument())==1)
            SwingUtilities.invokeLater(() -> new MainWindow(provider, add, history, delete));
//            else printer.print("false");
        });
        panel.add(nameField);
        panel.add(passwordField);
        panel.add(submitButton);
        panel.add(registerButton);
        layout.putConstraint(SpringLayout.WEST, nameField, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, submitButton, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, registerButton, 20, SpringLayout.EAST, submitButton);
        layout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.SOUTH, passwordField);
        layout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 10, SpringLayout.SOUTH, nameField);
        layout.putConstraint(SpringLayout.NORTH, registerButton, 0, SpringLayout.NORTH, submitButton);
        this.add(panel);
        this.setBounds(0,0,400,300);
        this.setVisible(true);
    }
}
