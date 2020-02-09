package com.iniongungroups.mobile.android.meetup.di.modules

import com.iniongungroups.mobile.android.meetup.di.scopes.AppScope
import com.iniongungroups.mobile.android.meetup.network.repositoryImpl.AuthNetworkImpl
import com.iniongungroups.mobile.android.meetup.repository.network.IAuthNetwork
import com.iniongungroups.mobile.android.meetup.repository.repos.AuthRepoImpl
import com.iniongungroups.mobile.android.meetup.repository.repos.IAuthRepo
import dagger.Binds
import dagger.Module

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

@Module(includes = [NetworkModule::class])
abstract class RepoNetModule {

    @Binds
    @AppScope
    internal abstract fun bindAuthNetwork(
        authNetworkImpl: AuthNetworkImpl
    ): IAuthNetwork

    @Binds
    @AppScope
    internal abstract fun bindAuthRepo(
        repository: AuthRepoImpl
    ): IAuthRepo

}