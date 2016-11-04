package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0) {
            FileInputStream inputStream = new FileInputStream(args[0]);
            if (inputStream.available() > 0) {
                byte[] inBuffer = new byte[inputStream.available()];
                inputStream.read(inBuffer);

                Arrays.sort(inBuffer);

                LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();
                for (byte b : inBuffer)
                {
                    char charB = (char) b;
                    if (result.containsKey(charB)) {
                        result.put(charB, result.get(charB) + 1);
                    } else
                        result.put(charB, 1);
                }

                for (Map.Entry<Character, Integer> entry : result.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
            inputStream.close();
        }
    }
}
