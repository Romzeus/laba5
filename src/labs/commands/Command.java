package labs.commands;

/**
 * Abstract class for all of commands, that have description for help command
 * @author Romzeus
 */
public abstract class Command implements Executable{
    private final String description;
    private final String name;

    /**
     *Constructor of Command object
     * @param name Name of command
     * @param description Description of command
     */
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public abstract void execute();
    public final String describe() {
        return description;
    }
    public final String toString(){
        return name;
    }
}
