package com.iniongungroups.mobile.android.meetup.network.services

import com.iniongungroups.mobile.android.meetup.entities.Auth
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

interface AuthService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("login")
    fun login(@Body requestBody: HashMap<String, String>): Single<Auth>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("register")
    fun register(@Body requestBody: HashMap<String, String>): Single<Auth>

}