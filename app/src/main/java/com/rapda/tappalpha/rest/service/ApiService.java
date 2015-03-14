package com.tapp.tappstudio.rest.service;

import retrofit.Callback;
import retrofit.http.POST;

/**
 * Created by kumarrus on 09-03-2015.
 */
public interface ApiService {
    public static String BASE_URL = "http://192.168.2.20/tapp";

    @POST("/login")
    void login(Callback<String> callback);

    @POST("/register")
    void register(Callback<String> callback);
}
