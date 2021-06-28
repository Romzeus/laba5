package labs.util.io;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Wrapper for Printer instance which allows to use localization
 * @author Romzeus
 */
public class TranslatorPrinter implements Printer{
    private ResourceBundle bundle;
    private final Printer printer;

    /**
     * Constructor of TranslatorPrinter
     * @param printer Printer instance that will be wrapped
     * @param locale Localization instance
     */
    public TranslatorPrinter(Printer printer, Locale locale) {
        this.printer = printer;
        this.bundle = ResourceBundle.getBundle("labs.util.locale.Language", locale);
    }

    /**
     * Method that prints localized message if it is in localization dictionary, otherwise prints message itself
     * @param message String message needed to print
     */
    @Override
    public void print(String message) {
        String translation = (bundle.containsKey(message) ? bundle.getString(message) : message);
        printer.print(translation);
    }
}
