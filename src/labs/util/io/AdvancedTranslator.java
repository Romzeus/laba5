package labs.util.io;

import labs.util.locale.LocaleSelector;

public class AdvancedTranslator implements Printer{
    private Printer printer;
    public AdvancedTranslator(Printer printer) {
        this.printer = printer;
    }
    public void print(String message) {
        printer.print(LocaleSelector.translate(message));
    }
}
