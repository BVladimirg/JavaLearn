package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        //return HashMap with all file's bytes and counts of that bytes
        HashMap<Integer, Integer> byteCount = new HashMap<Integer, Integer>();
        while (inputStream.available() > 0) {
            int byteKey = inputStream.read();
            int count = 1;
            if (byteCount.containsKey(byteKey)) {
                count = byteCount.get(byteKey) + 1;
            }
            byteCount.put(byteKey, count);
        }
        inputStream.close();

        //finds max count of bytes
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            int currentCount = entry.getValue();
            if (maxCount < currentCount) maxCount = currentCount;
        }

        //finds all bytes with value "maxCount"
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            if (entry.getValue() == maxCount) resultArr.add(entry.getKey());
        }

        for (int i : resultArr)
            System.out.print(i + " ");



    }
}
