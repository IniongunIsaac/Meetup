package com.iniongungroups.mobile.android.meetup.di.modules

import androidx.lifecycle.ViewModelProvider
import com.iniongungroups.mobile.android.meetup.viewModelFactory.ViewModelFactory
import dagger.Binds
import dagger.Module

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

//    @Binds
//    @IntoMap
//    @AppViewModelKey(SplashActivityViewModel::class)
//    abstract fun bindSplashActivityViewModel(
//        viewModel: SplashActivityViewModel
//    ): BaseViewModel

}