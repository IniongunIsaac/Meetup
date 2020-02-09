package com.iniongungroups.mobile.android.meetup.network.repositoryImpl

import com.iniongungroups.mobile.android.meetup.network.services.AuthService
import com.iniongungroups.mobile.android.meetup.repository.network.IAuthNetwork
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

class AuthNetworkImpl @Inject constructor(
    private val authService: AuthService
): IAuthNetwork {

    override fun login(requestBody: HashMap<String, String>) = authService.login(requestBody)

    override fun register(requestBody: HashMap<String, String>) = authService.register(requestBody)
}