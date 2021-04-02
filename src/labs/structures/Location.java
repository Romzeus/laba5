package labs.structures;

public class Location implements Comparable<Location>{
    private Double x;
    private int y;
    private String name;
    public Location(double x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    @Override
    public int compareTo(Location location) {
        if (!name.equals(location.name))
            return -1;
        int result = (int)(x * x) + (y * y) - (int)(location.x * location.x) - (location.y) * location.y;
        return result;
    }
}
