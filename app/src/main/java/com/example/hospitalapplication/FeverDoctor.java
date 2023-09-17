package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityFeverDoctorBinding;

import java.util.ArrayList;

public class FeverDoctor extends AppCompatActivity {

    ActivityFeverDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(FeverDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",FeverDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",FeverDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",FeverDoctor.this.doctorDetails.get(intValue).getDegree());
            FeverDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFeverDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Ahmed Latiwala","MBBS",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Zeemit Hirani","MBBS, Diploma in Child Health (DCH)",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Jayvant Ranpariya","MD - Physician",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FeverDoctor.this);
        binding.FeverRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(FeverDoctor.this,doctorDetails,this.onClickListener);
        binding.FeverRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}