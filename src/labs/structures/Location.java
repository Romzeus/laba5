package labs.structures;

public class Location implements Comparable<Location>{
    public static class LocationInitializer {
        public static Location createLocation(Double x, int y, String name) {
            if(x == null || name == null)
                throw new IllegalArgumentException();
            return new Location(x, y, name);
        }
    }
    private Double x;
    private int y;
    private String name;
    private Location(Double x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    @Override
    public int compareTo(Location location) {
        return (int)(x * x) + (y * y) - (int)(location.x * location.x) - (location.y) * location.y + name.compareTo(location.name);
    }
}
