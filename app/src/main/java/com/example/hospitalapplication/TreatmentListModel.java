package com.example.hospitalapplication;

import android.widget.ImageView;

public class TreatmentListModel {
    private int img;
    private String treatment;

    public TreatmentListModel (int img,String treatment)
    {
        this.img=img;
        this.treatment=treatment;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
