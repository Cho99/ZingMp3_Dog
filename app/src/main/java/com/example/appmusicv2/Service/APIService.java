package com.example.appmusicv2.Service;

public class APIService {
    private static String base_url = "https://dog-99.000webhostapp.com/";

    public static Dataservice getService() {
        return  APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
