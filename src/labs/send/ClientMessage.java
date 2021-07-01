package labs.send;

public class ClientMessage {
    private final boolean rightUser;
    private String[][] data = {{" ", " ", " ", " ", " ", " ", " ", " "}};
    private String message;
    public ClientMessage(boolean user, String[][] arg) {
        if(arg.length > 0)
            data = arg;
        rightUser = user;
    }
    public ClientMessage setMessage(String message) {
        this.message = message;
        return this;
    }
    public String[][] getData() {
        return data;
    }
    public boolean isRightUser() {
        return rightUser;
    }
}
