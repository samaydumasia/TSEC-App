package com.kalpnil.ksinfotech.tsec.tsec;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kalpnil.ksinfotech.tsec.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by KALPNIL ANJAN on 22-Jun-15.
 */
public class FacultyAdapter extends RecyclerView.Adapter <FacultyAdapter.myViewHolder> {
    private LayoutInflater inflater;
    List<FacultyInformation> data= Collections.emptyList();
    public FacultyAdapter(List<FacultyInformation> data){
        this.data=data;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.from(parent.getContext())
                .inflate(R.layout.faculty_row, parent, false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        FacultyInformation current=data.get(position);
        holder.icon.setImageResource(current.iconId);
        holder.title.setText(current.title);
        holder.subTitle.setText(current.subTitle);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;
        TextView subTitle;
        public myViewHolder(View itemView) {
            super(itemView);
            title= (TextView)itemView.findViewById(R.id.facName);
            icon= (ImageView)itemView.findViewById(R.id.facIcon);
            subTitle= (TextView) itemView.findViewById(R.id.facSubTitle);
        }
        @Override
        public void onClick(View v) {
        }
    }
}
