package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoFinal extends AppCompatActivity {

    private SharedPreferences prefs = null;
    private TextView resultado_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);

        resultado_final = findViewById(R.id.resultado_final);

        prefs = getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);

        resultado_final.setText(prefs.getString("prefs_puntaje",""));


    }
}