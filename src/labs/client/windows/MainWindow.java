package labs.client.windows;

import labs.commands.Executable;
import labs.util.ArgumentProvider;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JTable table;
    private JButton performAction;
    private JComboBox actions;
    private JScrollPane scrollBar;
    private ArgumentProvider<String> provider;
    private Executable add;
    private Executable history;
    private Executable delete;
    public MainWindow(ArgumentProvider<String> provider, Executable add, Executable history, Executable delete) {
        super("main_window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[][] data = {{" ", " ", " ", " ", " ", " ", " ", " "}};
        initializeTable(data);
        scrollBar = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setVisible(true);
        scrollBar.setVisible(true);
        String[] actionList = {"add", "history", "delete_by_id", "switch_language"};
        actions = new JComboBox(actionList);
        performAction = new JButton("submit");
        performAction.addActionListener(e -> {
            switch (actions.getSelectedIndex()) {
                case 0:
                    SwingUtilities.invokeLater(() -> new RouteAddWindow(provider, add));
                    break;
                case 1:
                    history.execute();
                    break;
                case 2:
                    SwingUtilities.invokeLater(() -> new DeleteIdWindow(delete, provider));
                    break;
                case 3:
                    SwingUtilities.invokeLater(LanguagePicker::new);
                    break;
                default:
                    break;
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(performAction);
        panel1.add(actions);
        panel.add(scrollBar);
        panel.add(panel1);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    public void initializeTable(String[][] data) {
        String[] columnNames = {"NAME", "TIME", "DISTANCE", "XCOORDINATES", "YCOORDINATES", "LOCATIONNAME", "XLOCCOOR,",
                "YLOCCOOR"};
        String[][] tableData = {{" ", " ", " ", " ", " ", " ", " ", " "}};
        if(data.length != 0)
            tableData = data;
        this.table = new JTable(tableData, columnNames);
    }
}
