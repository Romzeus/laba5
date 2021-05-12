package labs.util.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientNetScanner implements Scanner{
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
    private final SocketChannel channel;
    public ClientNetScanner(SocketChannel channel) {
        this.channel = channel;
    }
    @Override
    public String scan() {
        byteBuffer.clear();
        try {
            channel.read(byteBuffer);
        } catch(IOException exception) {
            byteBuffer.clear();
        }
        return byteBuffer.asCharBuffer().toString();
    }
}
