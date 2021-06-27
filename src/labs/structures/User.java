package labs.structures;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class User {
    private final String textSalt;
    private final String name;
    private String password;
    public User(String name, String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        textSalt = new String(salt);
        this.name = name;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            byte[] bytes = md.digest((password + textSalt).getBytes(StandardCharsets.UTF_8));
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
    public String getSalt() {
        return textSalt;
    }
    @Override
    public String toString() {return name + " " + password;}
}
