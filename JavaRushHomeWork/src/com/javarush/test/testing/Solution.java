package com.javarush.test.testing;


class Clock implements Runnable
{
    private volatile boolean isCancel = false;

    void cancel()
    {
        this.isCancel = true;
    }

    public void run()
    {
        while (!this.isCancel)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Tik");
        }
    }
}


public class Solution
{
    public static void main(String[] args) throws InterruptedException
    {
        Clock clock = new Clock();
        Clock clock1 = new Clock();

        Thread clockThread = new Thread(clock);
        Thread clockThread1 = new Thread(clock);

        clockThread.start();
        clockThread1.start();
        Thread.sleep(3000);

        clock1.cancel();
        Thread.sleep(10000);
        clock.cancel();
    }
}

