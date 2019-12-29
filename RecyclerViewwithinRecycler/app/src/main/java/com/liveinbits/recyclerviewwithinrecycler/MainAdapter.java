package com.liveinbits.recyclerviewwithinrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    List<MainModel> mainmodel;
    Context context;
    onSelectListener listener;
    public MainAdapter(List<MainModel> mainModelList,onSelectListener listener){
        mainmodel=mainModelList;
        this.listener=listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.second_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.textView.setText(mainmodel.get(position).getTitle());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Position : "+position,Toast.LENGTH_LONG).show();
            }
        });


        SubAdapter subAdapter=new SubAdapter(mainmodel.get(position).getSubModelList(), new ItemSelection() {
            @Override
            public void onClickItem(int post) {
                listener.onClickSelect(position, post);
            }
        });

        RecyclerView.LayoutManager manager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setAdapter(subAdapter);
        subAdapter.notifyDataSetChanged();

    }
    public interface onSelectListener{
        void onClickSelect(int mainposition,int childposition);
    }

    @Override
    public int getItemCount() {
        return mainmodel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button button;
        RecyclerView recyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.title);
            button=itemView.findViewById(R.id.btn);
            recyclerView=itemView.findViewById(R.id.second_recyclerview);

        }
    }
}
