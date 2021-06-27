package labs.server;

import java.net.Socket;

public class ServerThread extends Thread{
    private final ServerApp serverApp;
    public ServerThread(Socket socket) {
        serverApp = new ServerApp(socket);
    }
    @Override
    public void run() {
        serverApp.run();
    }
}
