package labs.commands.send;

import labs.commands.tokens.ServerToken;

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
