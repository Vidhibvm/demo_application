package com.hellotestapp.myapplication.NestestJsonCall;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.apicall.AllListAdapter;
import com.hellotestapp.myapplication.databinding.ItemDataBinding;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context context;
    ArrayList<Data> dataArrayList;

    public DataAdapter(Context context,ArrayList<Data> dataArrayList){
        Log.e("TAG", "onBindViewHolder: " + dataArrayList.size() );
        this.context = context;
        this.dataArrayList = dataArrayList;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDataBinding dataBinding = ItemDataBinding.inflate(LayoutInflater.from(context),parent,false);
        return new DataViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        Log.e("TAG", "onBindViewHolder: " + dataArrayList.get(position).getName() );
            holder.dataBinding.txtid.setText(dataArrayList.get(position).getId().toString());
            holder.dataBinding.txtname.setText(dataArrayList.get(position).getName().toString());
            holder.dataBinding.txtyear.setText(dataArrayList.get(position).getYear().toString());
            holder.dataBinding.txtcolor.setText(dataArrayList.get(position).getColor().toString());
            holder.dataBinding.txtpantoneValue.setText(dataArrayList.get(position).getPantone_value().toString());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        ItemDataBinding dataBinding;
        public DataViewHolder(@NonNull ItemDataBinding itemView) {
            super(itemView.getRoot());
            dataBinding = itemView;
        }
    }
}
