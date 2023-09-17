package com.example.hospitalapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hospitalapplication.databinding.FragmentHomeBinding;
import com.example.hospitalapplication.databinding.FragmentHomeTreatmentBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeTreatmentFragment extends Fragment {

    private List<TreatmentListModel> treatmentList;
    private TreatmentListAdapter adapter;
    FragmentHomeTreatmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeTreatmentBinding.inflate(inflater,container,false);

        DBhospital dBhospital = new DBhospital(this.getActivity());
//        treatmentList = new ArrayList<>();
//
//        treatmentList.add(new TreatmentListModel(R.drawable.cold,"Drink plenty of fluids.\n Water, juice, clear broth or warm lemon water are good choices."));
//        treatmentList.add(new TreatmentListModel(R.drawable.cough,"Breathe warm, moist air (humidified)\n such as in the bathroom while the shower is running."));
//        treatmentList.add(new TreatmentListModel(R.drawable.fatigue,"physical activity boosts energy levels, while a sedentary lifestyle is a known cause of fatigue.\n Physical activity has many good effects on the body and mind. A good bout of exercise also helps you sleep better at night."));
//        treatmentList.add(new TreatmentListModel(R.drawable.fever,"paracetamol is a safe choice for most people but it is important not to take more than the recommended dose.\n It is an ingredient in many cold and flu remedies so be careful not to double dose"));
//        treatmentList.add(new TreatmentListModel(R.drawable.headache,"Ease Pressure on Your Scalp or Head\nUse a Heating Pad or Hot Compress\nTry a Cold Pack"));
//
//        adapter=new TreatmentListAdapter(this.getActivity(),treatmentList);
//        binding.LVtreamets.setAdapter(adapter);

        binding.BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeTreatmentFragment.this.getActivity(),login.class));
                Toast.makeText(HomeTreatmentFragment.this.getActivity(), "Logged out successfully..!!\nPlease login again..!!", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}