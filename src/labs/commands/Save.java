package labs.commands;
import com.google.gson.Gson;
import labs.util.ArrayDequeLoader;
import labs.util.ArrayDequeManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends Command{
    public Save() {
        super("save", "Сохраняет коллекцию в json-файл");
    }
    @Override
    public void execute() {
        Gson gson = new Gson();
        String result = gson.toJson(ArrayDequeManager.getArrayDeque());
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ArrayDequeLoader.filepath))) {
            bufferedWriter.write(result + "\n");
        } catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }
}
