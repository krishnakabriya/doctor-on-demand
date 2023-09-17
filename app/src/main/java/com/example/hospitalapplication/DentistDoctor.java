package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityDentistDoctorBinding;

import java.util.ArrayList;

public class DentistDoctor extends AppCompatActivity {

    ActivityDentistDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(DentistDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",DentistDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",DentistDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",DentistDoctor.this.doctorDetails.get(intValue).getDegree());
            DentistDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDentistDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Preeti R Shah","BDS Dentist",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Jaydeep Mali","BDS, MDS - Periodontics",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Ushma K Kakkad","BDS, Certificate in Cosmetic Dentistry",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DentistDoctor.this);
        binding.DentistRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(DentistDoctor.this,doctorDetails,this.onClickListener);
        binding.DentistRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}