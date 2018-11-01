package com.example.consultants.week2_daily3.Jobs;

import android.os.Handler;
import android.util.Log;

import static com.example.consultants.week2_daily3.MyTask.TAG;

public class MyRunnable implements Runnable{

    int iterations;
    int ranNum;
    Handler handler;


    public MyRunnable(int iterations, int ranNum, Handler handler) {
        this.iterations = iterations;
        this.ranNum = ranNum;
        this.handler = handler;
    }


    //    Need to work on this class
    @Override
    public void run() {

        Log.d(TAG, "run: ");

    }
}
