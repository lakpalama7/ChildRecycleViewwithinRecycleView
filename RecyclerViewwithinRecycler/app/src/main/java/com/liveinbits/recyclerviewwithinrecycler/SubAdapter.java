package com.liveinbits.recyclerviewwithinrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.MyViewHolder> {

    List<SubModel> submodel;
    Context context;
    ItemSelection listener;
    public SubAdapter(List<SubModel> submodel, ItemSelection listener){
        this.submodel=submodel;
        this.listener=listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.single_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.title.setText(submodel.get(position).getImagetitle());
            holder.imageView.setImageResource(submodel.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return submodel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.imagetitle);
            imageView=itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClickItem(getAdapterPosition());
        }
    }
}
