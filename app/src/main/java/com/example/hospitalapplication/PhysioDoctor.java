package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityPhysioDoctorBinding;

import java.util.ArrayList;

public class PhysioDoctor extends AppCompatActivity {

    ActivityPhysioDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(PhysioDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",PhysioDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",PhysioDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",PhysioDoctor.this.doctorDetails.get(intValue).getDegree());
            PhysioDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPhysioDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Ankita Padmani","Masters of Physiotheraphy",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Pracheta Raval ","MPT - Neuromuscular Disorders, BPTh/BPT",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Amit Mehta","BPTh/BPT",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PhysioDoctor.this);
        binding.PhysioRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(PhysioDoctor.this,doctorDetails,this.onClickListener);
        binding.PhysioRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}