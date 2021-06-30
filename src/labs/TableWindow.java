package labs;

import javax.swing.*;

public class TableWindow extends JFrame{
    private JTable table1;
    private JPanel panel1;
    private JButton perform_actionButton;
    private JComboBox comboBox1;
    private JScrollBar scrollBar1;

    public TableWindow() {
        perform_actionButton.addActionListener(e -> {
            if(comboBox1.getSelectedIndex()==4)
                System.exit(0);
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
