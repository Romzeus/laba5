package labs.commands;

import labs.structures.Coordinates;
import labs.structures.Location;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.creator.CoordinatesMaker;
import labs.util.creator.LocationMaker;
import labs.util.io.Printer;

import java.util.Iterator;

public class UpdateId extends Command{
    private final ArgumentProvider argumentProvider;
    private final Printer printer;
    public UpdateId(ArgumentProvider argumentProvider, Printer printer) {
        super("update", "Обновляет значение элемента с заданным id");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        int id = Integer.parseInt(argumentProvider.getArgument());
        Iterator<Route> route = ArrayDequeManager.getArrayDeque().iterator();
        Route current;
        while(route.hasNext()) {
            current = route.next();
            if(current.getId() == id){
                printer.print("Введите имя:");
                String name = argumentProvider.getArgument();
                printer.print("Создание объекта координат");
                Coordinates coordinates = new CoordinatesMaker(argumentProvider, printer).make();
                Location location = new LocationMaker(argumentProvider, printer).make();
                float distance;
                try{
                    distance = Float.parseFloat(argumentProvider.getArgument());
                } catch(NullPointerException exception) {
                    printer.print("Дистанция не может быть такой. Устанавливается минимальное значение 1");
                    distance = 1f;
                }
                current.remake(name, coordinates, location, distance);
            }
        }
        printer.print("Объект не найден");
    }
}
