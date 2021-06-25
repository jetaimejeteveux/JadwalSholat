package com.example.jadwalshalat.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jadwalshalat.R;
import com.example.jadwalshalat.view.adapter.SholatAdapter;
import com.example.jadwalshalat.data.local.AppDatabase;
import com.example.jadwalshalat.data.local.DataModel;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
 private SholatAdapter sholatAdapter;
 private RecyclerView rvSholat;
 private AppDatabase appDatabase;
 private ArrayList<DataModel> listSholat = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        rvSholat = findViewById(R.id.readactivity_rv_sholat);
        sholatAdapter=new SholatAdapter(getApplicationContext());
        sholatAdapter.notifyDataSetChanged();
        if(appDatabase == null){
            appDatabase=AppDatabase.initDatabase(getApplicationContext());
        }
        listSholat.addAll(appDatabase.sholatDAO().getSholat());
            sholatAdapter.setData(listSholat);



        rvSholat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvSholat.setAdapter(sholatAdapter);
    }
}
