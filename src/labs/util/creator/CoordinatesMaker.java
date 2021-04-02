package labs.util.creator;
import labs.structures.Coordinates;
import labs.util.ArgumentParser;

public class CoordinatesMaker extends Creator<Coordinates>{
    public Coordinates make() {
        System.out.println("Введите координату x: ");
        ArgumentParser.prepare();
        long x = 140;
        while(x > 130) {
            try {
            x = Long.parseLong(ArgumentParser.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                System.out.println(exception.toString());
            }
            if(x > 130) {
                System.out.println("Координата x не может быть больше 130. Попробуйте ввести координату еще раз: ");
                ArgumentParser.prepare();
            }
        }
        System.out.println("Введите координату y: ");
        ArgumentParser.prepare();
        Long y = null;
        while(y == null) {
            try {
                y = Long.parseLong(ArgumentParser.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                System.out.println(exception.toString());
            }
            if(y == null) {
                System.out.println("Координата y не может быть пустой или не числом. Попробуйте ввести координату y еще раз: ");
                ArgumentParser.prepare();
            }
        }
        return Coordinates.CoordinatesInitializer.createCoordinates(x, y);
    }
}
