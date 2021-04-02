package labs.util.creator;
import labs.structures.*;
import labs.util.ArgumentParser;

public class RouteMaker extends Creator<Route> {
    private CoordinatesMaker coordinatesMaker;
    private FromLocationMaker fromLocationMaker;
    private ToLocationMaker toLocationMaker;
    public RouteMaker() {
        coordinatesMaker = new CoordinatesMaker();
        fromLocationMaker = new FromLocationMaker();
        toLocationMaker = new ToLocationMaker();
    }
    @Override
    public Route make() {
        ArgumentParser.prepare();
        String name = null;
        while(name == null) {
            try {
                name = ArgumentParser.getArgument();
            } catch (NullPointerException exception) {
                name = null;
            }
            if(name == null) {
                System.out.println("Название не может быть пустым. Попробуйте ввести название еще раз: ");
                ArgumentParser.prepare();
            }
        }
        Float distance = null;
        while(distance == null || distance < 1f) {
            try {
                distance = Float.parseFloat(ArgumentParser.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                distance = null;
            }
            if(distance == null || distance < 1f) {
                System.out.println("Расстояние не может быть меньше 1 или не числом. Попробуйте ввести расстояние еще раз: ");
                ArgumentParser.prepare();
            }
        }
        Coordinates coordinates = coordinatesMaker.make();
        labs.structures.from.Location fromLocation = fromLocationMaker.make();
        labs.structures.to.Location toLocation = toLocationMaker.make();
        return Route.RouteInitializer.createRoute(name, coordinates, fromLocation, toLocation, distance);
    }
}
