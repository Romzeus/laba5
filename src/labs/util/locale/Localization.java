package labs.util.locale;

import java.util.HashMap;

public abstract class Localization {
    private final HashMap<String, String> dictionary = new HashMap<>();
    public void addEntry(String token, String localized) {
        dictionary.put(token, localized);
    }
    public String translate(String token) {
        return dictionary.get(token);
    }
}
