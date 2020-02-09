package com.iniongungroups.mobile.android.meetup.di.modules

import androidx.lifecycle.ViewModelProvider
import com.iniongungroups.mobile.android.meetup.auth.AuthActivityViewModel
import com.iniongungroups.mobile.android.meetup.common.base.BaseViewModel
import com.iniongungroups.mobile.android.meetup.di.keys.AppViewModelKey
import com.iniongungroups.mobile.android.meetup.home.HomeActivityViewModel
import com.iniongungroups.mobile.android.meetup.viewModelFactory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

@Module
abstract class ViewModelsModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @AppViewModelKey(AuthActivityViewModel::class)
    abstract fun bindAuthActivityViewModel(
        viewModel: AuthActivityViewModel
    ): BaseViewModel

    @Binds
    @IntoMap
    @AppViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(
        viewModel: HomeActivityViewModel
    ): BaseViewModel

}