package labs;
import labs.commands.Invoker;
import labs.util.ArgumentParser;
import labs.util.ArrayDequeLoader;

public class Main {
    public static void main(String[] args) {
        ArrayDequeLoader.load();
        while(true) {
            ArgumentParser.parse();
            try {
                Invoker.activate(ArgumentParser.getArgument());
            } catch(IllegalArgumentException exception) {
                System.out.println("Некорректная команда");
            }
        }
    }
}
