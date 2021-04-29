package labs.structures;

import labs.util.IdGenerator;
import java.time.LocalDate;

public class Route implements Comparable<Route>{
    private final Integer id;
    private String name;
    private Coordinates coordinates;
    private final LocalDate creationDate;
    private Location location;
    private Float distance;
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
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getDistance() {
        return distance;
    }
    public void remake(String name, Coordinates coordinates, Location location, float distance) {
        this.name = name;
        this.coordinates = coordinates;
        this.location = location;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "Route #" + id;
    }
}
