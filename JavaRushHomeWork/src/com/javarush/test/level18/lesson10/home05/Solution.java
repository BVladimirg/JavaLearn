package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        ArrayList<Double> doubles = new ArrayList<>();

        String buff = "";
        while (fileInputStream.available() > 0) {
            char nextInputChar = (char) fileInputStream.read();
            System.out.println(buff);
            if (nextInputChar == ' ') {
                doubles.add(Double.parseDouble(buff));
                buff = "";
            }
            buff += nextInputChar;
        }
        doubles.add(Double.parseDouble(buff));
        fileInputStream.close();

        String outputBuffer = "";
        for (double d : doubles) {
            int i = (int) Math.round(d);
            outputBuffer += String.valueOf(i);
            outputBuffer += " ";
        }

        byte[] b;
        b = outputBuffer.getBytes();
        System.out.println(b);

        fileOutputStream.write(b);
        fileOutputStream.close();

    }
}
