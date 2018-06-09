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

   Button btnView;
    List<DataModel> datamodel;
    RecyclerView recyclerView;
    RecyclerAdapter recycler;
    myDbAdapter myDbdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        btnView = (Button) findViewById(R.id.view1);
        datamodel = new ArrayList<DataModel>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

          btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbdapter = new myDbAdapter(DisplayList.this);
                datamodel = myDbdapter.getData();
                recycler = new RecyclerAdapter(datamodel);


                //Log.e("recycler", "DataModel");
                Log.e("Logdata",""+datamodel);
                RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(reLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);

            }
        });
    }
}
