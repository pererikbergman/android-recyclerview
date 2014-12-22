package com.jayway.recyclerview.foldablelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayway.recyclerview.R;
import com.jayway.recyclerview.list.section.AbstractTreeNodeAdapter;
import com.jayway.recyclerview.list.section.TreeNode;

/**
 * Created by per-erik on 15/11/14.
 */
public class FoldableListAdapter extends AbstractTreeNodeAdapter<String, FoldableListAdapter.ViewHolder> {

    private final Context        mContext;
    private final LayoutInflater mInflater;

    public FoldableListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        int resourceId = 0;
        if (i == 1) {
            resourceId = R.layout.list_item_0;
        } else if (i == 2) {
            resourceId = R.layout.list_item_1;
        } else if (i == 3) {
            resourceId = R.layout.list_item_2;
        } else {
            resourceId = R.layout.list_item_3;
        }

        View view = inflater.inflate(resourceId, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(position, mData.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView  mTextView;
        private final ImageView mImageView;

        private int              mPosition;
        private TreeNode<String> mEntity;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.label);
            mImageView = (ImageView) v.findViewById(R.id.arrow);
        }

        public void bind(int position, TreeNode<String> entity) {
            mPosition = position;
            mEntity = entity;
            mTextView.setText(entity.getData().toString());
            mTextView.setOnClickListener(this);
            if (entity.size() == 0) {
                mImageView.setVisibility(View.INVISIBLE);
            } else {
                mImageView.setVisibility(View.VISIBLE);
            }

            updateArrow();
        }

        private void updateArrow() {
            if (mEntity.isOpen()) {
                mImageView.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                mImageView.setImageResource(android.R.drawable.arrow_up_float);
            }
        }

        @Override
        public String toString() {
            return "ViewHolder{" + mTextView.getText() + "}";
        }

        @Override
        public void onClick(View v) {
            mEntity.flip();
            invalidate();
            updateArrow();
        }
    }
}
