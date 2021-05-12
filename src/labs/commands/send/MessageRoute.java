package labs.commands.send;

import labs.commands.tokens.ServerToken;
import labs.structures.Route;

public class MessageRoute extends ExecutableMessage implements ServerMessageRoute {
    private final Route argument;
    public MessageRoute(ServerToken token, Route argument) {
        super(token);
        this.argument = argument;
    }
    @Override
    public Route getArguments() {
        return argument;
    }
}
