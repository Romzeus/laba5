package labs.util.serial;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public interface AbstractSerializer {
    String serialize(Object object);
}
