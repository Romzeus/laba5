package labs.server;

import labs.structures.Route;
import labs.structures.User;
import java.sql.*;

public class DBService {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/pg";
    private static final String USER = "s289916";
    private static final String PASS = "taj026";
    private static Connection connection;
    public static void initDBConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    public static void putEntry(Route route) {
        PreparedStatement entryPutter = null;
        try {
            entryPutter = connection.prepareStatement("INSERT INTO ROUTES (ID, NAME, TIME, DISTANCE, XCOORDINATES, " +
                    "YCOORDINATES, LOCATIONNAME, XLOCCOOR, YLOCCOOR, USER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            entryPutter.setString(2, route.getName());

        } catch(SQLException exception) {
//            printer.print("Something gone wrong");
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
    public static void addUser(User user) throws SQLException{
        PreparedStatement newUserEntry = null;
        newUserEntry = connection.prepareStatement("INSERT INTO USERS (USER, PASSWORD, SALT) VALUES (?, ?, ?)");
        newUserEntry.setString(1, user.getName());
        newUserEntry.setString(2, user.getPassword());
        newUserEntry.setString(3, user.getSalt());
        newUserEntry.executeQuery();
    }
    public static boolean checkUser(User user) {
        PreparedStatement checkUser;
        int count;
        try {
            checkUser = connection.prepareStatement("SELECT COUNT(*) FROM USERS WHERE USER=? AND PASSWORD=? AND SALT=?");
            checkUser.setString(1, user.getName());
            checkUser.setString(2, user.getPassword());
            checkUser.setString(3, user.getSalt());
            ResultSet result = checkUser.executeQuery();
            count = result.getInt(1);
        } catch(SQLException e) {
            return false;
        }
        return count > 0;
    }
}
