package com.hellotestapp.myapplication.githubapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.databinding.OwnerRowItemBinding;
import com.hellotestapp.myapplication.databinding.TagRowItemBinding;
import com.hellotestapp.myapplication.githubapicall.model.Owner;

import java.util.ArrayList;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.OwnerViewHolder> {
    Context context;
    ArrayList<Owner> ownerArrayList;
    public OwnerAdapter(Context context, ArrayList<Owner> ownerArrayList) {
        this.context = context;
        this.ownerArrayList = ownerArrayList;
    }

    @NonNull
    @Override
    public OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OwnerRowItemBinding tagRowItemBinding = OwnerRowItemBinding.inflate(LayoutInflater.from(context));
        return new OwnerViewHolder(tagRowItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return ownerArrayList.size();
    }

    public class OwnerViewHolder extends RecyclerView.ViewHolder {
        OwnerRowItemBinding tagRowItemBinding;
        public OwnerViewHolder(@NonNull OwnerRowItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}

