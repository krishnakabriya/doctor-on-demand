package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityFatigueDoctorBinding;

import java.util.ArrayList;

public class FatigueDoctor extends AppCompatActivity {

    ActivityFatigueDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(FatigueDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",FatigueDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",FatigueDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",FatigueDoctor.this.doctorDetails.get(intValue).getDegree());
            FatigueDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFatigueDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Bilal Motala","MBBS",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Dinesh Shah","MBBS",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Shailesh Gandhi","MBBS",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FatigueDoctor.this);
        binding.FatigueRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(FatigueDoctor.this,doctorDetails,this.onClickListener);
        binding.FatigueRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}