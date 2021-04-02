package labs.util.io;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConsolePrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
