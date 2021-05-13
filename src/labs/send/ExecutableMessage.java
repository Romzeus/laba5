package labs.send;

import labs.tokens.ServerToken;

public class ExecutableMessage implements ServerMessageExecutable{
    private ServerToken token;
    public ExecutableMessage(ServerToken token) {
        this.token = token;
    }
    @Override
    public ServerToken getToken() {
        return token;
    }
}
