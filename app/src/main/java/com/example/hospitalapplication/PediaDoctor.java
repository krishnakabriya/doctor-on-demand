package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hospitalapplication.databinding.ActivityPediaDoctorBinding;

import java.util.ArrayList;

public class PediaDoctor extends AppCompatActivity {

    ActivityPediaDoctorBinding binding;
    public ArrayList<DoctorModel> doctorDetails = new ArrayList<>();
    DoctorAdapter doctorAdapter;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int intValue = ((Integer)view.getTag()).intValue();
            Intent intent = new Intent(PediaDoctor.this.getApplicationContext(),AppointmentBookingActivity.class);
            intent.putExtra("Img",PediaDoctor.this.doctorDetails.get(intValue).getImg());
            intent.putExtra("Name",PediaDoctor.this.doctorDetails.get(intValue).getDname());
            intent.putExtra("Degree",PediaDoctor.this.doctorDetails.get(intValue).getDegree());
            PediaDoctor.this.startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPediaDoctorBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        doctorDetails.add(new DoctorModel("Dr. Zeemit Hirani","MBBS, Diploma in Child Health (DCH) Pediatrician",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Kamlesh B. Gevariya","MD - Physician, Diploma in Child Health (DCH) Pediatrician",R.drawable.imgdoctor));
        doctorDetails.add(new DoctorModel("Dr. Bhavesh Patel","MD - Pediatrics",R.drawable.imgdoctor));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PediaDoctor.this);
        binding.PediaRCV.setLayoutManager(linearLayoutManager);
        doctorAdapter=new DoctorAdapter(PediaDoctor.this,doctorDetails,this.onClickListener);
        binding.PediaRCV.setAdapter(doctorAdapter);

        binding.toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}