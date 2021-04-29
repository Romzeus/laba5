package labs.util;

import labs.util.io.FileScanner;
import labs.util.io.Printer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FileArgumentParser implements ArgumentProvider{
    private Printer printer;
    private FileScanner scanner;
    private Deque<String> arguments = new ArrayDeque<>();
    public FileArgumentParser(Printer printer, FileScanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }
    private void parseFile() {
        arguments = new ArrayDeque<>(Arrays.asList(scanner.scan()));
    }
    @Override
    public String getArgument() {
        return (hasNext() ? arguments.poll() : "");
    }
    @Override
    public boolean hasNext() {
        return !arguments.isEmpty();
    }
}
