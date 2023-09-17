package com.example.hospitalapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int ITEM_DATA=0;
    public Context activity;
    private ArrayList<DoctorModel> list;
    View.OnClickListener onClickListener;

    public class ItemHolder extends RecyclerView.ViewHolder
    {
        public ImageView imgIcon;
        public LinearLayout linearLayout;
        TextView tvName;
        TextView tvDegree;

        public ItemHolder(View view)
        {
            super(view);
            this.linearLayout=(LinearLayout) view.findViewById(R.id.clickDoctor);
            this.imgIcon=(ImageView) view.findViewById(R.id.DoctorImage);
            this.tvName=(TextView) view.findViewById(R.id.DocName);
            this.tvDegree=(TextView) view.findViewById(R.id.DocDegree);
        }
    }

    public DoctorAdapter(Context context,ArrayList<DoctorModel> arrayList,View.OnClickListener onClickListener2)
    {
        this.onClickListener=onClickListener2;
        this.activity=context;
        this.list=arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == this.ITEM_DATA) {
            return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorlist, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        if(getItemViewType(i) == this.ITEM_DATA)
        {
            ItemHolder itemHolder = (ItemHolder) holder;
            DoctorModel doctordetails = this.list.get(i);
            itemHolder.imgIcon.setImageResource(Integer.valueOf(doctordetails.getImg()));
            itemHolder.tvName.setText(doctordetails.getDname());
            itemHolder.tvDegree.setText(doctordetails.getDegree());
            itemHolder.linearLayout.setTag(Integer.valueOf(i));
            itemHolder.linearLayout.setOnClickListener(this.onClickListener);
        }
    }

    @Override
    public int getItemCount() {return this.list.size();}

    public int getItemViewType(int i) {
        return this.ITEM_DATA;
    }
}
