package com.kalpnil.ksinfotech.tsec.tsec;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kalpnil.ksinfotech.tsec.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by KALPNIL ANJAN on 23-Jun-15.
 */
public class LabAdapter extends RecyclerView.Adapter<LabAdapter.myViewHolder> {
    private LayoutInflater inflater;
    List<LabInformation> data= Collections.emptyList();
    public LabAdapter(List<LabInformation> data){
        this.data=data;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.from(parent.getContext())
                .inflate(R.layout.lab_row, parent, false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        LabInformation current=data.get(position);
        holder.title.setText(current.title);
        holder.subTitle.setText(current.subTitle);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView subTitle;
        public myViewHolder(View itemView) {
            super(itemView);
            title= (TextView)itemView.findViewById(R.id.lab_title);
            subTitle= (TextView) itemView.findViewById(R.id.lab_subtitle);
        }
        @Override
        public void onClick(View v) {
        }
    }
}
