package com.jayway.recyclerview.sectionlist;

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
public class SectionListAdapter extends AbstractTreeNodeAdapter<String, SectionListAdapter.ViewHolder> {

    private final Context        mContext;
    private final LayoutInflater mInflater;

    public SectionListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        int resourceId = R.layout.section_header;
        if (i == 2) {
            resourceId = R.layout.section_item;
        }

        View view = inflater.inflate(resourceId, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(mData.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        private TreeNode<String> mEntity;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.label);
        }

        public void bind(TreeNode<String> entity) {
            mEntity = entity;
            mTextView.setText(entity.getData().toString());
        }

        @Override
        public String toString() {
            return "ViewHolder{" + mTextView.getText() + "}";
        }

    }
}
