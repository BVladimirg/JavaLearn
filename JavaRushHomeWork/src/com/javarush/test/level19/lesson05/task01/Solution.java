package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        Boolean flagChet = false;

        while (fileReader.ready()) {
            int nextInChar = fileReader.read();
            if (flagChet) {
                fileWriter.write(nextInChar);
                flagChet = false;
                continue;
            }
            flagChet = true;
        }

        fileReader.close();
        fileWriter.close();

    }
}
