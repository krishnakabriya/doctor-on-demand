package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityCoughDoctorBinding;

import java.util.ArrayList;

public class CoughDoctor extends AppCompatActivity {

    ActivityCoughDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(CoughDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",CoughDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",CoughDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",CoughDoctor.this.doctorDetails.get(intValue).getDegree());
            CoughDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCoughDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Rahul Shah","MBBS, MS - ENT",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Ahmed Latiwala","MBBS General Physician,General Practitioner",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Karan P Agarbattiwala","MBBS, MS - ENT, Neck Surgeon",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CoughDoctor.this);
        binding.CoughRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(CoughDoctor.this,doctorDetails,this.onClickListener);
        binding.CoughRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}