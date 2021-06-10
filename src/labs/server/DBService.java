package labs.server;

import labs.util.io.Printer;
import labs.util.io.Sender;

import java.sql.*;

public class DBService {
    private static Printer printer = Sender::print;
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/pg";
    private static final String USER = "s289916";
    private static final String PASS = "taj026";
    private static Connection connection;
    private static PreparedStatement entryGetter;
    private static PreparedStatement entryPutter;
    public static void initDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            printer.print("JDBC Driver is not found");
            return;
        }
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            entryGetter = connection.prepareStatement("SELECT * FROM ROUTES WHERE ID=?");
            entryPutter = connection.prepareStatement("INSERT INTO ROUTES (ID, TIME) VALUES (?, ?)");
        } catch (SQLException e) {
            printer.print("Connection Failed");
        }
    }
    public static ResultSet getEntry(int id) {
        try {
            entryGetter.setInt(1, id);
            return entryGetter.executeQuery();
        } catch(SQLException e) {
            return null;
        }
    }
}
