package labs.util.io;

import labs.util.locale.Localization;

public class TranslatorPrinter implements Printer{
    private final Localization localization;
    private final Printer printer;
    public TranslatorPrinter(Printer printer, Localization localization) {
        this.printer = printer;
        this.localization = localization;
    }
    @Override
    public void print(String message) {
        if(localization.translate(message) != null)
            printer.print(localization.translate(message));
        else
            printer.print(message);
    }
}
