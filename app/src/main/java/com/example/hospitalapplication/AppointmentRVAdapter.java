package com.example.hospitalapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class AppointmentRVAdapter extends RecyclerView.Adapter<AppointmentRVAdapter.ViewHolder> {
   private ArrayList<AppointmentModel> list;
   private Context context;

   public AppointmentRVAdapter (ArrayList<AppointmentModel> list,Context context)
   {
       this.list=list;
       this.context=context;
   }
    @NonNull
    @Override
    public AppointmentRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointmentlist,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentRVAdapter.ViewHolder holder, int position) {
        AppointmentModel appointmentModel = list.get(position);
        holder.dn.setText(appointmentModel.getDoc_name());
        holder.pn.setText(appointmentModel.getP_name());
        holder.add.setText(appointmentModel.getH_address());
        holder.d.setText(appointmentModel.getA_date());
        holder.t.setText(appointmentModel.getA_time());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private TextView dn,pn,add,d,t;
        public ViewHolder(View view) {
            super(view);

            dn=view.findViewById(R.id.dname);
            pn=view.findViewById(R.id.pname);
            add=view.findViewById(R.id.haddress);
            d=view.findViewById(R.id.date);
            t=view.findViewById(R.id.time);

        }
    }
}
