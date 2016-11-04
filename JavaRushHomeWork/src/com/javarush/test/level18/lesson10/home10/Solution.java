package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        TreeSet<File> files = new TreeSet<>();

        while (!(fileName = reader.readLine()).equals("end")) {
            files.add(new File(fileName));
        }
        reader.close();

        Iterator<File> itr = files.iterator();

        String outputFileName = itr.next().getAbsolutePath();
        outputFileName = outputFileName.substring(0, outputFileName.length() - 6);

        FileOutputStream outputStream = new FileOutputStream(outputFileName, true);
        for (File f : files) {
            FileInputStream fileInputStream = new FileInputStream(f);
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int readByteCount = fileInputStream.read(buffer);
                outputStream.write(buffer, 0, readByteCount);
            }
            fileInputStream.close();
        }
        outputStream.close();

    }
}
