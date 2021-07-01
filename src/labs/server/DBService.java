package labs.server;

import labs.structures.Route;
import labs.structures.User;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DBService {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:15567/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "zxc00ZXC";
    private static Connection connection;
    public static void initDBConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    public static void putEntry(Route route) {
        PreparedStatement entryPutter = null;
        try {
            entryPutter = connection.prepareStatement("INSERT INTO ROUTES (NAME, TIME, DISTANCE, XCOORDINATES, " +
                    "YCOORDINATES, LOCATIONNAME, XLOCCOOR, YLOCCOOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            entryPutter.setString(1, route.getName());
            entryPutter.setDate(2, Date.valueOf(route.getCreationDate()));
            entryPutter.setFloat(3, route.getDistance());
            entryPutter.setLong(4, route.getCoordinates().getX());
            entryPutter.setLong(5, route.getCoordinates().getY());
            entryPutter.setString(6, route.getLocation().getName());
            entryPutter.setDouble(7, route.getLocation().getX());
            entryPutter.setInt(8, route.getLocation().getY());
            entryPutter.executeQuery();
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
    public static ResultSet getRoutes() {
        Statement getter = null;
        try {
            return getter.executeQuery("SELECT * FROM ROUTES");
        } catch(SQLException exception) {
            return null;
        }
    }
    public static void addUser(User user) throws SQLException, NoSuchAlgorithmException{
        PreparedStatement newUserEntry = null;
        String hashedPassword;
        MessageDigest md = MessageDigest.getInstance("SHA-224");
        byte[] bytes = md.digest((user.getPassword() + user.getSalt()).getBytes(StandardCharsets.UTF_8));
        BigInteger no = new BigInteger(1, bytes);
        hashedPassword = no.toString(16);
        newUserEntry = connection.prepareStatement("INSERT INTO USERS (USER, PASSWORD, SALT) VALUES (?, ?, ?)");
        newUserEntry.setString(1, user.getName());
        newUserEntry.setString(2, hashedPassword);
        newUserEntry.setString(3, user.getSalt());
        newUserEntry.executeQuery();
    }
    public static boolean checkUser(User user) {
        PreparedStatement checkUser;
        String hashedPassword;
        String salt;
        String password;
        try {
            checkUser = connection.prepareStatement("SELECT PASSWORD, SALT FROM USERS WHERE USER=?");
            checkUser.setString(1, user.getName());
            ResultSet result = checkUser.executeQuery();
            password = result.getString(1);
            salt = result.getString(2);
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            byte[] bytes = md.digest((password + salt).getBytes(StandardCharsets.UTF_8));
            BigInteger no = new BigInteger(1, bytes);
            hashedPassword = no.toString(16);
        } catch(SQLException|NoSuchAlgorithmException e) {
            return false;
        }
        return user.getPassword().equals(hashedPassword);
    }
    public static void delete(int id) {
        PreparedStatement del;
        try {
            del = connection.prepareStatement("DELETE FROM ROUTES WHERE ID=?");
            del.setInt(1, id);
        } finally {
            return;
        }
    }
}
