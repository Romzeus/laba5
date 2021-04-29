package labs.structures;

import labs.util.IdGenerator;
import java.time.LocalDate;

/**
 * Route class
 * @author Romzeus
 */
public class Route implements Comparable<Route>{
    private final Integer id;
    private String name;
    private Coordinates coordinates;
    private final LocalDate creationDate;
    private Location location;
    private Float distance;

    /**
     * Constructor of Route object
     * @param name Name of Route
     * @param coordinates Coordinates of Route
     * @param location Location of Route
     * @param distance Distance of Route
     */
    public Route(String name, Coordinates coordinates, Location location, float distance) {
        if (name == null || name.equals("") || coordinates == null || location == null || distance < 1)
            throw new IllegalArgumentException();
        creationDate = LocalDate.now();
        this.id = IdGenerator.getId();
        this.name = name;
        this.coordinates = coordinates;
        this.location = location;
        this.distance = distance;
    }

    /**
     * Method to compare objects of routes
     * @param route Object of route, which is compared to this object
     * @return 1 if this object is greater, -1 if this object is lesser, 0 if equals
     */
    @Override
    public int compareTo(Route route) {
        if(this.coordinates.compareTo(route.coordinates) == 0){
            if(this.location.compareTo(route.location) == 0){
                if(this.distance.compareTo(route.distance) == 0)
                    return this.name.compareTo(route.name);
                else
                    return this.distance.compareTo(route.distance);
            } else return this.location.compareTo(route.location);
        } else return this.coordinates.compareTo(route.coordinates);
    }

    /**
     * Getter for id value
     * @return id of this Route
     */
    public int getId() {
        return id;
    }

    /**
     * Getter of name value
     * @return Name of this Route
     */
    public String getName() {
        return name;
    }

    /**
     * Getter if distance value
     * @return Distance of this Route
     */
    public float getDistance() {
        return distance;
    }

    /**
     * Method to change values of fields of this Route
     * @param name Name of Route
     * @param coordinates Coordinates of Route
     * @param location Location of Route
     * @param distance Distance of Route
     */
    public void remake(String name, Coordinates coordinates, Location location, float distance) {
        this.name = name;
        this.coordinates = coordinates;
        this.location = location;
        this.distance = distance;
    }

    /**
     * Method for string representation of Route
     * @return String representation of Route object
     */
    @Override
    public String toString() {
        return "Route #" + id;
    }
}
