package com.example.tp_rss_labov.HttpConection;

import android.os.Handler;
import android.os.Message;

public class HiloConexion extends Thread{
    Handler handler;
    String urlImg;

    public HiloConexion(Handler handler) {
        this.handler = handler;
    }

    public HiloConexion(Handler handler, String urlImg) {
        this.handler = handler;
        this.urlImg = urlImg;
    }

    @Override
    public void run() {
        HttpDataHandler httpDataHandler = new HttpDataHandler();

        String img = httpDataHandler.GetHTTPData(this.urlImg);
        Message msg = new Message();
        msg.obj = img;
        handler.sendMessage(msg);

    }

}