package labs.server;

import labs.structures.Route;
import labs.structures.User;
import labs.util.io.Printer;
import labs.util.io.Sender;
import java.sql.*;

public class DBService {
    private static final Printer printer = Sender::print;
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/pg";
    private static final String USER = "s289916";
    private static final String PASS = "taj026";
    private static Connection connection;
    public static void initDBConnection() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            printer.print("JDBC Driver is not found");
            return;
        }
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            printer.print("Connection Failed");
        }
    }
    public static void putEntry(Route route) {
        PreparedStatement entryPutter = null;
        try {
            entryPutter = connection.prepareStatement("INSERT INTO ROUTES (ID, NAME, TIME, DISTANCE, XCOORDINATES, " +
                    "YCOORDINATES, LOCATIONNAME, XLOCCOOR, YLOCCOOR, USER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch(SQLException exception) {
            printer.print("Something gone wrong");
            return;
        }
    }
    public static ResultSet getEntry(int id) {
        PreparedStatement entryGetter = null;
        try {
            entryGetter = connection.prepareStatement("SELECT * FROM ROUTES WHERE ID=?");
            entryGetter.setInt(1, id);
            return entryGetter.executeQuery();
        } catch(SQLException e) {
            return null;
        }
    }
    public static void addUser(User user) {
        PreparedStatement newUserEntry = null;
        try {
            newUserEntry = connection.prepareStatement("INSERT INTO USERS (USER, PASSWORD) VALUES (?, ?)");
            newUserEntry.setString(1, user.getName());
            newUserEntry.setString(2, user.getPassword());
            newUserEntry.executeQuery();
        } catch(SQLException e) {
            printer.print("Something gone wrong");
        }
    }
    public static boolean checkUser(User user) {
        PreparedStatement checkUser = null;
        int count;
        try {
            checkUser = connection.prepareStatement("SELECT COUNT(*) FROM USERS WHERE USER=? AND PASSWORD=?");
            checkUser.setString(1, user.getName());
            checkUser.setString(2, user.getPassword());
            ResultSet result = checkUser.executeQuery();
            count = (Integer)(result.getInt(1));
        } catch(SQLException e) {
            printer.print("Something gone wrong");
            return false;
        }
        return count > 0;
    }
}
