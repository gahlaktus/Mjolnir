package com.dragon.network.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by huangzhibo on 17/04/2017.
 */
public class ViewChannel {
    /**
     * FileChannel
     * DatagramChannel
     * SocketChannel
     * ServerSocketChannel
     */


    // file channel
    public void readData2Buffer() {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("data/nio-data.txt", "rw");
            FileChannel inChannel = accessFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            accessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ViewChannel vc = new ViewChannel();
        vc.readData2Buffer();
    }

}
