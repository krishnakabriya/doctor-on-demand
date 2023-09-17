package com.example.hospitalapplication;

public class AppointmentModel
{
    private String doc_name;
    private String h_address;
    private String p_name;
    private String a_date;
    private String a_time;

    public AppointmentModel(String doc_name,String p_name,String h_address,String a_date,String a_time)
    {
        this.doc_name=doc_name;
        this.h_address=h_address;
        this.p_name=p_name;
        this.a_date=a_date;
        this.a_time=a_time;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getH_address() {
        return h_address;
    }

    public void setH_address(String h_address) {
        this.h_address = h_address;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public String getA_time() {
        return a_time;
    }

    public void setA_time(String a_time) {
        this.a_time = a_time;
    }
}
