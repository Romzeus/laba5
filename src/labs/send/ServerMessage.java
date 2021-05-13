package labs.send;

import labs.tokens.ServerToken;

public class ServerMessage implements ServerMessageObject{
    private final ServerToken serverToken;
    private final Object object;
    public ServerMessage(ServerToken token, Object object) {
        this.serverToken = token;
        this.object = object;
    }
    @Override
    public ServerToken getToken() {
        return serverToken;
    }
    @Override
    public Object getArgument() {
        return object;
    }
}
