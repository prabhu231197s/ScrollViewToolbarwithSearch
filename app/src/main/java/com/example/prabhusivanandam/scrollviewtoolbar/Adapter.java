package com.example.prabhusivanandam.scrollviewtoolbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Prabhu Sivanandam on 05-May-17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    ArrayList<Model> m=new ArrayList<>();
    Model x;

    public Adapter(ArrayList<Model> m)
    {
        this.m=m;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cards,parent,false);
        Viewholder h=new Viewholder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        x=m.get(position);
        holder.t1.setText(x.getName());
        holder.t2.setText(x.getEmail());
        holder.t3.setText(x.getPassword());
    }

    @Override
    public int getItemCount() {
        return m.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3;

        public Viewholder(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.et1);
            t2=(TextView)itemView.findViewById(R.id.et2);
            t3=(TextView)itemView.findViewById(R.id.et3);
        }
    }
    public void setFilter(ArrayList<Model> list)
    {
        m=new ArrayList<>();
        m.addAll(list);
        notifyDataSetChanged();
    }
}
