package com.javarush.test.testing;

public class Table {
    private static byte tableNumber;
    private byte number = tableNumber++;

   Table() {
       System.out.println("eah: " + number + ", tnum: " + tableNumber);
   }
}
