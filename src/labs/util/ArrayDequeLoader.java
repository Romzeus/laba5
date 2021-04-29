package labs.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import labs.structures.Route;
import labs.util.io.Printer;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.time.LocalDate;

/**
 * Class responsible for loading collection of Route instances from json file
 * @author Romzeus
 */
public class ArrayDequeLoader {
    public static final String filepath = System.getenv("SERIALIZED_COLLECTION").replace("\\", "\\\\");
    private static LocalDate initTime;
    private static Printer printer;
    private static ArrayDeque<Route> deserialize(InputStreamReader in) {
        Type type = new TypeToken<ArrayDeque<Route>>(){}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(in, type);
    }

    /**
     * Method that loads collection from file
     */
    public static void load() {
        try(InputStreamReader in = new InputStreamReader(new FileInputStream(filepath))) {
            ArrayDeque<Route> arrayDeque = deserialize(in);
            for (Route route : arrayDeque) {
                ArrayDequeManager.addElement(route);
            }
        } catch(IOException|NullPointerException exception) {
            if(exception instanceof NullPointerException)
                printer.print("Empty file");
            else
                printer.print("Something wrong file");
        } finally {
            initTime = LocalDate.now();
        }
    }

    /**
     * Method that allows to set Printer for output of exceptions
     * @param printer Printer instance for output of exceptions
     */
    public static void setPrinter(Printer printer) {
        ArrayDequeLoader.printer = printer;
    }

    /**
     * Method providing initialization time of collection
     * @return Initialization time
     */
    public static LocalDate getInitTime() {
        return initTime;
    }
}

