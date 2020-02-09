package com.iniongungroups.mobile.android.meetup.network.services

import com.iniongungroups.mobile.android.meetup.entities.Auth
import io.reactivex.Single
import retrofit2.http.POST

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

interface AuthService {

    @POST("login")
    fun login(requestBody: HashMap<String, String>): Single<Auth>

    @POST("register")
    fun register(requestBody: HashMap<String, String>): Single<Auth>

}