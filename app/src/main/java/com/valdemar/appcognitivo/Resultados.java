package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Resultados extends AppCompatActivity {

    private RecyclerView mRecyclerPrincipal;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);


        initRecicler();
    }

    private void initRecicler() {
        mRecyclerPrincipal = findViewById(R.id.resultados_recycler);
        mRecyclerPrincipal.setHasFixedSize(true);

        mRecyclerPrincipal.setLayoutManager(new GridLayoutManager(this,
                3, LinearLayoutManager.VERTICAL, false));

        mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        mDatabase.keepSynced(true);
        FirebaseRecyclerAdapter<Usuario, CuentosViewHolder> firebaseRecyclerAdapterPrincipal =
                new FirebaseRecyclerAdapter<Usuario, CuentosViewHolder>(
                        Usuario.class,
                        R.layout.album_card,
                        CuentosViewHolder.class,
                        mDatabase

                ) {
                    @Override
                    protected void populateViewHolder(final CuentosViewHolder viewHolder, Usuario model, final int position) {
                        final String post_key = getRef(position).getKey();
                        viewHolder.setNombre(model.getNombre());
                        viewHolder.setNota(model.getNota());
                        viewHolder.setHora(model.getNota());

                        viewHolder.mViewStructure.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               // viewDetails(post_key,model.getTitulo(),model.getImagen(),model.getDescripcion());
                            }
                        });

                    }
                };

        mRecyclerPrincipal.setAdapter(firebaseRecyclerAdapterPrincipal);

    }
}