package labs.commands.send;

import labs.commands.tokens.ServerToken;

public class ServerMessage implements ServerMessageExecutable{
    private final ServerToken token;
    private final Object argument;
    public ServerMessage(ServerToken token) {
        this.token = token;
        argument = null;
    }
    public ServerMessage(ServerToken token, Object argument) {
        this.token = token;
        this.argument = argument;
    }
    @Override
    public Object getArguments() {
        return argument;
    }
    @Override
    public ServerToken getToken() {
        return token;
    }
}
