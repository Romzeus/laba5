package labs.util.serial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serializer implements AbstractSerializer{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public String serialize(Object object) {
        return gson.toJson(object);
    }
}
