package labs.util.io;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for printing data in file
 * @author Romzeus
 */
public class FilePrinter implements Printer{
    private String filePath;
    private final Printer printer;

    /**
     * Constructor of FilePrinter instance, that requires only Printer instance for printing exceptions
     * @param printer Printer object for printing exceptions
     */
    public FilePrinter(Printer printer) {
        this.printer = printer;
    }

    /**
     * Constructor of FilePrinter instance, that requires Printer instance and filepath
     * @param printer Printer instance for printing exceptions
     * @param filepath String filepath
     */
    public FilePrinter(Printer printer, String filepath) {
        changeFile(filepath);
        this.printer = printer;
    }

    /**
     * Method that allows to change filepath
     * @param filePath new filepath
     */
    public void changeFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method for printing String message in file
     * @param message String message needed to print
     */
    @Override
    public void print(String message) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.write(message);
        } catch(IOException exception) {
            printer.print(exception.getMessage());
        }
    }
}
