package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityHeadacheDoctorBinding;

import java.util.ArrayList;

public class HeadacheDoctor extends AppCompatActivity {

    ActivityHeadacheDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(HeadacheDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",HeadacheDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",HeadacheDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",HeadacheDoctor.this.doctorDetails.get(intValue).getDegree());
            HeadacheDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHeadacheDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Kiran Jayswal","MBBS, MD - Anaesthesiology",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Rajiv Raj Choudhry","MBBS, MS - Orthopaedics, MS - Orthopaedics",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Anant Patel","MBBS, MD - Anaesthesiology",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HeadacheDoctor.this);
        binding.HeadacheRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(HeadacheDoctor.this,doctorDetails,this.onClickListener);
        binding.HeadacheRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}