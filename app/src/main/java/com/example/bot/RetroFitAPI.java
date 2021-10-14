package com.example.bot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface RetroFitAPI {

    @GET
    Call<MsgModel> getMessagae(@Url String url) ;

    }

