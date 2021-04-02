package labs.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import labs.util.io.*;
import labs.util.io.Scanner;

public class ArgumentParser {
    private static Printer printer = new ConsolePrinter();
    private static labs.util.io.Scanner consoleScanner = new ConsoleScanner();
    private static Deque<String> arguments;
    public static void parse() {
        parseString(consoleScanner.scan());
    }
    public static void parseFile(String filepath) throws IOException {
        try {
            Scanner fileScanner = new FileScanner(filepath);
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