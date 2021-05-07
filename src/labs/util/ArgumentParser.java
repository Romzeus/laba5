package labs.util;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

import labs.util.io.*;

/**
 * Class for managing user input of commands and arguments
 * @author Romzeus
 */
public class ArgumentParser implements ArgumentProvider<String>{
    private final Scanner scanner;
    private Deque<String> arguments = new ArrayDeque<>();

    /**
     * Constructor of ArgumentParser object
     * @param scanner Object of scanner interface that will provide user input
     */
    public ArgumentParser(Scanner scanner) {
        this.scanner = scanner;
    }
    private void parse() {
        parseString(scanner.scan());
    }
    private void parseString(String string) {
        arguments = new ArrayDeque<>(Arrays.asList(string.trim().split("\\s")));
    }

    /**
     * Method that provides next argument from user input
     * @return next String from user input
     */
    public String getArgument() {
        prepare();
        String result = arguments.poll();
        return (result != null ? (result.equals("") ? null : result) : null);
    }

    /**
     * Method for clearing user input
     */
    public void clear() {
        arguments.clear();
    }

    /**
     * Method that tells are there any arguments left
     * @return True if there are arguments left; otherwise false
     */
    public boolean hasNext() {
        return !arguments.isEmpty();
    }
    private void prepare() {
        if(hasNext())
            return;
        parse();
    }

    /**
     * Method that allows to get arguments from another ArgumentProvider instance
     * @param arguments arguments from different ArgumentProvider instance
     */
    @Override
    public void addArguments(Deque<String> arguments) {
        Iterator<String> iterator = arguments.descendingIterator();
        while(iterator.hasNext()){
            this.arguments.addFirst(iterator.next());
        }
    }

    /**
     * Method that allows to show arguments
     * @return String Deque of arguments
     */
    @Override
    public Deque<String> getAll() {
        prepare();
        return arguments;
    }
}
