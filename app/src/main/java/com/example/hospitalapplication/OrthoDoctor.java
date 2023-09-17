package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityOrthoDoctorBinding;

import java.util.ArrayList;

public class OrthoDoctor extends AppCompatActivity {

    ActivityOrthoDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<DoctorModel>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(OrthoDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",OrthoDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",OrthoDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",OrthoDoctor.this.doctorDetails.get(intValue).getDegree());
            OrthoDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrthoDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("DR. SANJAY PAGHADAL","MBBS,MS",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("DR. VIRAL K PAPAIYA","MBBS, DNB",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("DR. KRUNAL SHAH","MBBS",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrthoDoctor.this);
        binding.OrthoRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(OrthoDoctor.this,doctorDetails,this.onClickListener);
        binding.OrthoRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}