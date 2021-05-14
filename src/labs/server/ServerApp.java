package labs.server;

import labs.util.io.ServerPrinter;
import labs.util.io.ServerScanner;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    private Socket socket;
    private final ServerInvoker invoker = new ServerInvoker();
    private final ObjectProvider provider = new ObjectProvider();
    private void initSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(15567);
        socket = serverSocket.accept();
    }
    private void initIO() throws IOException {
        Sender.setPrinter(new ServerPrinter(socket));
        Receiver.setScanner(new ServerScanner(socket));
    }
    public void run() {
        try {
            initSocket();
            initIO();
        } catch(IOException exception) {
            socket = null;
        }
        if(socket != null) {
            while(true) {
                try {
                    invoker.activate((String) provider.getArgument());
                } catch(NullPointerException exception) {
                    Sender.print("Incorrect command");
                }
            }
        }
    }
}
