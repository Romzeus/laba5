package labs.util.io;

public class Sender {
    private static Printer printer;
    public static void setPrinter(Printer printer) {
        Sender.printer = printer;
    }
    public static void print(String message) {
        printer.print(message);
    }
}
