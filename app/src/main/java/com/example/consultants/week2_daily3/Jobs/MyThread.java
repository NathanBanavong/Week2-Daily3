package com.example.consultants.week2_daily3.Jobs;

import android.util.Log;
import android.widget.ProgressBar;

import com.example.consultants.week2_daily3.MyTask;

public class MyThread extends Thread {

    //    information passed from MainActivity
    public static final String TAG = MyThread.class.getSimpleName() + "_TAG";

    ProgressBar name;
    String ThreadName = Thread.currentThread().getName();

    public MyThread(ProgressBar name) {
        this.name = name;
    }

    public void run() {
        try {
//            reference the MyTask.Start
            MyTask.start(name, ThreadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "run: " + ThreadName);
    }
}
