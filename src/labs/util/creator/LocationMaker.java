package labs.util.creator;
import labs.structures.Location;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;

public class LocationMaker extends Creator<Location> {
    private final ArgumentProvider argumentProvider;
    private final Printer printer;
    public LocationMaker(ArgumentProvider argumentProvider, Printer printer) {
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    public Location make() {
        printer.print("Введите координату x пункта отправки");
        Double x = null;
        while (x == null) {
            try {
            x = Double.parseDouble(argumentProvider.getArgument());
            } catch(NullPointerException|NumberFormatException exception) {
                printer.print(exception.toString());
                x = null;
            }
            if (x == null) {
                printer.print("Координата x пункта отправки не может быть пустой или не числом. Попробуйте ввести координату x еще раз: ");
            }
        }
        printer.print("Введите координату y пункта отправки: ");
        int y;
        try {
            y = Integer.parseInt(argumentProvider.getArgument());
        } catch (NullPointerException|NumberFormatException exception) {
            printer.print(exception.toString());
            y = 0;
        }
        printer.print("Введите название пункта отправки: ");
        String name = null;
        while(name == null) {
            try {
                name = argumentProvider.getArgument();
            } catch (NullPointerException exception) {
                name = null;
            }
            if(name == null) {
                printer.print("Название пункта отправки не может быть пустым. Попробуйте ввести название еще раз: ");
            }
        }
        return new Location(x, y, name);
    }
}