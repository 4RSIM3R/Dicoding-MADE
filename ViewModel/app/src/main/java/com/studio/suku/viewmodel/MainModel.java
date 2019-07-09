package com.studio.suku.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainModel extends ViewModel {

    private String key = "8b7635437c078245de62cd6d768cc41e";
    private MutableLiveData<ArrayList<WeatherItems>> listWeathers = new MutableLiveData<>();

    void setWeather(final String cities){
        //To Get Data From Api
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<WeatherItems> listItems = new ArrayList<>();
        String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" + key;

        //Request
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    //Log.d("MainActicty", result);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("list");
                    for ( int i = 0; i < list.length(); i++ ){
                        JSONObject weather = list.getJSONObject(i);
                        WeatherItems weatherItems = new WeatherItems(weather);
                        listItems.add(weatherItems);
                    }
                    listWeathers.postValue(listItems);
                }catch (Exception e){
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage() + statusCode);
            }
        });
    }

    LiveData<ArrayList<WeatherItems>> getWeathers(){
        return listWeathers;
    }

}
