package labs.util.io;

import labs.send.ServerMessage;
import labs.util.serial.GsonDeserializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.CharBuffer;

public class ServerScanner implements Scanner{
    private final GsonDeserializer deserializer = new GsonDeserializer();
    private final CharBuffer charBuffer = CharBuffer.allocate(1000);
    private final BufferedReader reader;
    public ServerScanner(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    @Override
    public String scan() {
        charBuffer.clear();
        int read = 0;
        try {
            read = reader.read(charBuffer);
        } catch(IOException exception) {
            charBuffer.clear();
            charBuffer.put(" ");
        } finally {
            if(read == -1) {
                charBuffer.clear();
                charBuffer.put(" ");
            }
        }
        charBuffer.flip();
        return charBuffer.toString().trim();
    }
    public ServerMessage getServerMessage() {
        return deserializer.deserialize(scan());
    }
}
