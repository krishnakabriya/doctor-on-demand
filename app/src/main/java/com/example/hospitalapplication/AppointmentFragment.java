package com.example.hospitalapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalapplication.databinding.FragmentAppointmentBinding;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFragment extends Fragment {

    private ArrayList<AppointmentModel> arrayList;
   private AppointmentRVAdapter adapter;
    FragmentAppointmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAppointmentBinding.inflate(inflater,container,false);

        arrayList = new ArrayList<>();
        DBhospital dBhospital = new DBhospital(this.getActivity());

        arrayList = dBhospital.getAppointment();
        adapter = new AppointmentRVAdapter(arrayList,AppointmentFragment.this.getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AppointmentFragment.this.getActivity(),RecyclerView.VERTICAL,false);
        binding.appointmentlistRV.setLayoutManager(linearLayoutManager);

        binding.appointmentlistRV.setAdapter(adapter);

        return binding.getRoot();
    }
}