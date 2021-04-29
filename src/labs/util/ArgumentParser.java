package labs.util;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import labs.util.io.*;

public class ArgumentParser implements ArgumentProvider{
    private Printer printer = new ConsolePrinter();
    private Scanner scanner = new ConsoleScanner();
    private Deque<String> arguments = new ArrayDeque<>();
    public void parse() {
        parseString(scanner.scan());
    }
    private void parseString(String string) {
        arguments = new ArrayDeque<>(Arrays.asList(string.trim().split("\\s")));
    }
    public String getArgument() {
        prepare();
        String result = arguments.poll();
        return (result != null ? (result.equals("") ? null : result) : null);
    }
    public void clear() {
        arguments.clear();
    }
    public boolean hasNext() {
        return !arguments.isEmpty();
    }
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    private void prepare() {
        if(hasNext())
            return;
        parse();
    }
}
