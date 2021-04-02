package labs.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FileScanner implements Scanner{
    private final InputStreamReader fileStream;
    public FileScanner(String filePath) throws FileNotFoundException {
        fileStream = new InputStreamReader(new FileInputStream(new File(filePath)));
    }
    @Override
    public String scan() {
        char[] buffer = new char[256];

    }
}
