package com.example.consultants.week2_daily3.Utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class HandlerUtils {

    public static void sendMessage(Handler handler, int value) {
        Bundle bundle = new Bundle();
        Message message = new Message();
        bundle.getString("value", "someValue");
        message.setData(bundle);
        handler.sendMessage(message);
    }

    public static String getString(Message message) {
        return message.getData().getString("value");
    }

}
