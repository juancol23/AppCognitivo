package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ResultadoFinal extends AppCompatActivity {

    private SharedPreferences prefs = null;
    private TextView resultado_final;
    int buenas = 0;
    int malas = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);



        DatabaseReference myRef = database.getReference("message");



        resultado_final = findViewById(R.id.resultado_final);

        prefs = getSharedPreferences("com.valdemar.appcognitivo", MODE_PRIVATE);


        String listaPuntajeOld = prefs.getString("prefs_puntaje","").replace("[", "");
        String listaPuntajeNew = listaPuntajeOld.replace("]", "");

        String listaCalificacion [] = listaPuntajeNew.split(",");
        for (int i = 0; i<10; i++) {
            if (listaCalificacion[i].trim().equalsIgnoreCase("true")) {
                buenas = buenas + 1;
            } else {
                malas = malas + 1;
            }
            if( i == 9){
                System.out.println(buenas);
                System.out.println(malas);
                resultado_final.setText(prefs.getString("prefs_notificacion","")+" Aprobaste "+buenas+" de 10");
            }
            if( i == 10){

                System.out.println(buenas);
                System.out.println(malas);
                resultado_final.setText(prefs.getString("prefs_notificacion","")+" Aprobaste "+malas+" de 10");
            }
        }

        Usuario usuario = new Usuario(prefs.getString("prefs_notificacion",""), buenas + " de 10");

        myRef.push().setValue(usuario);




    }
}