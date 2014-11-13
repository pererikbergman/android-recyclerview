package com.jayway.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.jayway.recyclerview.basiclist.BasicListActivity;
import com.jayway.recyclerview.foldablelist.FoldableListActivity;
import com.jayway.recyclerview.sectionlist.SectionListActivity;


public class RecyclerViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_basic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(
                                RecyclerViewActivity.this,
                                BasicListActivity.class
                        )
                );
            }
        });

        findViewById(R.id.btn_section).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(
                                RecyclerViewActivity.this,
                                SectionListActivity.class
                        )
                );
            }
        });

        findViewById(R.id.btn_foldable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(
                                RecyclerViewActivity.this,
                                FoldableListActivity.class
                        )
                );
            }
        });
    }
}
