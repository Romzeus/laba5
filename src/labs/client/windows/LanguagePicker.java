package labs.client.windows;

import labs.util.locale.LocaleSelector;
import javax.swing.*;
import java.util.Locale;

public class LanguagePicker extends JFrame {
    private JComboBox comboBox;
    public LanguagePicker() {
        super("pick_language");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] languages = {"ru", "de", "es", "lt"};
        comboBox = new JComboBox(languages);
        comboBox.addActionListener(x -> {
            Locale locale;
            switch (comboBox.getSelectedIndex()) {
                case 1:
                    locale = new Locale("de");
                    break;
                case 2:
                    locale = new Locale("es", "GT");
                    break;
                case 3:
                    locale = new Locale("lt");
                    break;
                default:
                    locale = new Locale("ru");
                    break;
            }
            LocaleSelector.changeLocale(locale);
        });
        this.getContentPane().add(comboBox);
        this.pack();
        this.setVisible(true);
    }
}
