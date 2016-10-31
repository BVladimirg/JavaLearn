package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
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

        FileOutputStream outputStreamF1 = new FileOutputStream(fileName1);
        FileInputStream inputStreamF2 = new FileInputStream(fileName2);
        FileInputStream inputStreamF3 = new FileInputStream(fileName3);

        if (inputStreamF2.available() > 0)
        {
            byte[] inBuf2 = new byte[inputStreamF2.available()];
            int res = inputStreamF2.read(inBuf2);
            outputStreamF1.write(inBuf2, 0, res);
        }
        inputStreamF2.close();

        if (inputStreamF3.available() > 0) {
            byte[] inBuf3 = new byte[inputStreamF3.available()];
            int res = inputStreamF3.read(inBuf3);
            outputStreamF1.write(inBuf3, 0, res);
        }
        inputStreamF3.close();
        outputStreamF1.close();

    }
}
