package labs.structures;

public class Coordinates implements Comparable<Coordinates>{
    public static class CoordinatesInitializer {
        public static Coordinates createCoordinates(long x, Long y) {
            if(x > 130 || y == null)
                throw new IllegalArgumentException();
            return new Coordinates(x, y);
        }
    }
    private long x;
    private Long y;
    private Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinates coordinates) {
        return (int)((x * x + y * y) - (coordinates.x * coordinates.x + coordinates.y * coordinates.y));
    }
}
