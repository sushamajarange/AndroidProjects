package com.example.sushamapatekar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    Button addCust;
    Button delCust;
    static  Button viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        //delCust = (Button) findViewById(R.id.deleteCustomer);

        AddCustomerButton();
        ViewListMeth();

    }
    public void AddCustomerButton(){
       addCust = (Button) findViewById(R.id.buttonAdd);
        addCust.setOnClickListener(new OnClickListener(){
            public void  onClick(View v){
                Intent intent = new Intent(MainActivity.this, AddCustomerActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ViewListMeth(){
        viewList = (Button) findViewById(R.id.buttonList);
        viewList.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayList.class);
                startActivity(intent);

            }
        });
    }
}
