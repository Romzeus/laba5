package labs.util.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ClientNetScanner implements Scanner{
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(3000);
    private final SocketChannel channel;
    public ClientNetScanner(SocketChannel channel){
        this.channel = channel;
    }
    @Override
    public String scan() {
        byteBuffer.clear();
        int read = 0;
        try {
            while(read<=0)
                read = channel.read(byteBuffer);
        } catch(IOException exception) {
            byteBuffer.clear();
            return exception.getMessage();
        }
//        if(read == -1)
//            return " ";
        return StandardCharsets.UTF_8.decode(byteBuffer).toString().trim();
    }
}
