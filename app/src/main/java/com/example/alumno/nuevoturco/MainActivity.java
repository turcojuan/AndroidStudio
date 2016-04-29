package com.example.alumno.nuevoturco;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler h = new Handler(this);
        myThread t = new myThread(h,"http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml",true);
        t.start();

    }
        @Override
        public boolean handleMessage(Message msg) {
// Aca se reciben los mensajes

            if(msg.arg1 == 1) {
                Log.d("Roman","Riquelme");
                TextView tv =(TextView)findViewById(R.id.miTextView);
                tv.setText(msg.obj.toString());
                return false;
            }
            if(msg.arg1 == 2)
            {
                byte[]bytes = (byte [])msg.obj;
                ImageView iv;
                iv.setImageBitmap(BitmapFactory.decodeByteArray(bytes,0, bytes.length));



                return false;}
            else
            return true;
        }







}
