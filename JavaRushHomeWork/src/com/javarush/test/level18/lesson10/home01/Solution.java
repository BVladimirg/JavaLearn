package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count = 0;
        if (args.length > 0)
        {
            FileInputStream inputStream = new FileInputStream(args[0]);

            while (inputStream.available() > 0)
            {
                Character cData = Character.toLowerCase((char) inputStream.read());
                if (cData >= 'a' && cData <= 'z')
                {
                    count++;
                }
            }
            System.out.println(count);
            inputStream.close();
        }
    }
}
