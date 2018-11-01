package com.example.consultants.week2_daily3.Jobs;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyAsynctask extends AsyncTask<String, Integer, String > {

    public static final String TAG = MyAsynctask.class.getSimpleName() + "_TAG";

    TextView tvAsync;

    public MyAsynctask(TextView tvAsync) {
        this.tvAsync = tvAsync;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
        tvAsync.setText("Task Starting");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
//        Ways to displays the values in thread
        tvAsync.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
        Log.d(TAG, "onPostExecute: Result:" + s);
        tvAsync.setText("Task Completed");
    }


    @Override
    protected String doInBackground(String... strings) {
        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Background Task Results";
    }



}
