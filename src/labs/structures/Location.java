package labs.structures;

public class Location implements Comparable<Location>{
    private Double x;
    private int y;
    private String name;
    public Location(Double x, int y, String name) {
        if(x == null || name == null)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.name = name;
    }
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
