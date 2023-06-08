package com.hellotestapp.myapplication.NestestJsonCall;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.apicall.model.Example;
import com.hellotestapp.myapplication.databinding.MainItemRowBinding;

import java.util.ArrayList;

public class MainBookAdapter extends RecyclerView.Adapter<MainBookAdapter.Bookviewholder> {
    Context context;
    ArrayList<Book> mainlist;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();


    public MainBookAdapter(Context context, ArrayList<Book> mainlist) {
        this.context = context;
        this.mainlist = mainlist;
    }

    @NonNull
    @Override
    public Bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainItemRowBinding mainItemRowBinding = MainItemRowBinding.inflate(LayoutInflater.from(context), parent, false);
        return new Bookviewholder(mainItemRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Bookviewholder holder, int position) {
        Book parentItem = mainlist.get(position);

        holder.mainItemRowBinding.txtpage.setText(mainlist.get(position).getPage().toString());
        holder.mainItemRowBinding.txtperPage.setText(mainlist.get(position).getPer_page().toString());
        holder.mainItemRowBinding.txttotal.setText(mainlist.get(position).getTotal().toString());
        holder.mainItemRowBinding.txttotalPages.setText(mainlist.get(position).getTotal_pages().toString());


        holder.mainItemRowBinding.recUselist.setNestedScrollingEnabled(false);
    //    holder.setIsRecyclable(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        layoutManager.setInitialPrefetchItemCount(parentItem.getData().size());

        DataAdapter childItemAdapter = new DataAdapter(context,parentItem
                        .getData());
        holder.mainItemRowBinding.recUselist.setLayoutManager(layoutManager);
        holder.mainItemRowBinding.recUselist.setAdapter(childItemAdapter);
        holder.mainItemRowBinding.recUselist.setRecycledViewPool(viewPool);






    }

    @Override
    public int getItemCount() {
        return mainlist.size();
    }

    public class Bookviewholder extends RecyclerView.ViewHolder {
        MainItemRowBinding mainItemRowBinding;

        public Bookviewholder(@NonNull MainItemRowBinding itemView) {
            super(itemView.getRoot());
            mainItemRowBinding = itemView;
        }
    }

}
