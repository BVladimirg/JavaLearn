package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0) {

            FileInputStream fIn = new FileInputStream(args[1]);
            FileOutputStream fOut = new FileOutputStream(args[2]);

            if (args[0].equals("-e")) {
                if (fIn.available() > 0) {
                    byte[] fInbyte = new byte[fIn.available()];
                    byte[] key = "encrypt".getBytes();

                    int count = fIn.read(fInbyte);

                    //XOR encrypting
                    for (int i = 0; i < fInbyte.length; i++)
                    {
                        fInbyte[i] ^= key[i % key.length];
                    }

                    fOut.write(fInbyte);

                    fIn.close();
                    fOut.close();
                }


            } else if (args[0].equals("-d")) {
                if (fIn.available() > 0) {
                    byte[] fInbyte = new byte[fIn.available()];
                    int count = fIn.read(fInbyte);

                    byte[] key = "encrypt".getBytes();
                    //XOR decrypting
                    for (int i = 0; i < fInbyte.length; i++)
                    {
                        fInbyte[i] ^= key[i % key.length];
                    }

                    fOut.write(fInbyte, 0, count);

                    fIn.close();
                    fOut.close();
                }
            }
        }
    }

}
