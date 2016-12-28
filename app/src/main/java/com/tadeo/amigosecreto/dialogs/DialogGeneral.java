package com.tadeo.amigosecreto.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.tadeo.amigosecreto.R;

/**
 * Created by raul.gonzalez on 28/12/2015.
 */
public class DialogGeneral extends DialogFragment {

    public interface OnClickListener{
        public void onClick(boolean flag);
    }

    private OnClickListener onClickListener;
    private String titulo;
    private String descripcion;
    private int numeroBotones;

    public void setParametros(String titulo, String descripcion, int numeroBotones){

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.numeroBotones = numeroBotones;

    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_general,null);

        TextView textoTitulo = (TextView)view.findViewById(R.id.dialog_general_texto_titulo);
        TextView textoGeneral = (TextView)view.findViewById(R.id.dialog_general_texto_general);
        textoTitulo.setText(titulo);
        textoGeneral.setText(descripcion);

        alerta.setView(view);

        alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(onClickListener!=null)
                    onClickListener.onClick(true);

                dismiss();
            }
        });
        if(numeroBotones>=2) {
            alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(onClickListener!=null)
                        onClickListener.onClick(false);
                    dismiss();
                }
            });
        }





        return alerta.create();
    }
}
