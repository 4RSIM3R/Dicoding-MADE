package com.studio.suku.asynctask;

public interface AsyncCallback {

    void onPreExecute();
    void onPostExecute(String str);
}
