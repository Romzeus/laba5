package labs.util.io;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer{
    private String filePath;
    private final Printer printer;
    public FilePrinter(Printer printer) {
        this.printer = printer;
    }
    public FilePrinter(Printer printer, String filepath) {
        changeFile(filepath);
        this.printer = printer;
    }
    public void changeFile(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void print(String message) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.write(message);
        } catch(IOException exception) {
            printer.print(exception.getMessage());
        }
    }
}
