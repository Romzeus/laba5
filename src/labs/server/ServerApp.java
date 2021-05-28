package labs.server;

import labs.server.commands.*;
import labs.util.ArrayDequeLoader;
import labs.util.io.Receiver;
import labs.util.io.Sender;
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
    private void initCommands() {
        invoker.addCommand("add", new Add(provider));
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("filter_less_than_distance", new FilterDistance(provider));
        invoker.addCommand("get_id", new GetId());
        invoker.addCommand("head", new Head());
        invoker.addCommand("info", new Info());
        invoker.addCommand("print_descending", new PrintDescending());
        invoker.addCommand("remove", new RemoveId(provider));
        invoker.addCommand("remove_lower", new RemoveLower(provider));
        invoker.addCommand("show", new Show());
        invoker.addCommand("filter_starts_with_name", new StartsWith(provider));
        invoker.addCommand("update", new UpdateId(provider));
    }
    public void run() {
        try {
            initSocket();
            initIO();
        } catch(IOException exception) {
            socket = null;
        }
        initCommands();
        ArrayDequeLoader.setPrinter(Sender::print);
        ArrayDequeLoader.load();
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
