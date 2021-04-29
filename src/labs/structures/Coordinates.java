package labs.structures;

/**
 * Class of coordinates, required for Route class
 */
public class Coordinates implements Comparable<Coordinates>{
    private final long x;
    private final Long y;

    /**
     * Constructor of Coordinates object
     * @param x x coordinate, it should be less than 130
     * @param y y coordinate, it shouldn't be null
     */
    public Coordinates(long x, Long y) {
        if(x > 130 || y == null)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }

    /**
     * Method to compare objects of coordinates
     * @param coordinates Object of coordinates, which is compared to this object
     * @return 1 if this object is greater, -1 if this object is lesser, 0 if equals
     */
    @Override
    public int compareTo(Coordinates coordinates) {
        if(this.x > coordinates.x)
            return 1;
        else if(this.x < coordinates.x)
            return -1;
        else return this.y.compareTo(coordinates.y);
    }
}
