package com.example.yassin.emiratesapp.service;

import com.example.yassin.emiratesapp.model.CarJson;

import retrofit2.http.GET;
import rx.Observable;

/**
 *Created by yassin on 7/10/18.
 */

public interface CarsRestService {
    @GET("carsonline")
    Observable<CarJson> getCarsJson();
}