package com.jayway.recyclerview.sectionlist;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jayway.recyclerview.R;
import com.jayway.recyclerview.list.section.StickyHeaderItemDecoration;
import com.jayway.recyclerview.list.section.TreeNode;

/**
 * Created by per-erik on 16/11/14.
 */
public class SectionListActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.jayway.recyclerview.R.layout.activity_recycler_view_example);

        mRecyclerView = (RecyclerView) findViewById(com.jayway.recyclerview.R.id.recyclerview);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(new StickyHeaderItemDecoration(this, 1));
        mRecyclerView.setAdapter(getAdapter());

        final SwipeRefreshLayout swipeView = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeView.setRefreshing(true);
                swipeView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeView.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        getSupportActionBar().setTitle("Section List");
    }

    private RecyclerView.Adapter getAdapter() {
        SectionListAdapter sectionListAdapter = new SectionListAdapter(this);
        TreeNode<String> root = new TreeNode<String>("root");

        for (int i = 0; i < 10; ++i) {
            TreeNode<String> section = new TreeNode<String>("Section " + i);
            root.addChild(section);
            for (int j = 0; j < 10; ++j) {
                section.addChild(new TreeNode<String>("Item " + i + " " + j));
            }
        }

        sectionListAdapter.setTree(root);
        return sectionListAdapter;
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }
}
