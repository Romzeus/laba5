package labs.util.creator;
import labs.structures.*;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;

/**
 * Class for creating new Route objects from user input
 * @author Romzeus
 */
public class RouteMaker implements Creator<Route> {
    private final CoordinatesMaker coordinatesMaker;
    private final LocationMaker locationMaker;
    private final ArgumentProvider argumentProvider;
    private final Printer printer;

    /**
     * Constructor of RouteMaker object
     * @param argumentProvider Instance of ArgumentProvider interface that will provide arguments for creation of Route objects
     * @param printer Instance of Printer object
     */
    public RouteMaker(ArgumentProvider argumentProvider, Printer printer) {
        coordinatesMaker = new CoordinatesMaker(argumentProvider, printer);
        locationMaker = new LocationMaker(argumentProvider, printer);
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }

    /**
     * Method that creates Route objects
     * @return Route object
     */
    @Override
    public Route make() {
        printer.print("Write name");
        String name = null;
        while(name == null) {
            try {
                name = argumentProvider.getArgument();
            } catch (NullPointerException exception) {
                name = null;
            }
            if(name == null) {
                printer.print("Name not null");
                printer.print("Try again");
            }
        }
        printer.print("Write distance");
        Float distance = 0f;
        while(distance < 1f) {
            try {
                distance = Float.parseFloat(argumentProvider.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                if(exception instanceof NullPointerException) {
                    distance = null;
                    break;
                }
                if(exception instanceof NumberFormatException) {
                    printer.print("Wrong format");
                    printer.print("Try again");
                    distance = 0f;
                } else if(distance < 1f){
                    printer.print("Distance not less than 1");
                    printer.print("Try again");
                }
            }
        }
        Coordinates coordinates = coordinatesMaker.make();
        Location fromLocation = locationMaker.make();
        return new Route(name, coordinates, fromLocation, distance);
    }
}
