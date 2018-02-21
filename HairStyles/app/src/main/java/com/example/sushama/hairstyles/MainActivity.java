package com.example.sushama.hairstyles;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import me.relex.circleindicator.CircleIndicator;
import static me.relex.circleindicator.R.styleable.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static Button btnEnter;
    private static final Integer[] XMEN = {R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth, R.drawable.sixth};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickButtonListener();
        init();

    }

    public void onClickButtonListener(){
        //btnEnter = (Button) findViewById(R.id.enterIn);
        android.widget.Button BtnEnter = (android.widget.Button) findViewById(R.id.enterIn);
        btnEnter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Start new Activity
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

    }


    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this, XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }


}
