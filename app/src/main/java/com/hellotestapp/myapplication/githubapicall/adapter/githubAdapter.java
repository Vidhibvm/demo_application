package com.hellotestapp.myapplication.githubapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.databinding.GithubItemLayoutBinding;
import com.hellotestapp.myapplication.githubapicall.model.ItemsItem;
import com.hellotestapp.myapplication.githubapicall.model.Owner;

import java.util.ArrayList;

public class githubAdapter extends RecyclerView.Adapter<githubAdapter.githubViewholder> {
    ArrayList<ItemsItem> mainobjectArrayList = new ArrayList<>();
    ArrayList<Owner> ownerArrayList = new ArrayList<>();
    Context context;


    public githubAdapter(Context context, ArrayList<ItemsItem> mainobjectArrayList){
        this.context = context;
        this.mainobjectArrayList = mainobjectArrayList;
    }

    @NonNull
    @Override
    public githubViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GithubItemLayoutBinding githubItemLayoutBinding = GithubItemLayoutBinding.inflate(LayoutInflater.from(context));
        return new githubViewholder(githubItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull githubViewholder holder, int position) {
        holder.binding.txtanswerCount.setText(String.valueOf(mainobjectArrayList.get(position).getAnswerCount()));
        holder.binding.txtacceptedAnswerId.setText(String.valueOf(mainobjectArrayList.get(position).getAcceptedAnswerId()));
        holder.binding.txtprotectedDate.setText(String.valueOf(mainobjectArrayList.get(position).getProtectedDate()));
        holder.binding.txtviewCount.setText(String.valueOf(mainobjectArrayList.get(position).getViewCount()));
        //holder.binding.txtanswerCount.setText(String.valueOf(mainobjectArrayList.get(position).getAnswerCount()));
        holder.binding.recTags.setLayoutManager(new LinearLayoutManager(context));
        holder.binding.recOwner.setLayoutManager(new LinearLayoutManager(context));
        holder.binding.recTags.setAdapter(new TagAdapter(context,mainobjectArrayList.get(position).getTags()));

        ownerArrayList.add(mainobjectArrayList.get(position).getOwner());
        holder.binding.recOwner.setAdapter(new OwnerAdapter(context,ownerArrayList));
    }

    @Override
    public int getItemCount() {
        return mainobjectArrayList.size();
    }

    public class githubViewholder extends RecyclerView.ViewHolder {
        GithubItemLayoutBinding binding;
        public githubViewholder(@NonNull GithubItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
