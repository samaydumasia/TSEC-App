package com.kalpnil.ksinfotech.tsec.tsec;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.kalpnil.ksinfotech.tsec.R;

public class QuestionPaperTrial extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter;
    TextView text1;
    TextView text2;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_paper_trial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this,R.array.question_list,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        text1 = (TextView) findViewById(R.id.june);
        text2 = (TextView) findViewById(R.id.dec);
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
                    adapter = ArrayAdapter.createFromResource(this,R.array.fe_list,android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                   spinner2.setOnItemSelectedListener(new fe_papers());
                }

                else if(position == 1){
                    adapter = ArrayAdapter.createFromResource(this, R.array.question_sublist,android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                   spinner2.setOnItemSelectedListener(new comps_papers());
                }

                else if(position == 2){
                    adapter = ArrayAdapter.createFromResource(this, R.array.question_sublist,android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                    spinner2.setOnItemSelectedListener(new it_papers());
                }

                else if(position == 3){
                    adapter = ArrayAdapter.createFromResource(this, R.array.question_sublist,android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                    spinner2.setOnItemSelectedListener(new extc_papers());
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class fe_papers implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT YOUR SEMESTER", Toast.LENGTH_SHORT).show();
                    text1.setText("");
                    text2.setText("");
                    break;
                case 1:
                    text1.setText(R.string.fesem1dec);
                    text2.setText(R.string.fesem1june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14FE1-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14FE1-cbgs.pdf";
                            Intent intent=new Intent(v.getContext(),ViewPapers.class);
                            intent.putExtra("url",url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    text1.setText(R.string.fesem2dec);
                    text2.setText(R.string.fesem2june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14FE2-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14FE2-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class comps_papers implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT YOUR SEMESTER", Toast.LENGTH_SHORT).show();
                    text1.setText("");
                    text2.setText("");

                    break;
                case 1:
                    text1.setText(R.string.compsem3dec);
                    text2.setText(R.string.compsem3june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14SE3-COM-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14SE3-COMP-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    text1.setText(R.string.compsem4dec);
                    text2.setText(R.string.compsem4june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14SE4-COM-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14SE4-COMP-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 3:
                    text1.setText(R.string.compsem5dec);
                    text2.setText(R.string.compsem5june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14TE5-COMP-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14TE5-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 4:
                    text1.setText(R.string.compsem6dec);
                    text2.setText(R.string.compsem6june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14TE6-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14TE6-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 5:
                    text1.setText(R.string.compsem7dec);
                    text2.setText(R.string.compsem7june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14BE7-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14BE7-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 6:
                    text1.setText(R.string.compsem8dec);
                    text2.setText(R.string.compsem8june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14BE8-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14BE8-COMP.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class it_papers implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT YOUR SEMESTER", Toast.LENGTH_SHORT).show();
                    text1.setText("");
                    text2.setText("");
                    break;
                case 1:
                    text1.setText(R.string.compsem3dec);
                    text2.setText(R.string.compsem3june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14SE3-IT-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14SE3-IT-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    text1.setText(R.string.compsem4dec);
                    text2.setText(R.string.compsem4june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14SE4-IT-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14SE4-IT-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 3:
                    text1.setText(R.string.compsem5dec);
                    text2.setText(R.string.compsem5june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14TE5-IT-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14TE5-IT.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 4:
                    text1.setText(R.string.compsem6dec);
                    text2.setText(R.string.compsem6june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14TE6-IT.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14TE6-IT.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 5:
                    text1.setText(R.string.compsem7dec);
                    //text2.setText(R.string.compsem7june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14BE7-IT.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    break;
                case 6:
                    text1.setText(R.string.compsem8dec);
                    text2.setText(R.string.compsem8june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14BE8-IT.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14BE8-IT.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class extc_papers implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    Toast.makeText(getApplicationContext(), "SELECT YOUR SEMESTER", Toast.LENGTH_SHORT).show();
                    text1.setText("");
                    text2.setText("");
                    break;
                case 1:
                    text1.setText(R.string.compsem3dec);
                    text2.setText(R.string.compsem3june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14SE3-EXTC-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14SE3-EXTC-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    text1.setText(R.string.compsem4dec);
                    text2.setText(R.string.compsem4june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14SE4-EXTC-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14SE4-EXTC-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 3:
                    text1.setText(R.string.compsem5dec);
                    text2.setText(R.string.compsem5june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14TE5-EXTC-cbgs.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14TE5-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 4:
                    text1.setText(R.string.compsem6dec);
                    text2.setText(R.string.compsem6june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14TE6-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14TE6-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 5:
                    text1.setText(R.string.compsem7dec);
                    text2.setText(R.string.compsem7june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14BE7-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14BE7-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
                case 6:
                    text1.setText(R.string.compsem8dec);
                    text2.setText(R.string.compsem8june);
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/dec2014/D14BE8-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });

                    text2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            url = "http://library.spit.ac.in/QP/jun2014/J14BE8-EXTC.pdf";
                            Intent intent = new Intent(v.getContext(), ViewPapers.class);
                            intent.putExtra("url", url);
                            v.getContext().startActivity(intent);
                        }
                    });
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
