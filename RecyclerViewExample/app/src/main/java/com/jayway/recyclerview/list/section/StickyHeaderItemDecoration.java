package com.jayway.recyclerview.list.section;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.jayway.recyclerview.foldablelist.FoldableListAdapter;

/**
 * Created by per-erik on 15/11/14.
 */
public class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {
    private final int                            mSectionType;
    private       FoldableListAdapter.ViewHolder mHeader;
    private       LinearLayoutManager            mLinearLayoutManager;
    private final Paint               paint          = new Paint();
    private       SparseArray<Bitmap> mBitmapHeaders = new SparseArray<Bitmap>();
    private       boolean             mInit          = false;
    private RecyclerView.Adapter mAdapter;

    public StickyHeaderItemDecoration(Context context, int sectionType) {
        paint.setColor(0xFFFF00FF);
        mSectionType = sectionType;
    }

    private void init(RecyclerView parent) {
        if (mLinearLayoutManager == null) {
            mLinearLayoutManager = (LinearLayoutManager) parent.getLayoutManager();
        }

        mAdapter = parent.getAdapter();
        mInit = true;
    }

    Bitmap fromView;
    int    last;


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        if (!mInit) {
            init(parent);
        }

        int current = getCurrentSelection(mLinearLayoutManager.findFirstVisibleItemPosition());
        if (current != last) {
            headerView = null;
            last = current;
        }

        fromView = mBitmapHeaders.get(current);
        if (fromView == null) {
            headerView = mLinearLayoutManager.findViewByPosition(current);
            fromView = loadBitmapFromView(headerView);
            mBitmapHeaders.put(current, fromView);
        }

        int next = getNextSection(current + 1);
        int offset = 0;
        if (next > current && next < mLinearLayoutManager.findLastVisibleItemPosition()) {
            int i = next - mLinearLayoutManager.findFirstVisibleItemPosition();
            View view = parent.getChildAt(i);

            int top = view.getTop();
            if (top < fromView.getHeight()) {
                offset = top - fromView.getHeight();
            }

            Bitmap nextView = loadBitmapFromView(view);
            mBitmapHeaders.put(next, nextView);
        }

        c.drawBitmap(fromView, 0, offset, paint);
    }

    View headerView;

    private int getCurrentSelection(int pos) {
        int first = pos;
        first += 1;
        int type = -1;
        do {
            first -= 1;
            type = mAdapter.getItemViewType(first);
        } while (type != mSectionType && first >= 0);

        return first;
    }

    private int getNextSection(int pos) {
        for (int i = pos + 1; i < mAdapter.getItemCount(); ++i) {
            if (mAdapter.getItemViewType(i) == mSectionType) {
                return i;
            }
        }

        return -1;
    }

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }


}
