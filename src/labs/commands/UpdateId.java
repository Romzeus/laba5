package labs.commands;

import labs.structures.Coordinates;
import labs.structures.Location;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.creator.CoordinatesMaker;
import labs.util.creator.LocationMaker;
import labs.util.io.Printer;
import java.util.Iterator;

/**
 * Class of update command
 * @author Romzeus
 */
public class UpdateId extends Command{
    protected final ArgumentProvider<String> argumentProvider;
    protected final Printer printer;

    /**
     * Constructor of UpdateId object
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments
     * @param printer Object of Printer interface
     */
    public UpdateId(ArgumentProvider<String> argumentProvider, Printer printer) {
        super("update", "Update description");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        int id = Integer.parseInt(argumentProvider.getArgument());
        Iterator<Route> route = ArrayDequeManager.getArrayDeque().iterator();
        Route current;
        while(route.hasNext()) {
            current = route.next();
            if(current.getId() == id){
                printer.print("Write name");
                String name = argumentProvider.getArgument();
                printer.print("Coordinate creation");
                Coordinates coordinates = new CoordinatesMaker(argumentProvider, printer).make();
                printer.print("Location creation");
                Location location = new LocationMaker(argumentProvider, printer).make();
                printer.print("Write distance");
                Float distance = null;
                while(distance == null) {
                    try{
                        distance = Float.parseFloat(argumentProvider.getArgument());
                    } catch(NullPointerException exception) {
                        printer.print("Distance not less than 1");
                        printer.print("Try again");
                    }
                }
                current.remake(name, coordinates, location, distance);
            }
        }
        printer.print("Object not found");
    }
}
