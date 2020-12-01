package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static android.view.View.*;

public class MAIN_APP extends AppCompatActivity {

    Button onButton;
    EditText address;
    public static String IP = "";
    public static int Port = 12354;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        onButton = (Button) findViewById(R.id.button);
        address = (EditText) findViewById(R.id.addr);

        onButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getIPandPort();
                Soket soket = new Soket();
                soket.execute();
            }

        });
    }

    public void getIPandPort(){
        String s = address.getText().toString();
    }
    public class Soket extends AsyncTask<String, Void,Void> {

        Socket socket;
        @Override
        protected Void doInBackground(String... strings) {
            try{
                InetAddress inet = InetAddress.getByName(IP);
                socket = new java.net.Socket(inet, Port);
                DataOutputStream dataOutputStream= new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeBytes("hello?");
                dataOutputStream.close();
                socket.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}