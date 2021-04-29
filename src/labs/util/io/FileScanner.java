package labs.util.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileScanner implements labs.util.io.Scanner{
    private final InputStreamReader fileStream;
    public FileScanner(String filePath) throws FileNotFoundException {
        fileStream = new InputStreamReader(new FileInputStream(filePath));
    }
    @Override
    public String scan() {
        java.util.Scanner scanner = new Scanner(fileStream);
        String result = "";
        while(scanner.hasNext()) {
            result = result.concat(" ").concat(scanner.next());
        }
        return result;
    }
}
