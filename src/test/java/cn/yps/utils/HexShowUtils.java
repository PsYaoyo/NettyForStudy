package cn.yps.utils;

import java.nio.ByteBuffer;

public class HexShowUtils
{
    /**
     * 将bytebuffer 转成16进制字符串
     *
     * @param byteBuffers
     */
    public static void showHexForByteBuffer(ByteBuffer... byteBuffers)
    {
        for (ByteBuffer byteBuffer : byteBuffers)
        {
            for(int i = 0; i < byteBuffer.limit(); i++)
            {//不使用hasRemaining() 和 get() 防止position移动 影响 操作
             // 且不用管bytebuffer的读模式还是写模式
                System.out.print(Integer.toHexString(byteBuffer.get(i) & 0xff) + " ");
            }
        }
        System.out.println();
    }
}
