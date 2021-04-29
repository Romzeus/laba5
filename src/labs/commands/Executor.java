package labs.commands;

/**
 * Interface for classes that can call command classes for execution
 * @author Romzeus
 */
public interface Executor {
    /**
     *
     * @param name Name of command
     */
    void activate(String name);
}
