package labs.client;

import labs.client.commands.Add;
import labs.client.commands.Clear;
import labs.client.commands.FilterDistance;
import labs.client.commands.Head;
import labs.client.commands.Info;
import labs.client.commands.PrintDescending;
import labs.client.commands.RemoveId;
import labs.client.commands.RemoveLower;
import labs.client.commands.Show;
import labs.client.commands.StartsWith;
import labs.client.commands.UpdateId;
import labs.commands.*;
import labs.util.ArgumentParser;
import labs.util.ArgumentProvider;
import labs.util.io.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Locale;

public class ClientApp {
    private SocketChannel socket;
    private final Scanner scanner = new ConsoleScanner();
    private final ArgumentProvider<String> argumentProvider = new ArgumentParser(scanner);
    private final Invoker invoker = new Invoker();
    private final Printer printer = new TranslatorPrinter(new ConsolePrinter(), new Locale("ru"));
    private void initSocket() throws IOException {
        socket = SocketChannel.open();
        socket.configureBlocking(false);
        socket.connect(new InetSocketAddress("localhost", 15568));
        socket.finishConnect();
    }
    private void initIO() {
        Sender.setPrinter(new ClientNetPrinter(socket));
        Receiver.setScanner(new ClientNetScanner(socket));
    }
    private void initCommands() {
        invoker.addCommand("add", new Add(argumentProvider));
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("exit", new Exit());
        invoker.addCommand("execute_script", new ExecuteScript(invoker, argumentProvider, printer));
        invoker.addCommand("filter_less_than_distance", new FilterDistance(argumentProvider, printer));
        invoker.addCommand("head", new Head(printer));
        invoker.addCommand("info", new Info(printer));
        invoker.addCommand("print_descending", new PrintDescending(printer));
        invoker.addCommand("remove", new RemoveId(argumentProvider, printer));
        invoker.addCommand("remove_lower", new RemoveLower(argumentProvider));
        invoker.addCommand("show", new Show(printer));
        invoker.addCommand("filter_starts_with_name", new StartsWith(argumentProvider, printer));
        invoker.addCommand("update", new UpdateId(argumentProvider, printer));
        invoker.addCommand("history", new History(printer));
        invoker.addCommand("help", new Help(invoker.getCommands().values(), printer));
    }
    public void run() {
        try {
            initSocket();
        } catch(IOException exception) {
            printer.print("connection_failure");
            socket = null;
        }
        if(socket != null) {
            initIO();
            initCommands();
            printer.print(Receiver.getArgument());
            while(true) {
                try {
                    invoker.activate(argumentProvider.getArgument());
                } catch(IllegalArgumentException exception) {
                    printer.print("Incorrect_command");
                }
            }
        }
    }
}
