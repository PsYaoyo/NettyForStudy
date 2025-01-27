package cn.yps.NIO.file_program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestTransferTo
{
    public static void main(String[] args)
    {
        try(
                FileChannel from = new FileInputStream("test.txt").getChannel();
                FileChannel to = new FileOutputStream("to.txt").getChannel()
        ){
            //比文件输入输出流写入更快 底层调用的是操作系统的零拷贝技术
            //最大传输2g 超过会被截断丢失  可loop处理
            long write = from.transferTo(0, from.size(), to);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
