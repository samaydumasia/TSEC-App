package com.kalpnil.ksinfotech.tsec.tsec;

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
 * Created by KALPNIL ANJAN on 24-Jun-15.
 */
public class HangoutAdapter extends RecyclerView.Adapter<HangoutAdapter.myViewHolder> {
    String[] place =   {"Candies","Subway","Gaiety Cinema","McDonalds","Domino's Pizza","Gelato Italiano","BandStand","Carter Road","Sbarro","Gamer's Den",};
    Double[] x = {19.050202,19.063583,19.061311,19.066112,19.067929,19.061905,19.042967,19.069800,19.063461,19.065166};
    Double[] y ={72.829989,72.834857,72.838777,72.834401,72.832592,72.836251,72.817988,72.822572,72.834996,72.835191};
    int [] img = {0,1,2,3,4,5,6,7,8,9};
    private LayoutInflater inflater;
    List<HangoutInformation> data= Collections.emptyList();
    public HangoutAdapter(List<HangoutInformation> data){
        this.data=data;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.from(parent.getContext())
                .inflate(R.layout.hang_row, parent, false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        HangoutInformation current=data.get(position);
        holder.icon.setImageResource(current.iconId);
        holder.title.setText(current.title);
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
            title= (TextView)itemView.findViewById(R.id.hang_text);
            icon= (ImageView)itemView.findViewById(R.id.img_hangout);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Class c;
            switch(getAdapterPosition()){
                case 0:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[0]);
                        v.getContext().startActivity(i);
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[1]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[2]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[3]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[4]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[5]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[6]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[7]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[8]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",img[9]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    public interface ClickListener{
        public void itemClick(View view, int position);
    }
}


/*

    @Override
        public void onClick(View v) {
            Class c;
            switch(getAdapterPosition()){
                case 0:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[0]);
                        i.putExtra("y",y[0]);
                        i.putExtra("title", place[0]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[1]);
                        i.putExtra("y",y[1]);
                        i.putExtra("title", place[1]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[2]);
                        i.putExtra("y",y[2]);
                        i.putExtra("title", place[2]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[3]);
                        i.putExtra("y",y[3]);
                        i.putExtra("title", place[4]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[4]);
                        i.putExtra("y",y[4]);
                        i.putExtra("title", place[4]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[5]);
                        i.putExtra("y",y[5]);
                        i.putExtra("title", place[5]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[6]);
                        i.putExtra("y",y[6]);
                        i.putExtra("title", place[6]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[7]);
                        i.putExtra("y",y[7]);
                        i.putExtra("title", place[7]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[8]);
                        i.putExtra("y",y[8]);
                        i.putExtra("title", place[8]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        c = Class.forName("com.kalpnil.ksinfotech.tsec.tsec.MapLocator");
                        Intent i = new Intent(v.getContext(),c);
                        i.putExtra("x",x[9]);
                        i.putExtra("y",y[9]);
                        i.putExtra("title", place[9]);
                        v.getContext().startActivity(i);

                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
            }
        }
 */
