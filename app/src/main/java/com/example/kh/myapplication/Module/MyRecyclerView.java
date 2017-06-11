package com.example.kh.myapplication.Module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kh.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kh on 6/10/2017.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {
    private List<Contact> list = new ArrayList<Contact>();
    private Context context;
    public MyRecyclerView(Context context, List<Contact> list){
        this.context =context;
        this.list = list;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myaddress,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        try {
            holder.txtEmail.setText(list.get(position).getEmail());
            holder.txtName.setText(list.get(position).getName());
            holder.txtPhone.setText(list.get(position).getPhone());
        }catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public static class MyViewHolder  extends RecyclerView.ViewHolder{

        TextView txtEmail;

        TextView txtName;

        TextView txtPhone;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtPhone = (TextView) itemView.findViewById(R.id.txtName);
            txtName = (TextView) itemView.findViewById(R.id.txtPhone);

        }
    }
}
