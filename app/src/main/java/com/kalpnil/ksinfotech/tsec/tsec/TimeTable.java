package com.kalpnil.ksinfotech.tsec.tsec;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.kalpnil.ksinfotech.tsec.R;


public class TimeTable extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter;
    //ImageView image;
    TouchImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this,R.array.year,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        image = (TouchImageView) findViewById(R.id.image_time_table);
        image.setImageResource(0);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinner1:
                if (position == 0){
                    adapter = ArrayAdapter.createFromResource(this,R.array.divisions,android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                    spinner2.setOnItemSelectedListener(new fe_time_table());
                    image.setImageResource(0);

                }

                else if(position == 1){
                    adapter = ArrayAdapter.createFromResource(this, R.array.branches,android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                    spinner2.setOnItemSelectedListener(new se_time_table());
                    image.setImageResource(0);
                }

                else if(position == 2){
                    adapter = ArrayAdapter.createFromResource(this, R.array.branches,android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                    spinner2.setOnItemSelectedListener(new te_time_table());
                    image.setImageResource(0);
                }

                else if(position == 3){
                    adapter = ArrayAdapter.createFromResource(this, R.array.branches,android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                    spinner2.setOnItemSelectedListener(new be_time_table());
                    image.setImageResource(0);
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    class fe_time_table implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            switch (position) {
                case 1:
                    image.setImageResource(R.drawable.fea);
                    image.setMaxZoom(4f);
                    break;
                case 2:
                    image.setImageResource(R.drawable.feb);
                    image.setMaxZoom(4f);
                    break;
                case 3:
                    image.setImageResource(R.drawable.fec);
                    image.setMaxZoom(4f);
                    break;
                case 4:
                    image.setImageResource(R.drawable.fed);
                    image.setMaxZoom(4f);
                    break;
                case 5:
                    image.setImageResource(R.drawable.fee);
                    image.setMaxZoom(4f);
                    break;
                case 6:
                    image.setImageResource(R.drawable.fef);
                    image.setMaxZoom(4f);
                    break;
                case 7:
                    image.setImageResource(R.drawable.feg);
                    image.setMaxZoom(4f);
                    break;
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT A BRANCH", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
            @Override
            public void onNothingSelected (AdapterView < ? > parent){
            }

    }

    class se_time_table implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            switch (position){
                case 1:
                   // Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.sec1);
                    image.setMaxZoom(4f);
                    break;
                case 2:
                   // Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.sec2);
                    image.setMaxZoom(4f);
                    break;
                case 3:
                   // Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.seit1);
                    image.setMaxZoom(4f);
                    break;
                case 4:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.seit2);
                    image.setMaxZoom(4f);
                    break;
                case 5:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.seextc);
                    image.setMaxZoom(4f);
                    break;
                case 6:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.sebm);
                    image.setMaxZoom(4f);
                    break;
                case 7:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.sebt);
                    image.setMaxZoom(4f);
                    break;
                case 8:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.sechem);
                    image.setMaxZoom(4f);
                    break;
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT A BRANCH", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class te_time_table implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            switch (position) {
                case 1:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.tec1);
                    image.setMaxZoom(4f);
                    break;
                case 2:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.tec2);
                    image.setMaxZoom(4f);
                    break;
                case 3:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.teit1);
                    image.setMaxZoom(4f);
                    break;
                case 4:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.teit2);
                    image.setMaxZoom(4f);
                    break;
                case 5:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.teextc);
                    image.setMaxZoom(4f);
                    break;
                case 6:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                     image.setImageResource(R.drawable.tebm);
                    image.setMaxZoom(4f);
                    break;
                case 7:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.tebt);
                    image.setMaxZoom(4f);
                    break;
                case 8:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.techem);
                    image.setMaxZoom(4f);
                    break;
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT A BRANCH", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class be_time_table implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            switch (position) {
                case 1:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.bec1); image.setMaxZoom(4f);
                    break;
                case 2:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.bec2); image.setMaxZoom(4f);
                    break;
                case 3:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                   image.setImageResource(R.drawable.beit1); image.setMaxZoom(4f);
                    break;
                case 4:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                  image.setImageResource(R.drawable.beit2); image.setMaxZoom(4f);
                    break;
                case 5:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                  image.setImageResource(R.drawable.beextc); image.setMaxZoom(4f);
                    break;
                case 6:
                   // Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                     image.setImageResource(R.drawable.bebm); image.setMaxZoom(4f);
                    break;
                case 7:
                   // Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.bebt); image.setMaxZoom(4f);
                    break;
                case 8:
                    //Toast.makeText(getApplicationContext(), "WILL BE UPLOADED SOON", Toast.LENGTH_SHORT).show();
                    image.setImageResource(R.drawable.bechem); image.setMaxZoom(4f);
                    break;
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT A BRANCH", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
