package com.example.hospitalapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TreatmentListAdapter extends BaseAdapter {
    private Context context;
    private List<TreatmentListModel> treatmentList;

    public TreatmentListAdapter (Context context,List<TreatmentListModel> treatmentList)
    {
        this.context = context;
        this.treatmentList = treatmentList;
    }
    @Override
    public int getCount() {
        return treatmentList.size();
    }

    @Override
    public Object getItem(int position) {
        return treatmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.treamentlist,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.IMGsymptoms);
        TextView textView = convertView.findViewById(R.id.TVtreament);

        TreatmentListModel treatmentListModel = treatmentList.get(position);

        imageView.setImageResource(treatmentListModel.getImg());
        textView.setText(treatmentListModel.getTreatment());
        return null;
    }
}
