package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menusss extends AppCompatActivity {

    private Button validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suma);
        validar = findViewById(R.id.validar);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(Menusss.this, MainActivity.class));
                setContentView(R.layout.ordenado);
                validar = findViewById(R.id.validar);
                validar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //  startActivity(new Intent(Menusss.this, MainActivity.class));
                        setContentView(R.layout.ordenado_colores);
                        validar = findViewById(R.id.validar);
                        validar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //  startActivity(new Intent(Menusss.this, MainActivity.class));
                                setContentView(R.layout.resta);
                                validar = findViewById(R.id.validar);
                                validar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //  startActivity(new Intent(Menusss.this, MainActivity.class));
                                        setContentView(R.layout.encuentra_numero);

                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}