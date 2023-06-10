package com.hellotestapp.myapplication.githubapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.databinding.TagRowItemBinding;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder> {
    Context context;
    List<String> tags;
    public TagAdapter(Context context, List<String> tags) {
        this.context = context;
        this.tags = tags;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TagRowItemBinding tagRowItemBinding = TagRowItemBinding.inflate(LayoutInflater.from(context));
        return new TagViewHolder(tagRowItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
            holder.tagRowItemBinding.title.setText(String.valueOf(tags.get(position)));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class TagViewHolder extends RecyclerView.ViewHolder {
        TagRowItemBinding tagRowItemBinding;
        public TagViewHolder(@NonNull TagRowItemBinding itemView) {
            super(itemView.getRoot());
            tagRowItemBinding=itemView;
        }
    }
}
