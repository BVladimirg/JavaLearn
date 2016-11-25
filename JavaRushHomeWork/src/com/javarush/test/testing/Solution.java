package com.javarush.test.testing;


import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int code = 38;
        int s = 501234567;

        String buf = String.format("%010d", s);
        System.out.println(String.format("%+d(%2$s)%3$s-%4$s-%5$s", code,
                buf.substring(0, 3),
                buf.substring(3, 6),
                buf.substring(6, 8),
                buf.substring(8)
        ));

    }
}

