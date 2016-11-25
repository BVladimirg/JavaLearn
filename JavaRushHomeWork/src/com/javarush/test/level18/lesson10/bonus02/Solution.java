package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileOutputStream out = new FileOutputStream(fileName, true);
        if (args.length > 0) {
            if (args[0].equals("-c")) {
                String outLine =
                        setStringLength(String.valueOf(getMaxId(fileName) + 1), 8)
                        + setStringLength(args[1], 30)
                        + setStringLength(args[2], 8)
                        + setStringLength(args[3], 4)
                        + "\n";
                byte[] outBytes = outLine.getBytes();
                out.write(outBytes);
            }
        }
        out.close();
    }

    public static int getMaxId(String fileName) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        int maxId = 0;
        while ((line = fileReader.readLine()) != null) {
            int id = Integer.parseInt(line.split(" ")[0]);
            if (maxId < id) {
                maxId = id;
            }
        }
        fileReader.close();
        return maxId;
    }

    public static String setStringLength(String line, int outLineLength) {
        if (line.length() > outLineLength) {
            line = line.substring(0, outLineLength);
        } else
            for (int i = 0; i < outLineLength - line.length(); i++)
            {
                line += " ";
            }
        return line;
    }
}
