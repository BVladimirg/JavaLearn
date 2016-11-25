package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            if (args[0].equals("-u")) {
                RandomAccessFile bInputStream = new RandomAccessFile(fileName, "rw");

                String inLine;
                String lineIdSought = null;
                int inLineLength = 0;

                bInputStream.length();
                while ((inLine = bInputStream.readLine()) != null) {
                    if (inLine.startsWith(args[1])) {
                        lineIdSought = inLine;
                        bInputStream.seek(inLineLength + 8);

                        break;
                    }
                    inLineLength += inLine.length();
                }
            }
        }



    }
    public static byte[] getBytesWithLength(String inputString, int length) {
        byte[] resultBytes = new byte[length];

        if (inputString.length() > length) {
            inputString = inputString.substring(0, length);
            resultBytes = inputString.getBytes();
        } else {
            resultBytes = inputString.getBytes();
            for (int i = inputString.length(); i < resultBytes.length; i++)
            {
                resultBytes[i] = 32;
            }
        }
        return resultBytes;
    }

}
