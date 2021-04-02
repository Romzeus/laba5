package labs.structures.to;

public class Location implements Comparable<Location>{
    public static class LocationInitializer {
        public static Location createLocation(long x, Long y, String name) {
            if(y == null || name == null)
                throw new IllegalArgumentException();
            return new Location(x, y, name);
        }
    }
    private long x;
    private Long y;
    private String name;
    private Location(long x, Long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public int compareTo(Location location) {
        return (int)(x * x - location.x * location.x + y * y - location.y * location.y) + name.compareTo(location.name);
    }
}
