package labs.util.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerPrinter implements Printer{
    private final PrintWriter printWriter;
    public ServerPrinter(Socket socket) throws IOException {
        printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
    }
    @Override
    public void print(String message) {
        printWriter.println(message);
    }
}
