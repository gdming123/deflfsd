package com.example.admin.usbdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cn.gavinliu.android_pc_socket_connection.R;

public class MainActivity extends AppCompatActivity {
    private Button btn_action;
    private TextView TV;
    private EditText ET;
    private String lolo = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET = (EditText) findViewById(R.id.ET);
        btn_action = (Button) findViewById(R.id.btn_action);
        TV = (TextView) findViewById(R.id.TV);

        serverThread = new ServerThread();
        serverThread.start();

        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  boolean enableAdb = (Settings.Secure.getInt(getContentResolver(), Settings.Secure.ADB_ENABLED, 0) > 0);
              /*  if (!enableAdb) {
                    Toast.makeText(MainActivity.this, "请授权USB调试...", Toast.LENGTH_SHORT).show();
                    //Settings.Secure.putInt(getContentResolver(), Settings.Secure.ADB_ENABLED, 1);
                    //   Settings.Global.putInt(MainActivity.this.getContentResolver(),  Settings.Global.ADB_ENABLED, 1);
                    ComponentName componentName = new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings");
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    intent.setAction("android.intent.action.View");
                    MainActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "USB已经打开,无需重复打开", Toast.LENGTH_SHORT).show();

                }*/



            }
        });


    }

    private static final String TAG = "ServerThread";

    ServerThread serverThread;

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), msg.getData().getString("MSG", "Toast"), Toast.LENGTH_SHORT).show();
            TV.setText(lolo+ msg.getData().getString("MSG", "Toast"));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        serverThread.setIsLoop(false);
    }

    class ServerThread extends Thread {

        boolean isLoop = true;

        public void setIsLoop(boolean isLoop) {
            this.isLoop = isLoop;
        }

        @Override
        public void run() {
            Log.d(TAG, "running");

            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(9000);

                while (isLoop) {
                    Socket socket = serverSocket.accept();

                    Log.d(TAG, "accept");

                    DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                    String msg = inputStream.readUTF();

                    Message message = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString("MSG", msg);
                    message.setData(bundle);
                    handler.sendMessage(message);

                    socket.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Log.d(TAG, "destory");

                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
