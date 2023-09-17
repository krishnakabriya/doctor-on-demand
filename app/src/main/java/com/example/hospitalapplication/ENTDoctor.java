package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityEntdoctorBinding;

import java.util.ArrayList;

public class ENTDoctor extends AppCompatActivity {

    ActivityEntdoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(ENTDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",ENTDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",ENTDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",ENTDoctor.this.doctorDetails.get(intValue).getDegree());
            ENTDoctor.this.startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEntdoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Prashant B. Desai","MBBS, DLO, MS -ENT",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Akshay Desai"," MBBS, MS -ENT",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Samir D. Shah","MBBS, DLO",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ENTDoctor.this);
        binding.EntRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(ENTDoctor.this,doctorDetails,this.onClickListener);
        binding.EntRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}