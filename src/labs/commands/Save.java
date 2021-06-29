package labs.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import labs.util.ArrayDequeManager;
import labs.util.io.FilePrinter;

/**
 * Class of save command
 * @author Romzeus
 */
public class Save extends Command{
    private final FilePrinter filePrinter;

    /**
     * Constructor of Save object
     * @param filePrinter Object of FilePrinter class, which will write serialized objects to json file
     */
    public Save(FilePrinter filePrinter) {
        super("save", "save_description");
        this.filePrinter = filePrinter;
    }
    @Override
    public void execute() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(ArrayDequeManager.getArrayDeque());
        filePrinter.print(result + "\n");
    }
}
