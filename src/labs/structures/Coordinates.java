package labs.structures;

public class Coordinates implements Comparable<Coordinates>{
    private long x;
    private Long y;
    public Coordinates(long x, Long y) {
        if(x > 130 || y == null)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinates coordinates) {
        if(this.x > coordinates.x)
            return 1;
        else if(this.x < coordinates.x)
            return -1;
        else return this.y.compareTo(coordinates.y);
    }
}
