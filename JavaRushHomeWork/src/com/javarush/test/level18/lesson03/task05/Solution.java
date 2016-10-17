package com.javarush.test.level18.lesson03.task05;
/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода
Пример байт входного файла
44 83 44
Пример вывода
44 83
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        HashSet<Integer> inputBytes = new HashSet<>();

        while (inputStream.available() > 0) {
            inputBytes.add(inputStream.read());
        }
        inputStream.close();
        Set<Integer> sortedSet = new TreeSet<Integer>();

        sortedSet.addAll(inputBytes);
        for (Integer i : sortedSet) {
            System.out.print(i + " ");
        }
    }
}
