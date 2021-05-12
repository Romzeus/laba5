package labs.util.serial;

public interface Deserializer<T> {
    T deserialize(String serializedObject);
}
