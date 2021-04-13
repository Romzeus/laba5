package labs.util.io;

import labs.util.ArrayDequeLoader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer{
    private BufferedWriter bufferedWriter;
    private Printer printer;
    public FilePrinter(String filepath, Printer printer) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(ArrayDequeLoader.filepath));
        this.printer = printer;
    }
    @Override
    public void print(String message) {
        try{
            bufferedWriter.write(message);
        } catch(IOException exception) {
            printer.print(exception.getMessage());
        }
    }
}
