package labs.util.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleSelector {
    private static ResourceBundle bundle = ResourceBundle.getBundle("lab.util.locale.Language", new Locale("ru"));
    public static void changeLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("lab.util.locale.Language", locale);
    }
    public static String translate(String key) {
        return (bundle.containsKey(key) ? bundle.getString(key) : key);
    }
    public static ResourceBundle getBundle() {
        return bundle;
    }
}
