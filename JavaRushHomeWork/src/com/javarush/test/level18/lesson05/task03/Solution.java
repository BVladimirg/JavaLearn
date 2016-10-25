package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);

        int bytesAvailable = fileInputStream1.available();
        if (bytesAvailable > 0) {

            byte[] buffer1;
            byte[] buffer2;
            if (bytesAvailable % 2 == 0)
                buffer1 = new byte[bytesAvailable/2];
              else
                buffer1 = new byte[bytesAvailable/2 + 1];
            buffer2 = new byte[bytesAvailable/2];

            //Запись в первый файл
            int countBuff = fileInputStream1.read(buffer1);
            fileOutputStream2.write(buffer1, 0, countBuff);

            //Запись во второй файл
            countBuff = fileInputStream1.read(buffer2);
            fileOutputStream3.write(buffer2, 0, countBuff);
        }

        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}
