package com.example.chat_application.Fragments;

import com.example.chat_application.Notifications.MyResponse;
import com.example.chat_application.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AIzaSyCljUIZCvDMpPiBiZdG3IDiW4gMzH494Sk"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
