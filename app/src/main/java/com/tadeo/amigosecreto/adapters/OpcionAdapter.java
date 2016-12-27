package com.tadeo.amigosecreto.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.tadeo.amigosecreto.adapters.holders.OpcionViewHolder;
import com.tadeo.amigosecreto.adapters.holders.ViewHolder;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 10/06/16.
 */
public class OpcionAdapter<T> extends AdapterGeneral {

    protected final int VIEW_PROG = 0;
    protected final int VIEW_ITEM = 1;
    protected final int VIEW_HEADER = 2;

    public OpcionAdapter(ArrayList<T> objects, int layout){
        super(objects,layout);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = getViewInflater(parent);

        ViewHolder viewHolder = new OpcionViewHolder(itemView);
        itemView.setOnClickListener(this);
        return viewHolder;
    }


}
