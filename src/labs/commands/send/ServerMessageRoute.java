package labs.commands.send;

import labs.structures.Route;

public interface ServerMessageRoute extends ServerMessageExecutable {
    Route getArguments();
}
