package labs.util.io;

import labs.util.locale.Localization;

/**
 * Wrapper for Printer instance which allows to use localization objects
 * @author Romzeus
 */
public class TranslatorPrinter implements Printer{
    private final Localization localization;
    private final Printer printer;

    /**
     * Constructor of TranslatorPrinter
     * @param printer Printer instance that will be wrapped
     * @param localization Localization instance
     */
    public TranslatorPrinter(Printer printer, Localization localization) {
        this.printer = printer;
        this.localization = localization;
    }

    /**
     * Method that prints localized message if it is in localization dictionary, otherwise prints message itself
     * @param message String message needed to print
     */
    @Override
    public void print(String message) {
        if(localization.translate(message) != null)
            printer.print(localization.translate(message));
        else
            printer.print(message);
    }
}
