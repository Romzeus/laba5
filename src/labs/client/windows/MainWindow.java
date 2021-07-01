package labs.client.windows;

import labs.client.MessageReceiver;
import labs.commands.Executable;
import labs.util.ArgumentProvider;
import javax.swing.*;

public class MainWindow extends JFrame {
    private JTable table;
    private JButton performAction;
    private JComboBox actions;
    private JScrollPane scrollBar;
    private ArgumentProvider<String> provider;
    private Executable add;
    private Executable history;
    private Executable delete;
    private Executable show;
    public MainWindow(ArgumentProvider<String> provider, Executable add, Executable history, Executable delete, Executable show) {
        super("MainWindow");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[][] data = {{" ", " ", " ", " ", " ", " ", " ", " "}};
        this.add = add;
        this.history = history;
        this.delete = delete;
        this.show = show;
        initializeTable(data);
        scrollBar = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setVisible(true);
        scrollBar.setVisible(true);
        String[] actionList = {"Add", "History", "Delete", "switch_language"};
        actions = new JComboBox(actionList);
        performAction = new JButton("Submit");
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
        String[] columnNames = {"ID", "NAME", "TIME", "DISTANCE", "XCOORDINATES", "YCOORDINATES", "LOCATIONNAME", "XLOCCOOR,",
                "YLOCCOOR"};
        show.execute();
        String[][] tableData = MessageReceiver.scan().getData();/*{{" ", " ", " ", " ", " ", " ", " ", " "}};*/
        if(data.length != 0)
            tableData = data;
        this.table = new JTable(tableData, columnNames);
    }
}
