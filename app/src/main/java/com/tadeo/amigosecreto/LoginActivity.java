package com.tadeo.amigosecreto;

import android.content.Intent;
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

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(nombreUsuario.getText())){
                    TareaLogin tareaLogin = new TareaLogin(LoginActivity.this,"Entrando...");
                    tareaLogin.setOnPostExecuteListener(new Tarea.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(Object object) {
                            if(object instanceof FactoryLogin){
                                FactoryLogin factoryLogin = (FactoryLogin)object;
                                Singleton.getInstance().setFactoryLogin(factoryLogin);

                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);

                            }
                        }
                    });

                    tareaLogin.execute(nombreUsuario.getText().toString());
                }else{
                    nombreUsuario.setError("Campo Vacio");
                }
            }
        });


    }
}
