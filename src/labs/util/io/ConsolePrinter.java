package labs.util.io;

/**
 * Class for printing information in console
 * @author Romzeus
 */
public class ConsolePrinter implements Printer{
    /**
     * Method for printing method in console
     * @param message String message needed to print
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
