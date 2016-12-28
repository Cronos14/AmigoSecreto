package com.tadeo.amigosecreto.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tadeo.amigosecreto.R;
import com.tadeo.amigosecreto.adapters.OpcionAdapter;
import com.tadeo.amigosecreto.dialogs.DialogGeneral;
import com.tadeo.amigosecreto.models.Opcion;
import com.tadeo.amigosecreto.models.Usuario;
import com.tadeo.amigosecreto.utils.Singleton;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 26/12/16.
 */

public class AmigoSecretoFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Opcion> data;
    private OpcionAdapter<Opcion> adapter;
    private Button verAmigoSecreto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.amigo_secreto_fragment,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.general_recycler);

        verAmigoSecreto = (Button) view.findViewById(R.id.ver_amigo_secreto);

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

       verAmigoSecreto.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Usuario personaSecreta = Singleton.getInstance().getFactoryLogin().getPersonaSecreta();
               if(personaSecreta.getNombre()==null || personaSecreta.getNombre().isEmpty()){
                   DialogGeneral dialogGeneral = new DialogGeneral();
                   dialogGeneral.setParametros("Tu amigo secreto","Aun no tienes un amigo secreto :(",1);
                   dialogGeneral.setOnClickListener(new DialogGeneral.OnClickListener() {
                       @Override
                       public void onClick(boolean flag) {

                       }
                   });
                   dialogGeneral.show(getFragmentManager(),"dialog");
               }else {

                   DialogGeneral dialogGeneral = new DialogGeneral();
                   dialogGeneral.setParametros("Tu amigo secreto", Singleton.getInstance().getFactoryLogin().getPersonaSecreta().getNombre(), 1);
                   dialogGeneral.setOnClickListener(new DialogGeneral.OnClickListener() {
                       @Override
                       public void onClick(boolean flag) {

                           data.clear();
                           for (Opcion opcion : Singleton.getInstance().getFactoryLogin().getOpcionesPersonaSecreta()) {
                               data.add(opcion);
                           }

                           adapter.notifyDataSetChanged();

                       }
                   });
                   dialogGeneral.show(getFragmentManager(), "dialog");
               }
           }

       });

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();



    }
}
