package labs.util.io;

import java.io.IOException;
import java.net.Socket;

public class ServerScanner implements Scanner{
    private java.util.Scanner scanner;
    public ServerScanner(Socket socket) throws IOException {
        scanner = new java.util.Scanner(socket.getInputStream());
    }
    @Override
    public String scan() {
        return scanner.nextLine();
    }
}
