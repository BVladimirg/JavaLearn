package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        RandomAccessFile file1 = new RandomAccessFile(fileName1, "rw");
        FileInputStream file2 = new FileInputStream(fileName2);

        if (file2.available() > 0) {
            byte[] inBuff2 = new byte[file2.available()];
            int count2 = file2.read(inBuff2);

            byte[] inBuff1 = new byte[(int)file1.length()];
            int count1 = file1.read(inBuff1);

            file1.seek(0);
            file1.write(inBuff2, 0, count2);
            file1.write(inBuff1, 0, count1);
        }
        file1.close();
        file2.close();
    }
}
