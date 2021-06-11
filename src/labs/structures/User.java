package labs.structures;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String name;
    private String password;
    public User(String name, String password) {
        this.name = name;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            byte[] bytes = md.digest((password + "$#8800&?").getBytes(StandardCharsets.UTF_8));
            BigInteger no = new BigInteger(1, bytes);
            password = no.toString(16);
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {return name + " " + password;}
}
