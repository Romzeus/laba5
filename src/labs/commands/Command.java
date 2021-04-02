package labs.commands;

public abstract class Command implements Executable{
    private final String describtion;
    private final String name;
    public Command(String name, String describtion) {
        this.name = name;
        this.describtion = describtion;
    }
    public abstract void execute();
    public final String describe() {
        return name + ": " + describtion;
    }
}
