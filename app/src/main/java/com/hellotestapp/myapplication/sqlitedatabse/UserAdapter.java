package com.hellotestapp.myapplication.sqlitedatabse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context mContext;
    private List<User> itemList;
    AdapterClick adapterClick;

    public UserAdapter(Context mContext, List<User> itemList, AdapterClick adapterClick) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.adapterClick = adapterClick;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = itemList.get(position);
        holder.name.setText(user.getName());
        holder.id.setText(user.getId() + "");
        holder.number.setText(user.getMobile_number());

        if (itemList.get(position).getIsfav() == 0) {
            holder.btn_fav.setText("unfav");
        } else {
            holder.btn_fav.setText("fav");
        }

        holder.btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if (itemList.get(position).getIsfav() == 0) {
                    new Mydatabase(mContext).updatedata(itemList.get(position).getId(), itemList.get(position).getName(), itemList.get(position).getMobile_number(), 1);
                } else {
                    new Mydatabase(mContext).updatedata(itemList.get(position).getId(), itemList.get(position).getName(), itemList.get(position).getMobile_number(), 0);
                }*/
                new Mydatabase(mContext).deletedata(itemList.get(position).getId());
                itemList = new Mydatabase(mContext).retrivedata();
                notifyDataSetChanged();
                //adapterClick.onitemclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, id, number;
        Button btn_fav;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txtname);
            id = view.findViewById(R.id.txtid);
            number = view.findViewById(R.id.txtnumber);
            btn_fav = view.findViewById(R.id.btn_fav);
        }
    }
}
