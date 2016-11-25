package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);

        int count = 0;
        while (fileReader.ready()) {
            char isWChar = (char) fileReader.read();
            if (isWChar == 'w') {
                char[] isOrldChars = new char[4];
                fileReader.read(isOrldChars);
                if (isOrldChars.toString().equals("orld")) {
                    count++;
                }
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
