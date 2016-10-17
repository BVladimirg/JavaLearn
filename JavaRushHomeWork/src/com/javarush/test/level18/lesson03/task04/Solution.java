package com.javarush.test.level18.lesson03.task04;

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

        int maxCount = 0;
        while (inputStream.available() > 0) {
            int byteKey = inputStream.read();
            int count = 1;
            if (byteCount.containsKey(byteKey)) {
                count = byteCount.get(byteKey) + 1;
                if (maxCount < count) maxCount = count;
            }
            byteCount.put(byteKey, count);
        }
        inputStream.close();

        int minCount = maxCount;
        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            int currentCount = entry.getValue();
            if (currentCount < minCount) minCount = currentCount;
        }

        //finds all bytes with value "maxCount"
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            if (entry.getValue() == minCount) resultArr.add(entry.getKey());
        }

        for (int i : resultArr)
            System.out.print(i + " ");
    }
}
