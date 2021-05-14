package labs.util.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientNetPrinter implements Printer{
//    private final ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
    private final SocketChannel channel;
    public ClientNetPrinter(SocketChannel channel) {
        this.channel = channel;
    }
    @Override
    public void print(String message) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
//        byteBuffer.clear();
//        byteBuffer.put(message.getBytes());
        try {
            while(byteBuffer.hasRemaining())
                channel.write(byteBuffer);
        } catch(IOException exception) {
            byteBuffer.clear();
        }
    }
}
