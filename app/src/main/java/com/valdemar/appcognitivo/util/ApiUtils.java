package com.valdemar.appcognitivo.util;

import com.valdemar.appcognitivo.api.APIService;
import com.valdemar.appcognitivo.rest.RetrofitClient;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "";

    public static APIService getAPIService() {

        return RetrofitClient.getClient("").create(APIService.class);
    }
}
