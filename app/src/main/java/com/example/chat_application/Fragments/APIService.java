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
                    "Authorization:key=AAAAcPdlwOo:APA91bHA3n6huxbYKWf5n7A__Ai7qt4SPMG8azdASKmMhmRsI4kuMrZMbXt-7zyxqamxYGwzTNYHHkn0tn_tToueOBcNY20E7UGNKTOL3OACtI-CS5qi7_xs6pPIB6S5nL8wkLMIrrnC"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
