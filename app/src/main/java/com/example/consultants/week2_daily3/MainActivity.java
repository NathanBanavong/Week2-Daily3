package com.example.consultants.week2_daily3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.consultants.week2_daily3.Jobs.MyAsynctask;
import com.example.consultants.week2_daily3.Jobs.MyThread;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends Activity implements Handler.Callback {

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    Random rand;
    int numRand;    //may need to pass as string

    ProgressBar pbThread1;
    ProgressBar pbThread2;
    ProgressBar pbThread3;
    ProgressBar pbThread4;

    TextView tvAsync1;
    TextView tvAsync2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        rand = new Random();
//        pass the random number -> myThread
        numRand = rand.nextInt(10) + 1;

    }

    private void bindViews() {
        pbThread1 = findViewById(R.id.pb_thread1);
        pbThread2 = findViewById(R.id.pb_thread2);
        pbThread3 = findViewById(R.id.pb_thread3);
        pbThread4 = findViewById(R.id.pb_thread4);

        tvAsync1 = findViewById(R.id.tvAsync1);
        tvAsync2 = findViewById(R.id.tvAsync2);
    }

    //    print where thread is
    private void printCurrentThread() {
        Log.d(TAG, "oncClick: CurrentThread: " + Thread.currentThread().getName());
    }

    //    when creating threads
    public void onThreads(View view) throws InterruptedException {

        Log.d(TAG, "onThreads: ");
        MyThread thread1, thread2, thread3, thread4;
        thread1 = new MyThread(pbThread1);
        thread2 = new MyThread(pbThread2);
        thread3 = new MyThread(pbThread3);
        thread4 = new MyThread(pbThread4);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        executor.execute(thread1);
        executor.execute(thread2);
        executor.execute(thread3);
        executor.execute(thread4);

        executor.shutdown();
    }

    public void onAsyncThread(View view) {
        printCurrentThread();
        Log.d(TAG, "onAsyncThread: ");

        MyAsynctask myAsynctask1 = new MyAsynctask(tvAsync1);
        MyAsynctask myAsynctask2 = new MyAsynctask(tvAsync2);

        myAsynctask1.executeOnExecutor(MyAsynctask.THREAD_POOL_EXECUTOR);
        myAsynctask2.executeOnExecutor(MyAsynctask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

}
