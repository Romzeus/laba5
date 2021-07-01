package labs.client.windows;

import labs.commands.Executable;
import labs.util.ArgumentProvider;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class DeleteIdWindow extends JFrame {
    public DeleteIdWindow(Executable delete, ArgumentProvider<String> provider) {
        super("delete_id");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextField id = new JTextField("id", 10);
        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(x -> {
            Deque<String> argument = new ArrayDeque<String>();
            argument.push(id.getText());
            provider.addArguments(argument);
            delete.execute();
        });
        panel.add(id);
        panel.add(submitButton);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
