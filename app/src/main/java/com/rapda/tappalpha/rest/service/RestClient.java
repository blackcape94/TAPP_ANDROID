package com.rapda.tappalpha.rest.service;

import android.util.Base64;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by kumarrus on 09-03-2015.
 */
public class RestClient {
    private static ApiService REST_API = null;

    private RestClient() {}

    public static ApiService api() {
        return REST_API;
    }

    public static void setupRestClient() {
        setupRestClient(null, null);
    }

    public static void setupRestClient(String username, String password) {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(ApiService.BASE_URL)
                .setConverter(new GsonConverter(new Gson()))
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        if(username != null && password != null) {
            // concatenate username and password with colon for authentication
            final String credentials = username + ":" + password;

            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    // create Base64 encoded string
                    String auth = "Basic " + Base64.encodeToString(
                            credentials.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", auth);
                    request.addHeader("Accept", "application/json");
                }
            });
        }

        RestAdapter restAdapter = builder.build();
        REST_API = restAdapter.create(ApiService.class);
    }
}
