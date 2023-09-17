package com.example.hospitalapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.hospitalapplication.databinding.FragmentSearchBinding;

import java.util.ArrayList;


public class SearchFragment extends Fragment {
    FragmentSearchBinding binding;
    final ArrayList<DoctorModel> arrayList = new ArrayList<DoctorModel>();
    DoctorListAdapter doctorListAdapter;

//    View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            int intValue = ((Integer)view.getTag()).intValue();
//            Intent intent = new Intent(SearchFragment.this.getActivity(),AppointmentBookingActivity.class);
//            intent.putExtra("Img",SearchFragment.this.arrayList.get(intValue).getImg());
//            intent.putExtra("Name",SearchFragment.this.arrayList.get(intValue).getDname());
//            intent.putExtra("Degree",SearchFragment.this.arrayList.get(intValue).getDegree());
//            SearchFragment.this.startActivity(intent);
//        }
//    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSearchBinding.inflate(inflater,container,false);

        arrayList.add(new DoctorModel("Dr. Nishant Goyal","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Hitendra Modi","MBBS, Diploma in Child Health (DCH)",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Dilip N. Shah","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Karan P Agarbattiwala","MBBS, MS - ENT, Neck Surgeon",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Ahmed Latiwala","MBBS General Physician,General Practitioner",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Rahul Shah","MBBS, MS - ENT",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Ushma K Kakkad","BDS, Certificate in Cosmetic Dentistry",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Jaydeep Mali","BDS, MDS - Periodontics",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Preeti R Shah","BDS Dentist",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Samir D. Shah","MBBS, DLO",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Akshay Desai"," MBBS, MS -ENT",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Prashant B. Desai","MBBS, DLO, MS -ENT",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Shailesh Gandhi","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Dinesh Shah","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Bilal Motala","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Jayvant Ranpariya","MD - Physician",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Zeemit Hirani","MBBS, Diploma in Child Health (DCH)",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Ahmed Latiwala","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Anant Patel","MBBS, MD - Anaesthesiology",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Rajiv Raj Choudhry","MBBS, MS - Orthopaedics, MS - Orthopaedics",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Kiran Jayswal","MBBS, MD - Anaesthesiology",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Bhadresh Mangukiya","MBBS, MD -General Medicine, DM -Neurology",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Kishore L Padshala","MBBS, MD",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Parthiv Desai","MBBS, MD, DM",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("DR. KRUNAL SHAH","MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("DR. VIRAL K PAPAIYA","MBBS, DNB",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("DR. SANJAY PAGHADAL","MBBS,MS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Bhavesh Patel","MD - Pediatrics",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Kamlesh B. Gevariya","MD - Physician, Diploma in Child Health (DCH) Pediatrician",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Zeemit Hirani","MBBS, Diploma in Child Health (DCH) Pediatrician",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Amit Mehta","BPTh/BPT",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Pracheta Raval ","MPT - Neuromuscular Disorders, BPTh/BPT",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr. Ankita Padmani","Masters of Physiotheraphy",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr.Hitesh Viradiya","DVD, MBBS",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr.Dipak Patel","MBBS, MD - (Dermatology & STD)",R.drawable.imgdoctor));
        arrayList.add(new DoctorModel("Dr.Krutika Shain","MBBS, DDVL",R.drawable.imgdoctor));


        doctorListAdapter = new DoctorListAdapter(getActivity(),arrayList);
        binding.listDoctor.setAdapter(doctorListAdapter);


        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(arrayList.contains(query))
                {
                    doctorListAdapter.getFilter().filter(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //doctorListAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return binding.getRoot();
    }
}