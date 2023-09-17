package com.example.hospitalapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class DoctorListAdapter extends ArrayAdapter<DoctorModel> {

    public DoctorListAdapter(@NonNull Context context, ArrayList<DoctorModel> arrayList) {
        super(context, 0,arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null)
        {
            view=LayoutInflater.from(getContext()).inflate(R.layout.doctorlist,parent,false);
        }

        DoctorModel doctorModel = getItem(position);

        ImageView img = view.findViewById(R.id.DoctorImage);
        assert doctorModel!=null;
        img.setImageResource(doctorModel.getImg());

        TextView dname = view.findViewById(R.id.DocName);
        assert doctorModel!=null;
        dname.setText(doctorModel.getDname());

        TextView degree= view.findViewById(R.id.DocDegree);
        assert doctorModel!=null;
        degree.setText(doctorModel.getDegree());

        return view;
    }
}
