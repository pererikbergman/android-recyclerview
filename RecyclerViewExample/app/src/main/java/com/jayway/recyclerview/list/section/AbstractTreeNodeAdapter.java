package com.jayway.recyclerview.list.section;


import android.support.v7.widget.RecyclerView;

import com.jayway.recyclerview.list.basic.AbstractListAdapter;

import java.util.List;

public abstract class AbstractTreeNodeAdapter<V, K extends RecyclerView.ViewHolder> extends AbstractListAdapter<TreeNode<V>, K> {

    private TreeNode<V> mRoot;

    public AbstractTreeNodeAdapter() {

    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getDepth();
    }

    public void setTree(TreeNode<V> root) {
        mRoot = root;
        List<TreeNode<V>> data = mRoot.toList();
        setData(data);
    }

    protected void invalidate() {
        setTree(mRoot);
    }
}