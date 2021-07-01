package labs.send;

public class ClientMessage {
    private final boolean rightUser;
    private String[][] data = {{" ", " ", " ", " ", " ", " ", " ", " "}};
    public ClientMessage(boolean user, String[][] arg) {
        if(arg.length > 0)
            data = arg;
        rightUser = user;
    }
    public String[][] getData() {
        return data;
    }
    public boolean isRightUser() {
        return rightUser;
    }
}
