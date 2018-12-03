package com.example.usuario.almacenamiento;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText texto,apellidos;
Button guardar;
TextView mostrar;
String miFichero = "Preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.editText);
        guardar = findViewById(R.id.Guardar);
        mostrar = findViewById(R.id.mostrar);
        apellidos = findViewById(R.id.editTextApellidos);


        SharedPreferences preferences = getSharedPreferences(miFichero, Context.MODE_PRIVATE);
        String nombre = preferences.getString("nombre","No existe");
        String apellido = preferences.getString("apellido", "No hay apellido");

        mostrar.setText(nombre+ " "+apellido);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences(miFichero, Context.MODE_PRIVATE);
                String nombre = texto.getText().toString();
                String apellido = apellidos.getText().toString();
                /*
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre", nombre);
                editor.commit();
                */

                preferences.edit().putString("nombre",nombre).commit();
                preferences.edit().putString("apellido",apellido).commit();
                mostrar.setText(nombre+" "+ apellido);

            }
        });


    }
}
