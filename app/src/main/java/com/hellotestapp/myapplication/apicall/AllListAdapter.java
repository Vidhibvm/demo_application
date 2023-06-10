package com.hellotestapp.myapplication.apicall;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.databinding.ItemDataBinding;
import com.hellotestapp.myapplication.apicall.model.Datum;

import java.util.ArrayList;

public class AllListAdapter extends RecyclerView.Adapter<AllListAdapter.MyViewHolder> {
    Context context;
    ArrayList<Datum> datalist;

    public AllListAdapter(Context context, ArrayList<Datum> datalist) {
        Log.e("TAG", "AllListAdapter: " + datalist.size() );
            this.datalist = datalist;
            this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDataBinding itemDataBinding = ItemDataBinding.inflate(LayoutInflater.from(context),parent,false);

        return new MyViewHolder(itemDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.txtid.setText(datalist.get(position).getId().toString());
        holder.binding.txtname.setText(datalist.get(position).getName());
        holder.binding.txtcolor.setText(datalist.get(position).getColor().toString());
        holder.binding.txtyear.setText(datalist.get(position).getYear().toString());
        holder.binding.txtpantoneValue.setText(datalist.get(position).getPantoneValue());


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemDataBinding binding;

        public MyViewHolder(@NonNull ItemDataBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }


}
