package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
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

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);

        if (inputStream.available() > 0) {
            byte[] inputBuffer = new byte[inputStream.available()];
            int countBytes = inputStream.read(inputBuffer);

            for (int i = inputBuffer.length-1; i >= 0; i--) {
                outputStream.write(inputBuffer[i]);
            }

        inputStream.close();
        outputStream.close();
        }

    }
}
