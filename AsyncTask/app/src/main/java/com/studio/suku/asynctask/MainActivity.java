package com.studio.suku.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements AsyncCallback{

    TextView desc, status;

    final static String INPUT_STRING = "Halo Ini Demo AsyncTask!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desc = findViewById(R.id.tv_desc);
        status = findViewById(R.id.tv_status);

        DemoAsync demoAsync = new DemoAsync(this);
        demoAsync.execute(INPUT_STRING);


    }

    @Override
    public void onPreExecute() {
        status.setText("Status : onPreExecute");
        desc.setText(INPUT_STRING);
    }

    @Override
    public void onPostExecute(String str) {
        status.setText("Status onPostExecute");
        if (str != null){
            desc.setText(str);
        }
    }

    private static class DemoAsync extends AsyncTask<String, Void, String>{

        static final String LOG_ASYNC = "DemoAsync";
        WeakReference<AsyncCallback> asyncCallback;
        DemoAsync(AsyncCallback asyncCallback){
            this.asyncCallback = new WeakReference<>(asyncCallback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(LOG_ASYNC, "Status nya : onPreExecute");
            AsyncCallback asyncCallback = this.asyncCallback.get();
            if (asyncCallback != null){
                asyncCallback.onPreExecute();
            }
        }
        //Yang di lakukan di background
        @Override
        protected String doInBackground(String... strings) {
            Log.d(LOG_ASYNC, "Status nya : doInBackground");
            String output = null;

            try {
                String input = strings[0];
                output = input + "Selamat Belajar !!";
                Thread.sleep(5000);
            }
            catch (Exception e){
                Log.d(LOG_ASYNC, e.getMessage());
            }

            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(LOG_ASYNC, "status : onPostExecute");
            AsyncCallback asyncCallback = this.asyncCallback.get();
            if (asyncCallback != null){
                asyncCallback.onPostExecute(s);
            }
        }
    }
}
