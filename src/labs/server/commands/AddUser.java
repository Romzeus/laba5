package labs.server.commands;

import labs.commands.Executable;
import labs.send.ServerMessage;
import labs.server.DBService;
import labs.server.ObjectProvider;
import labs.structures.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class AddUser implements Executable {
    private ObjectProvider provider;
    public AddUser(ObjectProvider objectProvider) {
        provider = objectProvider;
    }

    @Override
    public void execute() {
        User user = ((ServerMessage)(provider.getArgument())).getUser();
        try {
            DBService.addUser(user);
        } catch (NoSuchAlgorithmException|SQLException exception) {
            return;
        }
    }
}
