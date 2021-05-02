package com.valdemar.appcognitivo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CuentosViewHolder extends RecyclerView.ViewHolder{
    public View mViewStructure;
    public TextView nota_resultado;
    public TextView nombre_resultado;
    public TextView fecha_resultado;

    public CuentosViewHolder(@NonNull View itemView) {
        super(itemView);
        mViewStructure = itemView ;
        nota_resultado =itemView.findViewById(R.id.nota_resultado);
        nombre_resultado =itemView.findViewById(R.id.nombre_resultado);
        fecha_resultado =itemView.findViewById(R.id.fecha_resultado);
    }

    public void setNota(String title){
        nota_resultado.setText(title);
    }

    public void setNombre(String title){
        nombre_resultado.setText(title);
    }

    public void setHora(String hora) {
        nombre_resultado.setText(hora);

    }
}
