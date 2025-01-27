package cn.yps.NIO.file_program;

import cn.yps.utils.HexShowUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class TestFileChannel
{
    //FileChannel 主要用来进行文件读写操作，阻塞模式下的
    //文件操作的话 只能通过io的文件流来读取，之后使用getChannel方法获取
    //常用获取文件操作 1、FileInputStream 只读
    //2、FileOutputStream 只写
    //3、RandomAccessFile 读写 指定读写模式参数(path,mode)   mode = 'r'/'rw'
    public static void main(String[] args)
    {
        //channel的读  在bytebuffer中已经说明
        //流向：文件 --读入内存--> 文件流FileInputStream --> channel(nio) 通道 --> 缓冲区 Buffer(nio)

        //写入操作 write方法
        //同理 写操作时，channel是有写入上限的 所以可以使用 while buffer.hasRemaining()
        //流向 buffer -> channel -> 文件流FileOutputStream -> 文件
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("world");
        ByteBuffer buffer3 = StandardCharsets.UTF_8.encode("你好啊世界");//UTF-8 中文三字节
        HexShowUtils.showHexForByteBuffer(buffer1, buffer2, buffer3);
        try (FileChannel fileChannel = new RandomAccessFile("test.txt", "rw").getChannel())
        {
            long write = fileChannel.write(new ByteBuffer[] { buffer1, buffer2, buffer3 });
            System.out.println("写入长度" + write);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
