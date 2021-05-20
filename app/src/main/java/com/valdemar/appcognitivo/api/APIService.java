package com.valdemar.appcognitivo.api;

import com.valdemar.appcognitivo.model.Reporte;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface APIService {


    @POST("api/v1/reporte")
    @FormUrlEncoded
    Observable<Reporte> savePost(@Field("nombre") String nombre,
                                 @Field("nota") String nota);

    @GET("api/v1/reporte")
    Call<List<Reporte>> groupList();

}
