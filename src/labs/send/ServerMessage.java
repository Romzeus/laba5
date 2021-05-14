package labs.send;


public class ServerMessage implements ServerMessageObject{
    private final String serverToken;
    private final Object object;
    public ServerMessage(String token, Object object) {
        this.serverToken = token;
        this.object = object;
    }
    @Override
    public String getToken() {
        return serverToken;
    }
    @Override
    public Object getArgument() {
        return object;
    }
}
