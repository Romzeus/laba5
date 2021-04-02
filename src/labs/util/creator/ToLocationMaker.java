package labs.util.creator;
import labs.structures.to.Location;
import labs.util.ArgumentParser;

public class ToLocationMaker extends Creator<Location>{
    @Override
    public Location make() {
        System.out.println("Введите координату x пункта назначения: ");
        ArgumentParser.prepare();
        long x = -1;
        while(x < 0) {
            try {
                x = Long.parseLong(ArgumentParser.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                System.out.println(exception.toString());
                x = -1;
                System.out.println("Неверный формат координаты x. Попробуйте ввести координату еще раз: ");
                ArgumentParser.prepare();
            }
        }
        System.out.println("Введите координату y пункта назначения: ");
        ArgumentParser.prepare();
        Long y = null;
        while(y == null) {
            try {
                y = Long.parseLong(ArgumentParser.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                y = null;
            }
            if(y == null) {
                System.out.println("Координата y пункта назначения не может быть пустой или не числом. Попробуйте ввести координату y еще раз: ");
                ArgumentParser.prepare();
            }
        }
        System.out.println("Введите название пункта назначения: ");
        ArgumentParser.prepare();
        String name = null;
        while(name == null) {
            try {
            name = ArgumentParser.getArgument();
            } catch(NullPointerException exception) {
                name = null;
            }
            if(name == null) {
                System.out.println("Название пункта назначения не может быть пустым. Попробуйте ввести название еще раз: ");
                ArgumentParser.prepare();
            }
        }
        return Location.LocationInitializer.createLocation(x, y, name);
    }
}
