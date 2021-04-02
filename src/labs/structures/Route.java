package labs.structures;
import labs.util.IdGenerator;

import java.time.LocalDate;

public class Route implements Comparable<Route>{
    public static class RouteInitializer {
        public static Route createRoute(String name, Coordinates coordinates, labs.structures.from.Location from, labs.structures.to.Location to, float distance) {
            if (name == null || name.equals("") || coordinates == null || from == null || distance < 1)
                throw new IllegalArgumentException();
            return new Route(name, coordinates, from, to, distance);
        }
    }
    private final Integer id;
    private String name;
    private Coordinates coordinates;
    private final LocalDate creationDate;
    private labs.structures.from.Location from;
    private labs.structures.to.Location to;
    private Float distance;
    private Route(String name, Coordinates coordinates, labs.structures.from.Location from, labs.structures.to.Location to, float distance) {
        creationDate = LocalDate.now();
        this.id = IdGenerator.getId();
        this.name = name;
        this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    @Override
    public int compareTo(Route route) {
        return id.compareTo(route.id) + name.compareTo(route.name) + coordinates.compareTo(route.coordinates) + creationDate.compareTo(route.creationDate) + from.compareTo(route.from) + to.compareTo(route.to) + distance.compareTo(route.distance);
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getDistance() {
        return distance;
    }
    public void remake(String name, Coordinates coordinates, labs.structures.from.Location from, labs.structures.to.Location to, float distance) {
        this.name = name;
        this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "Route #" + id;
    }
}
