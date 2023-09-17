package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hospitalapplication.databinding.ActivityAppointmentBookingBinding;

import java.util.Calendar;

public class AppointmentBookingActivity extends AppCompatActivity {

    ActivityAppointmentBookingBinding binding;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    String dn;
    String pn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppointmentBookingBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.DocImg.setImageResource(getIntent().getExtras().getInt("Img"));
        binding.Docname.setText(getIntent().getExtras().getString("Name"));
        binding.Docdegree.setText(getIntent().getExtras().getString("Degree"));

        DBhospital dBhospital = new DBhospital(this);
        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //datepicker
        initDatePicker();
        binding.btnAppDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        //timepicker
        initTimePicker();
        binding.btnAppTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

        dn = binding.Docname.getText().toString();

        String add = binding.address.getText().toString();

        binding.BookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dBhospital.checkAppointmentExits(dn,binding.Pname.getText().toString(),add,binding.btnAppDate.getText().toString(),binding.btnAppTime.getText().toString()) == 1) {
                    Toast.makeText(AppointmentBookingActivity.this, "Appointment Already Existed...!! ", Toast.LENGTH_SHORT).show();
                } else {
                    dBhospital.addAppointment(dn,binding.Pname.getText().toString(),add,binding.btnAppDate.getText().toString(),binding.btnAppTime.getText().toString());
                    Toast.makeText(AppointmentBookingActivity.this, "Appointment Book Successfully...!!", Toast.LENGTH_SHORT).show();
                }
                }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 += 1;
                binding.btnAppDate.setText(i2 + "/" + i1 + "/" + i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);

    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                binding.btnAppTime.setText(i + ":" + i1);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = android.app.AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);
    }

}

