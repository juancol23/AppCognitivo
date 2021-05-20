package com.valdemar.appcognitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdemar.appcognitivo.api.APIService;
import com.valdemar.appcognitivo.model.Reporte;
import com.valdemar.appcognitivo.util.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ResultadoFinal extends AppCompatActivity {

    private SharedPreferences prefs = null;
    private TextView resultado_final;
    int buenas = 0;
    int malas = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);



        DatabaseReference myRef = database.getReference("usuarios");



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

       // apiService = ApiUtils.getAPIService();
        getPost(usuario.getNombre(), usuario.getNota());

    }

    public void sendPost(String title, String body) {
        // RxJava
        apiService.savePost(title, body).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Reporte>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("e: "+e);
                    }

                    @Override
                    public void onNext(Reporte post) {
                        showResponse(post.toString());
                    }
                });


    }

    public void getPost(String title, String body) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("localhost:8080/api/v1/reporte")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<List<Reporte>> call = apiService.groupList();

        APIService service = retrofit.create(APIService.class);

        // this does not compile
        // error: <anonymous com.somewhere.utilities.Utilities$1> is not
        // abstract and does not override abstract method
        // onFailure(Call<List<EmployeeEndpointResponse>>,Throwable) in Callback
        call.enqueue(new Callback<List<Reporte>>() {
            @Override
            public void onResponse(Call<List<Reporte>> call, Response<List<Reporte>> response) {
                List<Reporte> myList = response.body();
                showResponse(myList.toString());
                System.out.println("ca: "+response.body());
                System.out.println("ca: "+response.body());

            }

            @Override
            public void onFailure(Call<List<Reporte>> call, Throwable t) {
                System.out.println("ca: "+call +" "+ "t: "+t.getMessage());
                System.out.println("ca: "+call +" "+ "t: "+t.getMessage());
            }


        });


        call.enqueue(new Callback<List<Reporte>>() {
            @Override
            public void onResponse(Call<List<Reporte>> call, Response<List<Reporte>> response) {
                // handle response here
                List<Reporte> employeeEndpointResponse = (List<Reporte>)response.body();
                System.out.println("ca: "+response.body());
                System.out.println("ca: "+response.body());

            }

            @Override
            public void onFailure(Call<List<Reporte>> call, Throwable t) {
                System.out.println("ca: "+call +" "+ "t: "+t.getMessage());
                System.out.println("ca: "+call +" "+ "t: "+t.getMessage());



            }
        });




    }

    public void showResponse(String response) {
        Toast.makeText(getApplicationContext(),""+response,Toast.LENGTH_LONG).show();
    }

}