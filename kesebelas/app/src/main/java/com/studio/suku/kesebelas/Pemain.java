package com.studio.suku.kesebelas;

import android.os.Parcel;
import android.os.Parcelable;

public class Pemain implements Parcelable {
    private String nama, asal, photo;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.asal);
        dest.writeString(this.photo);
    }

    public Pemain() {
    }

    protected Pemain(Parcel in) {
        this.nama = in.readString();
        this.asal = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<Pemain> CREATOR = new Parcelable.Creator<Pemain>() {
        @Override
        public Pemain createFromParcel(Parcel source) {
            return new Pemain(source);
        }

        @Override
        public Pemain[] newArray(int size) {
            return new Pemain[size];
        }
    };
}
