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
import labs.util.locale.RussianLocalization;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientApp {
    private SocketChannel socket;
    private final Scanner scanner = new ConsoleScanner();
    private final ArgumentProvider<String> argumentProvider = new ArgumentParser(scanner);
    private final Invoker invoker = new Invoker();
    private final Printer printer = new TranslatorPrinter(new ConsolePrinter(), new RussianLocalization());
    private Printer netPrinter;
    private Scanner netScanner;
    private final ArgumentProvider<String> netProvider = new ArgumentParser(netScanner);
    private void initSocket() throws IOException {
        socket = SocketChannel.open();
        socket.configureBlocking(false);
        socket.connect(new InetSocketAddress("localhost", 15567));
        socket.finishConnect();
    }
    private void initIO() {
        netPrinter = new ClientNetPrinter(socket);
        netScanner = new ClientNetScanner(socket);
    }
    private void initCommands() {
        invoker.addCommand("add", new Add(argumentProvider, netPrinter));
        invoker.addCommand("clear", new Clear(netPrinter));
        invoker.addCommand("exit", new Exit());
        invoker.addCommand("execute_script", new ExecuteScript(invoker, argumentProvider, printer));
        invoker.addCommand("filter_less_than_distance", new FilterDistance(argumentProvider, printer, netPrinter, netProvider));
        invoker.addCommand("head", new Head(printer, netPrinter, netProvider));
        invoker.addCommand("info", new Info(printer, netPrinter, netProvider));
        invoker.addCommand("print_descending", new PrintDescending(printer, netPrinter, netProvider));
        invoker.addCommand("remove", new RemoveId(argumentProvider, printer, netPrinter));
        invoker.addCommand("remove_lower", new RemoveLower(argumentProvider, netPrinter));
        invoker.addCommand("show", new Show(printer, netPrinter, netProvider));
        invoker.addCommand("filter_starts_with_name", new StartsWith(argumentProvider, printer, netPrinter, netProvider));
        invoker.addCommand("update", new UpdateId(argumentProvider, printer, netPrinter));
        invoker.addCommand("history", new History(printer));
        invoker.addCommand("help", new Help(invoker.getCommands().values(), printer));
    }
    public void run() {
        try {
            initSocket();
        } catch(IOException exception) {
            printer.print("connection failure");
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
                    printer.print("Incorrect command");
                }
            }
        }
    }
}
