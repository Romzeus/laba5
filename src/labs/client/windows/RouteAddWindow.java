package labs.client.windows;

import labs.commands.Executable;
import labs.util.ArgumentProvider;
import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteAddWindow extends JFrame {
    private final JTextField name = new JTextField(15);
    private final JTextField xCor = new JTextField(15);
    private final JTextField yCor = new JTextField(15);
    private final JTextField distance = new JTextField(15);
    private final JTextField locName = new JTextField(15);
    private final JTextField locXCor = new JTextField(15);
    private final JTextField locYCor = new JTextField(15);
    public RouteAddWindow(ArgumentProvider<String> provider, Executable add) {
        super("add_route");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        name.setText("name");
        xCor.setText("x");
        yCor.setText("y");
        distance.setText("distance");
        locName.setText("location_name");
        locXCor.setText("location_x");
        locYCor.setText("location_y");
        JButton submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.addActionListener(x -> {
            String[] arguments = {name.getText(), xCor.getText(), yCor.getText(), distance.getText(), locName.getText(),
                    locXCor.getText(), locYCor.getText()};
            Stream<String> stream = Arrays.stream(arguments);
            Deque<String> argDeque = stream.collect(Collectors.toCollection(ArrayDeque::new));
            provider.addArguments(argDeque);
            add.execute();
        });
        pane.add(name);
        pane.add(xCor);
        pane.add(yCor);
        pane.add(distance);
        pane.add(locName);
        pane.add(locXCor);
        pane.add(locYCor);
        pane.add(submitButton);
        this.add(pane);
        this.pack();
        this.setVisible(true);
    }
}
