package com.example.hospitalapplication;

public class DoctorModel {
    public String dname;
    public String degree;
    public int img;

    public DoctorModel(String dname,String degree,int img)
    {
        this.dname=dname;
        this.degree=degree;
        this.img=img;
    }

    public String getDname(){return dname;}
    public void setDname(){this.dname=dname;}

    public String getDegree(){return degree;}
    public void setDegree(){this.degree=degree;}

    public int getImg(){return img;}
    public void setImg(){this.img=img;}
}
