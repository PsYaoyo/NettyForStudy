package cn.yps.NIO;

import java.nio.ByteBuffer;

/**
 * ByteBuffer 通过案例 方法使用总结
 */
public class TestByteBufferExam
{
    public static void main(String[] args)
    {
        //场景：黏包 半包
        ByteBuffer source = ByteBuffer.allocate(64);
        source.put("Hello,World\nI'm YPS\nIt's a fuc".getBytes());
        handle(source);
        source.put("king good day that will go home\n".getBytes());
        handle(source);

    }

    private static void handle(ByteBuffer source)
    {
        source.flip(); //读模式
        for (int i = 0; i < source.limit(); i++)
        {
            if (source.get(i) == '\n') //get(i) 不会切换position
            {
                int length = i - source.position() + 1;
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++)
                {
                    target.put(source.get());
                }
                //打印
                target.flip();
                System.out.println(new String(target.array()));
            }
        }
        source.compact(); //compact() 会切换position 到0 然后并把buffer中未读完的 复制到开头 position到此时位置
        //clear 是直接移到0
    }
}
