package com.kalpnil.ksinfotech.tsec.tsec;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kalpnil.ksinfotech.tsec.R;

public class HangoutMap extends AppCompatActivity {
    LatLng tsec = new LatLng(19.06448,72.835901);
    LatLng pos= new LatLng(19.06069,72.83625);
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangout_map);
        map=((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1)).getMap();
        map.setMyLocationEnabled(true);
        Bundle bun = getIntent().getExtras();
        LatLng pos = new LatLng(bun.getDouble("x"),bun.getDouble("y"));
        map.addMarker(new MarkerOptions().position(tsec).title("TSEC").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(pos).title(bun.getString("title")));
        CameraUpdate up =  CameraUpdateFactory.newLatLng(pos);
        CameraUpdate zoom=  CameraUpdateFactory.newLatLngZoom(pos, 16);
        map.animateCamera(up);
        map.animateCamera(zoom);
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

