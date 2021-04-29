package labs.structures;
/**
 * Class of location, required for Route class
 */
public class Location implements Comparable<Location>{
    private Double x;
    private int y;
    private String name;

    /**
     * Constructor of Location object
     * @param x x coordinate, it shouldn't be null
     * @param y y coordinate, it can be null
     * @param name Name of location, it shouldn't be null
     */
    public Location(Double x, int y, String name) {
        if(x == null || name == null)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Method to compare objects of locations
     * @param location Object of location, which is compared to this object
     * @return 1 if this object is greater, -1 if this object is lesser, 0 if equals
     */
    @Override
    public int compareTo(Location location) {
        if(this.y > location.y)
            return 1;
        else if(this.y < location.y)
            return -1;
        else {
            if(this.x.compareTo(location.x) == 0)
                return this.name.compareTo(location.name);
            else return this.x.compareTo(location.x);
        }
    }
}
