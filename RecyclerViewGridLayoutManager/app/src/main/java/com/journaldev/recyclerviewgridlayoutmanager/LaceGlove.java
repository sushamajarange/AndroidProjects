package com.journaldev.recyclerviewgridlayoutmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class LaceGlove extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Button prev, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lace_glove);


        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.next);
        prev = (Button) findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == next) {
                    viewFlipper.showNext();
                }
                else if (v == prev) {
                    viewFlipper.showPrevious();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == next) {
                    viewFlipper.showNext();
                }
                else if (v == prev) {
                    viewFlipper.showPrevious();
                }
            }
        });
    }
}
