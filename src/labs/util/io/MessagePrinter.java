package labs.util.io;

import javax.swing.*;

public class MessagePrinter implements Printer{
    @Override
    public void print(String message) {
        JFrame frame = new JFrame("Message");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message);
    }
    public static void main(String[] args) {
        new MessagePrinter().print("Message");
    }
}
