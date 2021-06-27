package labs.server;

import labs.util.io.ConsolePrinter;
import labs.util.io.Printer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiClientServer {
    public void run() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Printer printer = new ConsolePrinter();
        ServerSocket serverSocket = null;
        Socket socket;
        try {
            serverSocket = new ServerSocket(15567);
        } catch(IOException exception) {
            printer.print(exception.getMessage());
            return;
        }
        while(true) {
            try {
                socket = serverSocket.accept();
                executor.submit(new ServerThread(socket));
            } catch (IOException exception) {
                printer.print(exception.getMessage());
            }
        }
    }
}
