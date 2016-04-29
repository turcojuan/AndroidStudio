package com.example.alumno.nuevoturco;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

/**
 * Created by alumno on 28/04/2016.
 */
public class myThread extends Thread{
    Handler myHander;
    HttpManager hm;

    public myThread (Handler h,String url, boolean t)
    {
     myHander = h;
     this.hm = new HttpManager(url);
}
    @Override
        public void run() {
        Message msg = new Message();
        msg.arg1 = 1;


        try {
            msg.obj = hm.getStrDataByGET(); // Pq es un xml
        } catch (IOException e) {
            e.printStackTrace();
        }

        myHander.sendMessage(msg);
        Log.d("","Esta Corriendo el Run()");

    }


}
