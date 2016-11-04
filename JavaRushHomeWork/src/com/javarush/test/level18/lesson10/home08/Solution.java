package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            HashMap<Integer, Integer> countsOfBytes = new HashMap<>();
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int nextByte = fileInputStream.read();
                    if (countsOfBytes.containsKey(nextByte))
                        countsOfBytes.put(nextByte, countsOfBytes.get(nextByte) + 1);
                    else
                        countsOfBytes.put(nextByte, 1);
                }
                fileInputStream.close();

                int maxCount = 0;
                int maxByte = 0;
                for (Map.Entry<Integer, Integer> entry : countsOfBytes.entrySet()) {
                    if (entry.getValue() > maxCount)
                    {
                        maxCount = entry.getValue();
                        maxByte = entry.getKey();
                    }
                }
                resultMap.put(fileName, maxByte);


            }
            catch (IOException e)
            {}


        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/