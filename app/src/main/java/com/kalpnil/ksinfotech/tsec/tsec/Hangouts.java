package com.kalpnil.ksinfotech.tsec.tsec;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kalpnil.ksinfotech.tsec.R;

import java.util.ArrayList;
import java.util.List;


public class Hangouts extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HangoutAdapter adapter;
    private int[] hang_img= {R.drawable.candies_cafe1,R.drawable.subway,R.drawable.gaiety1,R.drawable.mcd1,R.drawable.pizza1,R.drawable.gelato1,R.drawable.sealink1,R.drawable.carters1,R.drawable.s1,R.drawable.gd1};
    public static List<HangoutInformation> getData(int[] icons,String[] titles){
        List<HangoutInformation> data=new ArrayList<>();
        for(int i=0;i<titles.length&&i<icons.length;i++){
            HangoutInformation current=new HangoutInformation();
            current.iconId=icons[i% icons.length];
            current.title=titles[i%titles.length];
            data.add(current);
        }
        return data;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangouts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.hang_recycler_view);
        adapter = new HangoutAdapter(getData(hang_img, getResources().getStringArray(R.array.hangout_places)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_faculty, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
