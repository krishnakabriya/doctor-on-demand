package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityColdDoctorBinding;

import java.util.ArrayList;

public class ColdDoctor extends AppCompatActivity {

    ActivityColdDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(ColdDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",ColdDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",ColdDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",ColdDoctor.this.doctorDetails.get(intValue).getDegree());
            ColdDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityColdDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Nishant Goyal","MBBS",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Hitendra Modi","MBBS, Diploma in Child Health (DCH)",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Dilip N. Shah","MBBS",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ColdDoctor.this);
        binding.ColdRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(ColdDoctor.this,doctorDetails,this.onClickListener);
        binding.ColdRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}