package labs.commands;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import labs.util.ArrayDequeManager;
import labs.util.io.FilePrinter;

public class Save extends Command{
    private final FilePrinter filePrinter;
    public Save(FilePrinter filePrinter) {
        super("save", "Сохраняет коллекцию в json-файл");
        this.filePrinter = filePrinter;
    }
    @Override
    public void execute() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(ArrayDequeManager.getArrayDeque());
        filePrinter.print(result);
    }
}
