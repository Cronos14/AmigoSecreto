package com.tadeo.amigosecreto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.tadeo.amigosecreto.models.FactoryLogin;
import com.tadeo.amigosecreto.tasks.Tarea;
import com.tadeo.amigosecreto.tasks.TareaLogin;
import com.tadeo.amigosecreto.utils.Singleton;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView nombreUsuario;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombreUsuario = (AutoCompleteTextView)findViewById(R.id.user);
        entrar = (Button)findViewById(R.id.btn_login);

        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        String name = sharedPreferences.getString("name","null");

        if(name!=null && !name.equalsIgnoreCase("null")){
            invocarServicio(name);
        }

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(nombreUsuario.getText())){
                    invocarServicio(nombreUsuario.getText().toString());
                }else{
                    nombreUsuario.setError("Campo Vacio");
                }
            }
        });


    }

    private void invocarServicio(String name){
        TareaLogin tareaLogin = new TareaLogin(LoginActivity.this,"Entrando...");
        tareaLogin.setOnPostExecuteListener(new Tarea.OnPostExecuteListener() {
            @Override
            public void onPostExecute(Object object) {
                if(object instanceof FactoryLogin){
                    FactoryLogin factoryLogin = (FactoryLogin)object;
                    Singleton.getInstance().setFactoryLogin(factoryLogin);

                    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",factoryLogin.getUsuario().getNombre());
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                    finish();

                }
            }
        });

        tareaLogin.execute(name);
    }
}
