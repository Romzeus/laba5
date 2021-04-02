package labs.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArgumentParser {
    private static final Scanner scanner = new Scanner(System.in);
    private static Deque<String> arguments;
    public static void parse() {
        parseString(scanner.nextLine());
    }
    public static void parseFile(String filepath) throws IOException {
        try(InputStreamReader input = new InputStreamReader(new FileInputStream(filepath))) {
            Scanner fileScanner = new Scanner(input);
            String result = "";
            while(fileScanner.hasNext()) {
                result = result.concat(" ").concat(fileScanner.next());
            }
            parseString(result);
            } catch(IOException exception) {
            throw exception;
        }
    }
    private static void parseString(String string) {
        arguments = new ArrayDeque<>(Arrays.asList(string.trim().split("\\s")));
    }
    public static String getArgument() {
        String result = arguments.poll();
        return (result.equals("") ? null : result);
    }
    public static void clear() {
        arguments.clear();
    }
    public static boolean hasNext() {
        return !arguments.isEmpty();
    }
    public static void prepare() {
        if(hasNext())
            return;
        parse();
    }
}
