package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class BuscarNumeroActivity extends AppCompatActivity {

    private int numeroAleatorioPrincipal;
    private int valorSeleccionado;
    private boolean seleccion;


    private TextView encuentra_numero_text;

    private static Typeface Pacifico;
    private TextView mPrimero;
    private TextView mSegundo;
    private TextView mTercero;
    private TextView mCuarto;
    private TextView mQuinto;


    private RelativeLayout mPrimeroR;
    private RelativeLayout mSegundoR;
    private RelativeLayout mTerceroR;
    private RelativeLayout mCuartoR;
    private RelativeLayout mQuintoR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_numero);

        iniciarNuevamente();
    }

    private void iniciarNuevamente() {
        Random rd = new Random();
        //  numeroAleatorioPrincipal = rd.nextInt(5);



        List<Integer> generados = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int posible = rd.nextInt(10);
                if (!generados.contains(posible)) {
                    generados.add(posible);
                    aleatorio = posible;
                    generado = true;
                }
            }
            if(i == 5){
                initFonts(generados, generados.get(2));
            }
            System.out.println("Aleatorio: "+aleatorio);
        }
        initSeleccionEmpty();

        initClicks();
    }


    private void initSeleccionEmpty() {

        mPrimeroR = findViewById(R.id.seleccion_primero);
        mPrimeroR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.white));

        mSegundoR= findViewById(R.id.seleccion_segundo);
        mSegundoR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.white));



        mTerceroR= findViewById(R.id.seleccion_tercero);
        mTerceroR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.white));

        mCuartoR = findViewById(R.id.seleccion_cuarto);

        mCuartoR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.white));

        mQuintoR = findViewById(R.id.seleccion_quinto);

        mQuintoR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.white));

    }

    private void initClicks() {

        mPrimeroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty();
                valorSeleccionado = Integer.parseInt(mPrimero.getText().toString());
                seleccion = true;
                mPrimeroR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.gray));

            }
        });
        mSegundoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty();
                valorSeleccionado = Integer.parseInt(mSegundo.getText().toString());
                seleccion = true;
                mSegundoR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.gray));

            }
        });
        mTerceroR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty();
                valorSeleccionado = Integer.parseInt(mTercero.getText().toString());
                seleccion = true;
                mTerceroR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.gray));

            }
        });
        mCuartoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty();
                valorSeleccionado = Integer.parseInt(mCuarto.getText().toString());
                seleccion = true;
                mCuartoR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.gray));

            }
        });
        mQuintoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeleccionEmpty();
                valorSeleccionado = Integer.parseInt(mQuinto.getText().toString());
                seleccion = true;
                mQuintoR.setBackgroundColor(ContextCompat.getColor(BuscarNumeroActivity.this, R.color.gray));

            }
        });

        Button validar = findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccion){
                    //Toast.makeText(BuscarNumeroActivity.this,"Por favor seleccione una opcción.",Toast.LENGTH_LONG).show();
                    showSnackBar("¡Por favor seleccione una opcción valida!");
                }else{
                    if(valorSeleccionado == numeroAleatorioPrincipal){
                        //Toast.makeText(BuscarNumeroActivity.this,"Seleccionó "+valorSeleccionado,Toast.LENGTH_SHORT).show();
                        showSnackBar("¡Muy bien!");
                        iniciarNuevamente();

                    }else{
                        //Toast.makeText(BuscarNumeroActivity.this,"Incorrecto "+valorSeleccionado,Toast.LENGTH_SHORT).show();
                        showSnackBar("¡Oh no fallaste!");
                    }
                }
            }
        });

    }

    public void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.container), msg, Snackbar.LENGTH_LONG)
                .show();
    }
    private void initFonts(List<Integer> generados, int a) {


        numeroAleatorioPrincipal = a;



        String pacificoFuente= "fuentes/BloodLust.ttf";
        this.Pacifico = Typeface.createFromAsset(getAssets(),pacificoFuente);
        mPrimero = findViewById(R.id.primero);
        mPrimero.setTypeface(Pacifico);
        mSegundo = findViewById(R.id.segundo);
        mSegundo.setTypeface(Pacifico);
        mTercero = findViewById(R.id.tercero);
        mTercero.setTypeface(Pacifico);
        mCuarto = findViewById(R.id.cuarto);
        mCuarto.setTypeface(Pacifico);
        mQuinto = findViewById(R.id.quinto);
        mQuinto.setTypeface(Pacifico);

        mPrimero.setText(generados.get(0).toString());
        mSegundo.setText(generados.get(1).toString());
        mTercero.setText(generados.get(2).toString());
        mCuarto.setText(generados.get(3).toString());
        mQuinto.setText(generados.get(4).toString());

        encuentra_numero_text = findViewById(R.id.encuentra_numero_text);
        encuentra_numero_text.setText("Encuentra el número "+ this.numeroAleatorioPrincipal +":");
    }


}