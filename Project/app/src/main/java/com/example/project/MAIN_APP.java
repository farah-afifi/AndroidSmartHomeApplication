package com.example.project;


import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MAIN_APP extends AppCompatActivity {

    Socket client;
    PrintWriter printWriter;
    Button onButton;
    EditText address;
    public static String IP = "143.53.187.19";
    public static int Port = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        onButton = (Button) findViewById(R.id.button);
        address = (EditText) findViewById(R.id.addr);

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                out.writeUTF("satrak ya rb");
                out.flush();
                out.close();
                client.close();
            }catch (UnknownHostException e){e.printStackTrace();}catch (IOException e){e.printStackTrace();}

            return "hello";

        }
    }

}
