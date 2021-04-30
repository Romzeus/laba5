package labs.util.locale;

import java.util.HashMap;

/**
 * Abstract class of localization classes
 * @author Romzeus
 */
public abstract class Localization {
    private final HashMap<String, String> dictionary = new HashMap<>();

    /**
     * Method that adds new dictionary entries
     * @param token keyphrase which should be translated
     * @param localized translated phrase
     */
    public void addEntry(String token, String localized) {
        dictionary.put(token, localized);
    }

    /**
     * Method that translates given keyphrase
     * @param token keyphrase to translate
     * @return translated phrase of null if keyphrase isn't in dictionary
     */
    public String translate(String token) {
        return dictionary.get(token);
    }
}
