package cn.yps.utils;

import java.util.Date;

public class RandomPassWordUtils
{
    public static String getRandomPassword(int length)
    {

        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        int time = date.getYear() + 1900;
        sb.append(time);
        for (int i = 0; i < length; i++)
        {
            char ch1 = (char) (35 + (int) (Math.random() * 13)); // 35-47
            char ch2 = (char) (48 + (int) (Math.random() * 17)); // 48-64
            char ch3 = (char) (65 + (int) (Math.random() * 26)); // 65-90
            char ch4 = (char) (97 + (int) (Math.random() * 26)); // 97-122
            sb.append(ch1).append(ch3).append(ch2).append(ch4);
        }
        sb.append("\r\n");
        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(getRandomPassword(3));
    }
}
