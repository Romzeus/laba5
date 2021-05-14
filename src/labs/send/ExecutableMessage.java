package labs.send;

public class ExecutableMessage implements ServerMessageExecutable{
    private String token;
    public ExecutableMessage(String token) {
        this.token = token;
    }
    @Override
    public String getToken() {
        return token;
    }
}
