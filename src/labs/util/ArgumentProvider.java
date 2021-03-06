package labs.util;

import java.util.Deque;

/**
 * Interface for classes that provide arguments for different parts of program
 * @author Romzeus
 */
public interface ArgumentProvider {
    /**
     * Method that returns next argument
     * @return String argument
     */
    String getArgument();

    /**
     * Method that tells are there arguments left
     * @return True if there are arguments left; otherwise false
     */
    boolean hasNext();

    /**
     * Method that allows to get arguments from another ArgumentProvider instance
     * @param arguments arguments from different ArgumentProvider instance
     */
    void addArguments(Deque<String> arguments);

    /**
     * Method that allows to show arguments
     * @return String Deque of arguments
     */
    Deque<String> getAll();
}
