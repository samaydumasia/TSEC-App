package com.kalpnil.ksinfotech.tsec.tsec;

import android.content.Context;
import android.content.Intent;
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
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.myViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ClickListener clickListener;
    List<Information> data= Collections.emptyList();
    public NavigationAdapter(Context context,List<Information> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= inflater.inflate(R.layout.custom_row, parent, false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(myViewHolder holder,int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }
    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;
        private ClickListener clickListener;
        public myViewHolder(View itemView) {
            super(itemView);
            title= (TextView)itemView.findViewById(R.id.listText);
            icon= (ImageView)itemView.findViewById(R.id.listIcon);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            switch(getAdapterPosition()){
                case 0:
                    break;
                case 1: context.startActivity(new Intent(context,Notices.class));
                    break;
                case 2:
                    context.startActivity(new Intent(context,LabLocator.class));
                    break;
                case 3:context.startActivity(new Intent(context,Faculty.class));
                    break;
                case 4:context.startActivity(new Intent(context,TimeTable.class));
                    break;
                case 5: context.startActivity(new Intent(context,QuestionPaperTrial.class));
                    break;
                case 6: context.startActivity(new Intent(context,Hangouts.class));
                    break;
                case 7: context.startActivity(new Intent(context,AboutUs.class));
                    break;
            }
            if(clickListener!=null){
                clickListener.itemClick(v,getLayoutPosition());
            }
        }
    }
    public interface ClickListener{
        public void itemClick(View view, int position);
    }
}
