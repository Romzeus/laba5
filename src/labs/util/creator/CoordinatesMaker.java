package labs.util.creator;
import labs.structures.Coordinates;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;

/**
 * Class for creating new Coordinates objects from user input
 * @author Romzeus
 */
public class CoordinatesMaker implements Creator<Coordinates>{
    private ArgumentProvider argumentProvider;
    private Printer printer;

    /**
     * Constructor for CoordinatesMaker object
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments for creating Coordinates
     * @param printer Object of Printer interface
     */
    public CoordinatesMaker(ArgumentProvider argumentProvider, Printer printer) {
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }

    /**
     * Method that creates new Coordinates objects
     * @return Coordinates object
     */
    public Coordinates make() {
        printer.print("Введите координату x: ");
        long x = 140;
        while(x > 130) {
            try {
            x = Long.parseLong(argumentProvider.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                printer.print(exception.toString());
            }
            if(x > 130) {
                printer.print("Координата x не может быть больше 130. Попробуйте ввести координату еще раз: ");
            }
        }
        printer.print("Введите координату y: ");
        Long y = null;
        while(y == null) {
            try {
                y = Long.parseLong(argumentProvider.getArgument());
            } catch (NullPointerException|NumberFormatException exception) {
                printer.print(exception.toString());
            }
            if(y == null) {
                printer.print("Координата y не может быть пустой или не числом. Попробуйте ввести координату y еще раз: ");
            }
        }
        return new Coordinates(x, y);
    }
}
