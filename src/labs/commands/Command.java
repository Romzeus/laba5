package labs.commands;

public abstract class Command implements Executable{
    private final String description;
    private final String name;
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public abstract void execute();
    public final String describe() {
        return name + ": " + description;
    }
}
