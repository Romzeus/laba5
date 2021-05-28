package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class Clear extends labs.commands.Clear {
    @Override
    public void execute() {
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("clear")));
    }
}
