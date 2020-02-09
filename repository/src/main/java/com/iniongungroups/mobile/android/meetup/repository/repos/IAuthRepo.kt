package com.iniongungroups.mobile.android.meetup.repository.repos

import com.iniongungroups.mobile.android.meetup.entities.Auth
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

interface IAuthRepo {

    fun login(requestBody: HashMap<String, String>): Single<Auth>

    fun register(requestBody: HashMap<String, String>): Single<Auth>

}