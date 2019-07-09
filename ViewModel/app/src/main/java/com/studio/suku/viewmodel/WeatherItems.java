package com.studio.suku.viewmodel;
import org.json.JSONObject;
import java.text.DecimalFormat;

public class WeatherItems {

    //Setter And Getter
    private int id;
    private String name;
    private String currentWeather;
    private String description;
    private String temperature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    //This Is A Constructor To Parse JSONObject
    WeatherItems(JSONObject object){
        try {
            //Parse The Object Here
            int id = object.getInt("id");
            String name = object.getString("name");
            String currentWeather = object.getJSONArray("weather").getJSONObject(0).getString("main");
            String description = object.getJSONArray("weather").getJSONObject(0).getString("description");
            double tempKelvin = object.getJSONObject("main").getDouble("temp");
            double tempCelcius = tempKelvin - 273;
            String temperature = new DecimalFormat("##.##").format(tempCelcius);

            //And Pass it To Setter and who will later data this for RecyclerView
            this.id = id;
            this.currentWeather = currentWeather;
            this.name = name;
            this.description = description;
            this.temperature = temperature;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
