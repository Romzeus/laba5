package labs.util.creator;
import labs.structures.Location;
import labs.util.ArgumentParser;

public class LocationMaker extends Creator<Location> {
    public Location make() {
        System.out.println("Введите координату x пункта отправки");
        ArgumentParser.prepare();
        Double x = null;
        while (x == null) {
            try {
            x = Double.parseDouble(ArgumentParser.getArgument());
            } catch(NullPointerException|NumberFormatException exception) {
                System.out.println(exception.toString());
                x = null;
            }
            if (x == null) {
                System.out.println("Координата x пункта отправки не может быть пустой или не числом. Попробуйте ввести координату x еще раз: ");
                ArgumentParser.prepare();
            }
        }
        System.out.println("Введите координату y пункта отправки: ");
        ArgumentParser.prepare();
        int y;
        try {
            y = Integer.parseInt(ArgumentParser.getArgument());
        } catch (NullPointerException|NumberFormatException exception) {
            System.out.println(exception.toString());
            y = 0;
        }
        System.out.println("Введите название пункта отправки: ");
        String name = null;
        ArgumentParser.prepare();
        while(name == null) {
            try {
                name = ArgumentParser.getArgument();
            } catch (NullPointerException exception) {
                name = null;
            }
            if(name == null) {
                System.out.println("Название пункта отправки не может быть пустым. Попробуйте ввести название еще раз: ");
                ArgumentParser.prepare();
            }
        }
        return Location.LocationInitializer.createLocation(x, y, name);
    }
}