package com.tadeo.amigosecreto.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tadeo.amigosecreto.R;
import com.tadeo.amigosecreto.adapters.OpcionAdapter;
import com.tadeo.amigosecreto.models.Opcion;
import com.tadeo.amigosecreto.utils.Singleton;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 26/12/16.
 */

public class OpcionesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Opcion> data;
    private OpcionAdapter<Opcion> adapter;
    private FloatingActionButton add;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.opciones_fragment,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.general_recycler);

        add = (FloatingActionButton)view.findViewById(R.id.fab);

        recyclerView = (RecyclerView)view.findViewById(R.id.general_recycler);
        recyclerView.setHasFixedSize(true);

        data = new ArrayList<>();

        adapter = new OpcionAdapter<>(data,R.layout.row_opcion);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                manager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Opcion dataSelected = data.get(recyclerView.getChildAdapterPosition(view));

                if(dataSelected!=null) {

                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        data.clear();

        for(Opcion opcion : Singleton.getInstance().getFactoryLogin().getOpciones()){
            data.add(opcion);
        }

        adapter.notifyDataSetChanged();

    }
}
