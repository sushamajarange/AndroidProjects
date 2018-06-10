package com.example.sushamapatekar.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DisplayList extends AppCompatActivity {

    List<DataModel> datamodel;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    myDbAdapter myDbdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        datamodel = new ArrayList<DataModel>();

        myDbdapter = new myDbAdapter(DisplayList.this);
        datamodel = myDbdapter.getData();
        recyclerAdapter = new RecyclerAdapter(datamodel);
        
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayList.this));

    }
}
