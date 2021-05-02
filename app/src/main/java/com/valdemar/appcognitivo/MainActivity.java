package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout btnBuscadorNumero;
    private LinearLayout resultados;

    private SharedPreferences prefs = null;
    private TextView nombre_principal_seteado;
    private TextView email_principal_seteado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre_principal_seteado = findViewById(R.id.nombre_principal_seteado);
        email_principal_seteado = findViewById(R.id.email_principal_seteado);

        prefs = getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);

        nombre_principal_seteado.setText(prefs.getString("prefs_notificacion",""));
        email_principal_seteado.setText(prefs.getString("prefs_notificacion","")+"@gmail.com");

        prefs.edit().putString("prefs_puntaje", "").commit();


        btnBuscadorNumero = findViewById(R.id.btnBuscadorNumero);
        btnBuscadorNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BuscarNumeroActivity.class));

            }
        });

        resultados = findViewById(R.id.resultados);
        resultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Resultados.class));

            }
        });

    }
}