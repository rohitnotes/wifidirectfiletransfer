// Copyright 2011 Google Inc. All Rights Reserved.

package com.example.hp.wifidirectimagetransfer;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * A service that process each file transfer request i.e Intent by opening a
 * socket connection with the WiFi Direct Group Owner and writing the file
 */
public class FileTransferService extends IntentService {

    private static final int SOCKET_TIMEOUT = 5000;
    public static final String ACTION_SEND_FILE = "com.example.android.wifidirect.SEND_FILE";
    public static final String EXTRAS_FILE_PATH = "file_url";
    public static final String EXTRAS_GROUP_OWNER_ADDRESS = "go_host";
    public static final String EXTRAS_GROUP_OWNER_PORT = "go_port";
    String fileUri = null;

    public FileTransferService(String name) {
        super(name);
    }

    public FileTransferService() {
        super("FileTransferService");
    }

    /*
     * (non-Javadoc)
     * @see android.app.IntentService#onHandleIntent(android.content.Intent)
     */
    @Override
    protected void onHandleIntent(Intent intent) {

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wifidata/";
        Log.d("Files", "Path: " + path);
        File f = new File(path);
        File file[] = f.listFiles();
        Log.d("Files", "Size: " + file.length);

        for (int i = 0; i < file.length; i++) {
            Log.d("Files", file[i].getName());
        }

//        Context context = getApplicationContext();
//        if (intent.getAction().equals(ACTION_SEND_FILE)) {
//
//            String host = intent.getExtras().getString(EXTRAS_GROUP_OWNER_ADDRESS);
//            Socket socket = new Socket();
//            int port = intent.getExtras().getInt(EXTRAS_GROUP_OWNER_PORT);
//
//
//
//
//            try {
//                Log.d(MainActivity.TAG, "Opening client socket - ");
//                socket.bind(null);
//                socket.connect((new InetSocketAddress(host, port)), SOCKET_TIMEOUT);
//
//                Log.d(MainActivity.TAG, "Client socket - " + socket.isConnected());
//                OutputStream stream= null;
//                InputStream is = null;
//                for (int i=0; i < file.length; i++)
//                {
//
//                    fileUri = path + file[i].getName();
//
//                    stream = socket.getOutputStream();
//                    // ContentResolver cr = context.getContentResolver();
//
//                    Log.d(MainActivity.TAG, fileUri);
//
//                    try {
//                        is = new FileInputStream(fileUri);
//                    } catch (FileNotFoundException e) {
//                        Log.d(MainActivity.TAG, e.toString());
//                        e.printStackTrace();
//                    }
//
//                    byte buf[] = new byte[1024];
//                    int len;
//                    try {
//                        while ((len = is.read(buf)) != -1) {
//                            stream.write(buf, 0, len);
//
//                        }
//                    } catch (IOException e) {
//                        Log.d(MainActivity.TAG, e.toString());
//
//                    }
//
//
//                    Log.d(MainActivity.TAG, "Client: Data written");
//                    //here populate your listview
//                    Log.d("Files", "FileName:" + file[i].getName());
//
//                }
//
//                stream.close();
//                is.close();
//
//            } catch (IOException e) {
//                Log.e(MainActivity.TAG, e.getMessage());
//            } finally {
//                if (socket != null) {
//                    if (socket.isConnected()) {
//                        try {
//                            socket.close();
//                        } catch (IOException e) {
//                            // Give up
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }

            //       }
        }
    }
