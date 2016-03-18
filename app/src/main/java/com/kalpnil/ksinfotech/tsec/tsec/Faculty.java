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


public class Faculty extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] branch;
    private Spinner spinner;
    private FacultyAdapter adapter;
    public int[] nofac = {};
    private int[] comp_fac= {R.drawable.jayant,R.drawable.tanuja_sarode,R.drawable.archana_p,R.drawable.shilpa_verma,R.drawable.seema_k,R.drawable.tasneem,R.drawable.sakshi_surve,R.drawable.ujjwala_bhambre,R.drawable.anagha,R.drawable.gopal_g,R.drawable.sonal_shroff,R.drawable.vaishali_s,R.drawable.ruhi_bajaj,R.drawable.manisha_dum,R.drawable.rupali_patil,R.drawable.ashwini_mane,R.drawable.arti_desh,R.drawable.vijaya_pad,R.drawable.urvi_kore,R.drawable.aejazul};
    private int[] it_fac={R.drawable.thampi,R.drawable.arun_k,R.drawable.archana_kale,R.drawable.anjali,R.drawable.madhuri_rao,R.drawable.sampada_pinge,R.drawable.shanthi,R.drawable.kumkum,R.drawable.gopal_p,R.drawable.mukesh_i,R.drawable.geeta_k,R.drawable.nagaveni,R.drawable.chetan,R.drawable.reshma_malik,R.drawable.sanjay_pandey,R.drawable.sunita_rathod,R.drawable.suvarna,R.drawable.nikhilesh,R.drawable.bhushan,R.drawable.sachi_natu,R.drawable.sanober_shaikh,R.drawable.rahul_t,R.drawable.nivedeeta_mukherjee,R.drawable.bhanu_tekwani,R.drawable.ankita_chadha};
    private int[] extc_fac={R.drawable.ashwini_kunte,R.drawable.anuradha_rao,R.drawable.m_mani_roja,R.drawable.k_rajput,R.drawable.medha_somalwar,R.drawable.k_mathew,R.drawable.anushree_gupta,R.drawable.vijayalakshmi_badre,R.drawable.shristi_bhatia,R.drawable.neeru_pathak,R.drawable.uttara_bhat,R.drawable.jyoti_kashyap,R.drawable.amit_hatekar,R.drawable.sharmila_barve};
    private int[] chem_fac={R.drawable.r_s_waghmare,R.drawable.sadhana_purohit,R.drawable.nita_mehta,R.drawable.anita_kumari,R.drawable.usha_aravind_nambiar,R.drawable.elizabeth_biju_joseph,R.drawable.prasad_jayavant_parulekar,R.drawable.ravindra_joshi,R.drawable.sangita_wamanrao_borkar,R.drawable.monica_dialani,R.drawable.aasheesh_moorjani};
    private int[] biomed_fac={R.drawable.mita_bhowmick,R.drawable.bharati_ingale,R.drawable.dhananjay_theckedath,R.drawable.gauri_shukla,R.drawable.anuradha_mistry,R.drawable.rithesh_kini,R.drawable.tanvir_daphedar};
    private int[] biotech_fac={R.drawable.rajkumar_pathak,R.drawable.nitin_pereira,R.drawable.praseeda_nambisian,R.drawable.sruthi_pillai,R.drawable.abhijeet_kadam,R.drawable.nadeem_wadiwalla,R.drawable.haresh_kamdar};
    public static List<FacultyInformation> getData(int[] icons,String[] titles,String[] subtitles)
    {
        List<FacultyInformation> data=new ArrayList<>();
        for(int i=0;i<titles.length && i<icons.length && i<subtitles.length; i++)
        {
            FacultyInformation current=new FacultyInformation();
            current.iconId=icons[i% icons.length];
            current.title=titles[i%titles.length];
            current.subTitle=subtitles[i%subtitles.length];
            data.add(current);
        }
        return data;
    }
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        branch=getResources().getStringArray(R.array.branch_list);
        spinner= (Spinner) findViewById(R.id.faculty_spinner);
        ArrayAdapter<String> branchAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,branch);
        branchAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(branchAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recyclerView = (RecyclerView) findViewById(R.id.fac_recycler_view);
                switch (position) {
                    case 0:
                        adapter = new FacultyAdapter(getData(nofac, getResources().getStringArray(R.array.nolab), getResources().getStringArray(R.array.nosublab)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 1:
                        adapter = new FacultyAdapter(getData(comp_fac, getResources().getStringArray(R.array.comp_fac), getResources().getStringArray(R.array.comp_sub_fac)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 2:
                        adapter = new FacultyAdapter(getData(it_fac, getResources().getStringArray(R.array.it_fac), getResources().getStringArray(R.array.it_sub_fac)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 3:
                        adapter = new FacultyAdapter(getData(extc_fac, getResources().getStringArray(R.array.extc_fac), getResources().getStringArray(R.array.extc_sub_fac)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 4:
                        adapter = new FacultyAdapter(getData(chem_fac, getResources().getStringArray(R.array.chem_fac), getResources().getStringArray(R.array.chem_sub_fac)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 5:
                        adapter = new FacultyAdapter(getData(biomed_fac, getResources().getStringArray(R.array.biomed_fac), getResources().getStringArray(R.array.biomed_sub_fac)));
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case 6:
                        adapter = new FacultyAdapter(getData(biotech_fac, getResources().getStringArray(R.array.biotech_fac), getResources().getStringArray(R.array.biomed_sub_fac)));
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
        int id = item.getItemId();
        if(id==R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
