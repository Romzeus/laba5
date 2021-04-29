package labs.util.creator;
import labs.structures.*;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;

public class RouteMaker extends Creator<Route> {
    private final CoordinatesMaker coordinatesMaker;
    private final LocationMaker locationMaker;
    private final ArgumentProvider argumentProvider;
    private final Printer printer;
    public RouteMaker(ArgumentProvider argumentProvider, Printer printer) {
        coordinatesMaker = new CoordinatesMaker(argumentProvider, printer);
        locationMaker = new LocationMaker(argumentProvider, printer);
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public Route make() {
        String name = null;
        while(name == null) {
            try {
                name = argumentProvider.getArgument();
            } catch (NullPointerException exception) {
                name = null;
            }
            if(name == null) {
                printer.print("Название не может быть пустым. Попробуйте ввести название еще раз: ");
            }
        }
        Float distance = null;
        while(distance == null || distance < 1f) {
            try {
                distance = Float.parseFloat(argumentProvider.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                distance = null;
            }
            if(distance == null || distance < 1f) {
                printer.print("Расстояние не может быть меньше 1 или не числом. Попробуйте ввести расстояние еще раз: ");
            }
        }
        Coordinates coordinates = coordinatesMaker.make();
        Location fromLocation = locationMaker.make();
        return new Route(name, coordinates, fromLocation, distance);
    }
}
