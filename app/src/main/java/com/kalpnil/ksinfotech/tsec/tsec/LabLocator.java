package com.kalpnil.ksinfotech.tsec.tsec;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.kalpnil.ksinfotech.tsec.R;

import java.util.ArrayList;
import java.util.List;


public class LabLocator extends AppCompatActivity {
    private String[] branch;
    private Spinner spinner;
    private LabAdapter adapter;
    private RecyclerView recyclerView;
    public static List<LabInformation> getData(String[] titles, String[] subtitles){
        List<LabInformation> data=new ArrayList<>();
        for(int i=0;i<titles.length&&i<subtitles.length;i++){
            LabInformation current=new LabInformation();
            current.title=titles[i%titles.length];
            current.subTitle=subtitles[i%subtitles.length];
            data.add(current);
        }
        return data;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_locator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        branch=getResources().getStringArray(R.array.lab_list);
        spinner= (Spinner) findViewById(R.id.lab_spinner);
        ArrayAdapter<String> branchAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,branch);
        branchAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(branchAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                recyclerView = (RecyclerView) findViewById(R.id.lab_recycler_view);
                switch (position) {
                    case 0:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.nolab), getResources().getStringArray(R.array.nosublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 1:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.fe_lab), getResources().getStringArray(R.array.fe_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 2:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.comp_lab), getResources().getStringArray(R.array.comp_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 3:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.it_lab), getResources().getStringArray(R.array.it_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 4:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.extc_lab), getResources().getStringArray(R.array.extc_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 5:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.chem_lab), getResources().getStringArray(R.array.chem_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 6:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.biomed_lab), getResources().getStringArray(R.array.biomed_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 7:
                        adapter = new LabAdapter(getData(getResources().getStringArray(R.array.biotech_lab), getResources().getStringArray(R.array.biotech_sublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
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
