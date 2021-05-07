package labs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    public static void main(String[] args) {
        try {
            server = new ServerSocket(15567);
            socket = server.accept();
        } catch(IOException exception) {

        }
    }
}
