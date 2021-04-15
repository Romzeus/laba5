package labs.util;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import labs.util.io.*;

public class ArgumentParser {
    private static Printer printer = new ConsolePrinter();
    private static Scanner scanner = new ConsoleScanner();
    private static Deque<String> arguments = new ArrayDeque<>();
    public static void parse() {
        parseString(scanner.scan());
    }
    public static void parseFile(String filepath) throws IOException {
        try {
            FileScanner fileScanner = new FileScanner(filepath);
            String result = fileScanner.scan();
            parseString(result);
        } catch(IOException exception) {
            printer.print("Нет такого файла");
            throw exception;
        }
    }
    private static void parseString(String string) {
        arguments = new ArrayDeque<>(Arrays.asList(string.trim().split("\\s")));
    }
    public static String getArgument() {
        String result = arguments.poll();
        return (result != null ? (result.equals("") ? null : result) : null);
    }
    public static void clear() {
        arguments.clear();
    }
    public static boolean hasNext() {
        return !arguments.isEmpty();
    }
    public static void setPrinter(Printer printer) {
        ArgumentParser.printer = printer;
    }
    public static void setScanner(Scanner scanner) {
        ArgumentParser.scanner = scanner;
    }
    public static void prepare() {
        if(hasNext())
            return;
        parse();
    }
}
