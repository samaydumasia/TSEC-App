package com.kalpnil.ksinfotech.tsec.tsec;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kalpnil.ksinfotech.tsec.R;

public class MapLocator extends AppCompatActivity {
    TouchImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_locator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bun = getIntent().getExtras();
        int y = bun.getInt("x");
        image = (TouchImageView) findViewById(R.id.image_map);
        if(y == 0)
        {
            image.setImageResource(R.drawable.candies);
            image.setMaxZoom(4f);
        }
        else if (y == 1)
        {
            image.setImageResource(R.drawable.sub);
            image.setMaxZoom(4f);
        }
        else if (y == 2)
        {
            image.setImageResource(R.drawable.gaiety);
            image.setMaxZoom(4f);
        }
        else if (y == 3)
        {
            image.setImageResource(R.drawable.macd);
            image.setMaxZoom(4f);
        }
        else if (y == 4)
        {
            image.setImageResource(R.drawable.domin);
            image.setMaxZoom(4f);
        }
        else if (y == 5)
        {
            image.setImageResource(R.drawable.gelato);
            image.setMaxZoom(4f);
        }
        else if (y == 6)
        {
            image.setImageResource(R.drawable.bd);
            image.setMaxZoom(4f);
        }
        else if (y == 7)
        {
            image.setImageResource(R.drawable.cr);
            image.setMaxZoom(4f);
        }
        else if (y == 8)
        {
            image.setImageResource(R.drawable.sb1);
            image.setMaxZoom(4f);
        }
        else if (y == 9)
        {
            image.setImageResource(R.drawable.gd);
            image.setMaxZoom(4f);
        }
        /*switch(y){
            case 0:
                image.setImageResource(R.drawable.candies);
                image.setMaxZoom(4f);
                break;
            case 1:
                image.setImageResource(R.drawable.sub);
                image.setMaxZoom(4f);
                break;
            case 2:
                image.setImageResource(R.drawable.gaiety);
                image.setMaxZoom(4f);
                break;
            case 3:
                image.setImageResource(R.drawable.macd);
                image.setMaxZoom(4f);
                break;
            case 4:
                image.setImageResource(R.drawable.domin);
                image.setMaxZoom(4f);
                break;
            case 5:
                image.setImageResource(R.drawable.gelato);
                image.setMaxZoom(4f);
                break;
            case 6:
                image.setImageResource(R.drawable.bd);
                image.setMaxZoom(4f);
                break;
            case 7:
                image.setImageResource(R.drawable.cr);
                image.setMaxZoom(4f);
                break;
            case 8:
                image.setImageResource(R.drawable.gd);
                image.setMaxZoom(4f);
                break;

        } */
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

        //noinspection SimplifiableIfStatement
        if(id == R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
