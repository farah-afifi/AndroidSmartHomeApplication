package com.example.project;


import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class MAIN_APP extends AppCompatActivity {

    Socket client;
    PrintWriter printWriter;
    Button onButton;
    Button offButton;

    public static String IP = "143.53.189.169";
    public static int Port = 12121;

    public static String CMD = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        onButton = (Button) findViewById(R.id.button);
        offButton = (Button) findViewById(R.id.button2);
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CMD = "ON";
                Socket_AsyncTask soket = new Socket_AsyncTask();
                soket.execute();
            }

        });

        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CMD = "OFF";
                Socket_AsyncTask soket = new Socket_AsyncTask();
                soket.execute();
            }

        });
    }


    public class Socket_AsyncTask extends AsyncTask<Void,Void,String>
    {
        Socket socket;

        @Override
        public String doInBackground(Void... params){
            try{
                client = new Socket(IP,Port);

                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(CMD);
                DataInputStream in = new DataInputStream(client.getInputStream());
                final String message = (String) in.readUTF();


                Handler handler =  new Handler(getApplicationContext().getMainLooper());
                handler.post( new Runnable(){
                    public void run(){
                        Toast.makeText(getApplicationContext(), "Server response : "+message,Toast.LENGTH_SHORT).show();
                    }
                });
                out.flush();
                in.close();
                out.close();
                client.close();
            }catch (UnknownHostException e){e.printStackTrace();}catch (IOException e){e.printStackTrace();}

            return "hello";

        }
    }

}
