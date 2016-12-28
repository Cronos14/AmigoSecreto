package com.tadeo.amigosecreto.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tadeo.amigosecreto.R;


/**
 * Created by raul.gonzalez on 28/12/2015.
 */
public class DialogEditText extends DialogFragment {


    public interface OnClickListener{
        public void onClick(String textEditText);
    }

    private OnClickListener onClickListener;

    private String titulo;


    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_edit_text,null);
        final EditText campo = (EditText)view.findViewById(R.id.dialog_general_editText_general);
        TextView textoTitulo = (TextView)view.findViewById(R.id.dialog_general_texto_titulo);
        textoTitulo.setText(titulo);

        alert.setView(view);
        alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(onClickListener!=null)
                    onClickListener.onClick(campo.getText().toString());

                dismiss();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        return alert.create();
    }
}
