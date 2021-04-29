package labs.util.io;
import java.util.Scanner;

/**
 * Class for scanning user input from console
 * @author Romzeus
 */
public class ConsoleScanner implements labs.util.io.Scanner{
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Method for scanning information from console
     * @return String line from console
     */
    @Override
    public String scan() {
        return scanner.nextLine();
    }
}
