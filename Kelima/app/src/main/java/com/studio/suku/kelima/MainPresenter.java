package com.studio.suku.kelima;

public class MainPresenter {
    private MainView view;

    MainPresenter(MainView view){
        this.view = view;
    }

    public double volume(double panjang, double tinggi, double lebar){
        return panjang * lebar * tinggi;
    }

    public void calculateVolume(double panjang, double tinggi, double lebar){
        double volume = volume(panjang, tinggi, lebar);
        MainModel model = new MainModel(volume);
        view.showVolume(model);
    }
}
