package com.example.hospitalapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class DBhospital extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Hospital.db";

    public DBhospital(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table patients(name TEXT,email TEXT primary key,password TEXT,confirm_password TEXT)");
        db.execSQL("create table appointment(dname TEXT,pname TEXT,address TEXT,date TEXT,time TEXT)");
//        db.execSQL("create table appointment(dname TEXT,address TEXT,date TEXT,time TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db,int i, int j)
    {
        db.execSQL("drop Table if exists patients");
        db.execSQL("drop table if exists appointment");
    }

    public Boolean insertData(String n,String e,String pass,String confpass )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",n);
        cv.put("email",e);
        cv.put("password",pass);
        cv.put("confirm_password",confpass);
        long result = db.insert("patients",null,cv);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean checkemail(String e)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from patients where email=?",new String[]{e});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpass(String e,String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from patients where email=? and password=?",new String[]{e,p});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public void addAppointment(String dn, String pn,String add, String d, String t)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("dname", dn);
        cv.put("pname",pn);
        cv.put("address", add);
        cv.put("date", d);
        cv.put("time", t);
        db.insert("appointment",null,cv);

    }

    public void removeAppointment(String dn,String pn){
        String str[] = new String[1];
        str[0]=dn;
        str[1]=pn;
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("appointment","dname=?",str);
    }

    public int checkAppointmentExits(String dn, String pn,String add, String d, String t)
    {
        int result=0;
        String str[] = new String[5];
        str[0]= dn;
        str[1]= pn;
        str[2]= add;
        str[3]= d;
        str[4]= t;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from appointment where dname=? and pname=? and address=? and date=? and time=?",str);
        if(cursor.moveToFirst())
        {
            result=1;
        }
        return result;
    }

    public ArrayList<AppointmentModel> getAppointment()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from appointment",null);
        ArrayList<AppointmentModel> appointmentList = new ArrayList<>();
        if(cursor.moveToFirst())
        {
//            Log.d("column", "colum count :  "+cursor.getString(0)+
//                    cursor.getString(1)+
//                    cursor.getString(2)+
//                    cursor.getString(3)+
//                    cursor.getString(4));
//            ;

            do {
                appointmentList.add(new AppointmentModel(cursor.getString(0),
                                                            cursor.getString(1),
                                                            cursor.getString(2),
                                                            cursor.getString(3),
                                                            cursor.getString(4))
                );

            }while(cursor.moveToNext());
        }
        Log.d("column", "colum count :"+appointmentList.toArray().length);
        cursor.close();

        return appointmentList;
    }
}
