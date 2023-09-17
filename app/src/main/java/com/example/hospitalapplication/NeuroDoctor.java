
package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityNeuroDoctorBinding;

import java.util.ArrayList;

public class NeuroDoctor extends AppCompatActivity {

    ActivityNeuroDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(NeuroDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",NeuroDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",NeuroDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",NeuroDoctor.this.doctorDetails.get(intValue).getDegree());
            NeuroDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNeuroDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Parthiv Desai","MBBS, MD, DM",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Kishore L Padshala","MBBS, MD",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Bhadresh Mangukiya","MBBS, MD -General Medicine, DM -Neurology",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NeuroDoctor.this);
        binding.NeuroRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(NeuroDoctor.this,doctorDetails,this.onClickListener);
        binding.NeuroRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}