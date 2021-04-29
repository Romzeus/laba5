package labs.util.creator;

/**
 * Interface for classes that create new instances of T class
 * @param <T> Class of created object
 */
public interface Creator<T> {
    T make();
}
