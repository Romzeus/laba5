package labs.send;

import labs.structures.Route;

public interface ServerMessageRoute extends ServerMessageExecutable {
    Route getArguments();
}
