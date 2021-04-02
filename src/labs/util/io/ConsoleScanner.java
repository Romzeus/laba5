package labs.util.io;
import java.util.Scanner;

public class ConsoleScanner implements labs.util.io.Scanner{
    private final Scanner scanner;
    public ConsoleScanner() {
        this.scanner = new Scanner(System.in);
    }
    @Override
    public String scan() {
        return scanner.nextLine();
    }
}
