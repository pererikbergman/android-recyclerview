package com.jayway.recyclerview.list.section;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<K> {

    private K mData;

    private TreeNode<K>       mParent;
    private List<TreeNode<K>> mChildren;
    private boolean           mOpen;

    public TreeNode() {
        this(null);
    }

    public TreeNode(K data) {
        mParent   = null;
        mChildren = new ArrayList<TreeNode<K>>();
        mData     = data;
        mOpen     = true;
    }

    public TreeNode<K> addChild(TreeNode<K> child) {
        if (mChildren.contains(child) == false) {
            mChildren.add(child);
            child.mParent = this;
        }

        return this;
    }

    public TreeNode<K> removeChild(TreeNode<K> child) {
        if (mChildren.contains(child) == true) {
            mChildren.remove(child);
        }

        return this;
    }

    public TreeNode<K> findByData(K data) {
        if ( data.equals(mData)) {
            return this;
        }

        for( TreeNode<K> node : mChildren) {
            TreeNode<K> foundData = node.findByData(data);
            if ( foundData != null) {
                return foundData;
            }
        }

        return null;
    }

    public int size() {
        int count = mChildren.size();
        for (TreeNode<K> node : mChildren) {
            count += node.size();
        }

        return count;
    }

    public int getDepth() {
        int depth = 0;
        TreeNode<K> parent = mParent;
        while (parent!=null){
            depth++;
            parent = parent.mParent;
        }

        return depth;
    }

    public K getData() {
        return mData;
    }

    public List<TreeNode<K>> toList() {
        return toList(new ArrayList<TreeNode<K>>());
    }

    public List<TreeNode<K>> toList(List<TreeNode<K>> list) {
        if (mOpen==false)
            return list;

        for (TreeNode<K> node : mChildren) {
            list.add(node);
            node.toList(list);
        }

        return list;
    }

    public TreeNode<K> close() {
        mOpen = false;
        return this;
    }

    public TreeNode<K> open() {
        mOpen = true;
        return this;
    }

    public TreeNode<K> flip() {
        mOpen = !mOpen;
        return this;
    }

    public void dump() {
        if (mOpen==false)
            return;

        System.out.println(this.toString());

        for (TreeNode<K> node : mChildren) {
            node.dump();
        }
    }

    @Override
    public String toString() {
        if (mData==null){
            return "<no data>";
        }

        return mData.toString();
    }

    public boolean isOpen() {
        return mOpen;
    }
}
