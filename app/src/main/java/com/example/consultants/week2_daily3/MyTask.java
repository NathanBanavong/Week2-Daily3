package com.example.consultants.week2_daily3;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
    static int leProgress;
    Random rand = new Random();
    private static Handler handler = new Handler(Looper.getMainLooper());
    public static final String TAG = MyTask.class.getSimpleName() + "_TAG";

//    takes in the random number for the taskProgress -> used for sleep

    public static void start(final ProgressBar determinedBar, final String threadName) throws InterruptedException {
        Random rand = new Random();
        final int ranNum = rand.nextInt(20) + 1;
        leProgress = 0;

        while (leProgress < 100) {
            leProgress += ranNum;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    determinedBar.setProgress(leProgress);
                    Log.d(TAG, "run: " + leProgress);
                }
            });
            //sleep reset the progress bar
            Thread.sleep(ranNum * 10);
        }
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            long duration = (long) (rand.nextInt() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
