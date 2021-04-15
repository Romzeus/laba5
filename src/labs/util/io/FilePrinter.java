package labs.util.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer{
    private BufferedWriter bufferedWriter;
    private final Printer printer;
    public FilePrinter(Printer printer) {
        this.printer = printer;
    }
    public FilePrinter(String filepath, Printer printer) throws IOException {
        changeFile(filepath);
        this.printer = printer;
    }
    public void changeFile(String filePath) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(filePath));
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
