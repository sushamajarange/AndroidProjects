package com.journaldev.recyclerviewgridlayoutmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Arabic Style", R.drawable.mehendi_icon, "#09A9FF"));
        arrayList.add(new DataModel("Dulhan", R.drawable.dulhan_icon, "#3E51B1"));
        arrayList.add(new DataModel("Bangle Style", R.drawable.bangle_icon, "#4BAA50"));
        arrayList.add(new DataModel("Lace Glove", R.drawable.lace_glove, "#F94336"));
        arrayList.add(new DataModel("Back Side", R.drawable.back_side, "#0A9B88"));
        arrayList.add(new DataModel("Feet", R.drawable.feet_icon, "#0AAFC7"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/
    }

    @Override
    public void onItemClick(DataModel item) {

        if (item.text == "Arabic Style"){
            Intent intent = new Intent(MainActivity.this, ArabicActivity.class);
            MainActivity.this.startActivity(intent);
        }
        else if (item.text == "Dulhan"){
            Intent intent = new Intent(this,Dulhan.class);
            startActivity(intent);
        }
        else if (item.text == "Bangle Style"){
            Intent intent = new Intent(this,BangleStyle.class);
            startActivity(intent);
        }
        else if (item.text == "Lace Glove"){
            Intent intent = new Intent(this,LaceGlove.class);
            startActivity(intent);
        }
        else if (item.text == "Back Side"){
            Intent intent = new Intent(this,BackSide.class);
            startActivity(intent);
        }
        else if (item.text == "Feet"){
            Intent intent = new Intent(this,Feet.class);
            startActivity(intent);
        }

        //Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
    }
}
