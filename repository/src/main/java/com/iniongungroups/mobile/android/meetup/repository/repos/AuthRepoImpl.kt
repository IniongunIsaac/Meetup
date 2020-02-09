package com.iniongungroups.mobile.android.meetup.repository.repos

import com.iniongungroups.mobile.android.meetup.repository.network.IAuthNetwork
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

class AuthRepoImpl @Inject constructor(
    private val authNetwork: IAuthNetwork
): IAuthRepo {

    override fun login(requestBody: HashMap<String, String>) = authNetwork.login(requestBody)

    override fun register(requestBody: HashMap<String, String>) = authNetwork.register(requestBody)

}