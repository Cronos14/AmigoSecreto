package com.tadeo.amigosecreto.adapters.holders;


import android.view.View;
import android.widget.TextView;

import com.tadeo.amigosecreto.R;
import com.tadeo.amigosecreto.models.Opcion;

/**
 * Created by Tadeo-developer on 18/01/16.
 */
public class OpcionViewHolder extends ViewHolder {


    private TextView txtOpcion;
    private Opcion opcion;


    public OpcionViewHolder(View itemView) {
        super(itemView);

        txtOpcion = (TextView) itemView.findViewById(R.id.opcion);
    }

    @Override
    public void bind(Object obj) {


        if (obj instanceof Opcion) {
            opcion = (Opcion) obj;
        }


    }


}