package cn.yps.NIO;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestByteBufferString
{
    public static void main(String[] args)
    {
        //1 字符串转byteBuffer
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(16);
        byteBuffer1.put("abcd1234".getBytes());

        //2 Charset
        ByteBuffer byteBuffer2 = StandardCharsets.UTF_8.encode("abcd1234");

        //3 wrap
        ByteBuffer byteBuffer3 = ByteBuffer.wrap("abcd1234".getBytes());
        System.out.println((char)byteBuffer3.get());

        // 转化为字符串
        String string = StandardCharsets.UTF_8.decode(byteBuffer2).toString();
        System.out.println(string); //不需要操作flip buffer2  buffer3 都是直接切换到读模式的

        byteBuffer1.flip();  //buffer1需要加上flip() 因为put的时候还是在写模式
        String string1 = StandardCharsets.UTF_8.decode(byteBuffer1).toString();
        System.out.println(string1);
    }
}
