package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.hospitalapplication.databinding.ActivitySkinDoctorBinding;

import java.util.ArrayList;

public class SkinDoctor extends AppCompatActivity {

    ActivitySkinDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(SkinDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",SkinDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",SkinDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",SkinDoctor.this.doctorDetails.get(intValue).getDegree());
            SkinDoctor.this.startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySkinDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr.Krutika Shain","MBBS, DDVL",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr.Dipak Patel","MBBS, MD - (Dermatology & STD)",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr.Hitesh Viradiya","DVD, MBBS",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SkinDoctor.this);
        binding.SkinRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(SkinDoctor.this,doctorDetails,this.onClickListener);
        binding.SkinRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}