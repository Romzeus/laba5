package labs.exceptions;

public class Recursion extends RuntimeException {
    @Override
    public String getMessage() {
        return toString();
    }
    @Override
    public String toString() {
        return "Recursion";
    }
}
