package labs.client.windows;

import labs.commands.Executable;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;

import javax.swing.*;

public class TableWindow extends JFrame{
    private JTable table1;
    private JPanel panel1;
    private JButton perform_actionButton;
    private JComboBox comboBox1;
    private JScrollBar scrollBar1;
    private ArgumentProvider<String> provider;
    private Printer printer;
    private Executable add;
    private Executable history;
    private Executable delete;
    private Executable switch_language;

    public TableWindow() {
        perform_actionButton.addActionListener(e -> {
            switch(comboBox1.getSelectedIndex()) {
                case 0:
                    SwingUtilities.invokeLater(() -> new RouteAddWindow(provider, add));
                    break;
                case 1:
                    history.execute();
                    break;
                case 2:
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TableWindow");
        frame.setContentPane(new TableWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
