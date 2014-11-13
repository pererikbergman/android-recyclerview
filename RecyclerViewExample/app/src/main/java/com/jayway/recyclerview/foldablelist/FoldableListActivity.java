package com.jayway.recyclerview.foldablelist;

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
public class FoldableListActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);

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

        getSupportActionBar().setTitle("Foldable List");
    }

    private RecyclerView.Adapter getAdapter() {
        FoldableListAdapter foldableListAdapter = new FoldableListAdapter(this);

        TreeNode<String> root = new TreeNode<String>("View");

        root.addChild(new TreeNode<String>("AnalogClock"));
        root.addChild(new TreeNode<String>("ImageView"));
        root.findByData("ImageView").addChild(new TreeNode<String>("ImageButton"));
        root.findByData("ImageView").addChild(new TreeNode<String>("QuickContactBadge"));
        root.addChild(new TreeNode<String>("KeyboardView"));
        root.addChild(new TreeNode<String>("ProgressBar"));
        root.addChild(new TreeNode<String>("Space"));
        root.addChild(new TreeNode<String>("SurfaceView"));
        root.findByData("SurfaceView").addChild(new TreeNode<String>("GLSurfaceView"));
        root.findByData("SurfaceView").addChild(new TreeNode<String>("VideoView"));
        root.addChild(new TreeNode<String>("TextureView"));
        root.addChild(new TreeNode<String>("TextView"));
        root.findByData("TextView").addChild(new TreeNode<String>("Button"));
        root.findByData("Button").addChild(new TreeNode<String>("CompoundButton"));
        root.findByData("CompoundButton").addChild(new TreeNode<String>("CheckBox"));
        root.findByData("CompoundButton").addChild(new TreeNode<String>("RadioButton"));
        root.findByData("CompoundButton").addChild(new TreeNode<String>("Switch"));
        root.findByData("CompoundButton").addChild(new TreeNode<String>("ToggleButton"));
        root.findByData("TextView").addChild(new TreeNode<String>("CheckedTextView"));
        root.findByData("TextView").addChild(new TreeNode<String>("Chromometer"));
        root.findByData("TextView").addChild(new TreeNode<String>("DigitalClock"));
        root.findByData("TextView").addChild(new TreeNode<String>("EditText"));
        root.findByData("EditText").addChild(new TreeNode<String>("AutoCompleteTextView"));
        root.findByData("AutoCompleteTextView").addChild(new TreeNode<String>("MultiAutoCompleteTextView"));
        root.findByData("TextView").addChild(new TreeNode<String>("TextClock"));
        root.addChild(new TreeNode<String>("ViewStub"));
        root.addChild(new TreeNode<String>("ViewGroup"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("AbsoluteLayout"));
        root.findByData("AbsoluteLayout").addChild(new TreeNode<String>("WebView"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("AdapterView"));
        root.findByData("AdapterView").addChild(new TreeNode<String>("AbsListView"));
        root.findByData("AbsListView").addChild(new TreeNode<String>("GridView"));
        root.findByData("AbsListView").addChild(new TreeNode<String>("ListView"));
        root.findByData("AdapterView").addChild(new TreeNode<String>("AbsSpinner"));
        root.findByData("AbsSpinner").addChild(new TreeNode<String>("Gallery"));
        root.findByData("AbsSpinner").addChild(new TreeNode<String>("Spinner"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("DrawerLayout"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("FragmentBreadCrumbs"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("FrameLayout"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("AppWidgetHostView"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("CalendarView"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("DatePicker"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("GestureOverlayView"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("HorizontalScrollView"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("MediaController"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("ScrollView"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("TabHost"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("TimePicker"));
        root.findByData("FrameLayout").addChild(new TreeNode<String>("ViewAnimator"));
        root.findByData("ViewAnimator").addChild(new TreeNode<String>("ViewFlipper"));
        root.findByData("ViewAnimator").addChild(new TreeNode<String>("ViewSwitcher"));
        root.findByData("ViewSwitcher").addChild(new TreeNode<String>("ImageSwitcher"));
        root.findByData("ViewSwitcher").addChild(new TreeNode<String>("TextSwitcher"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("GridLayout"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("LinearLayout"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("NumberPicker"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("RadioGroup"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("SearchView"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("TabWidget"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("TableLayout"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("TableRow"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("ZoomControls"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("PagerTileStrip"));
        root.findByData("PagerTileStrip").addChild(new TreeNode<String>("PagerTabStrip"));
        root.findByData("LinearLayout").addChild(new TreeNode<String>("RelativeLayout"));
        root.findByData("RelativeLayout").addChild(new TreeNode<String>("DialerFilter"));
        root.findByData("RelativeLayout").addChild(new TreeNode<String>("TwoLineListItem"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("SlidingDrawer"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("SlidingPaneLayout"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("SwipeRefreshLayout"));
        root.findByData("ViewGroup").addChild(new TreeNode<String>("ViewPager"));

        foldableListAdapter.setTree(root);
        return foldableListAdapter;
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }
}
