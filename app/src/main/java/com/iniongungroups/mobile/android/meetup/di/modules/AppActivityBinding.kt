package com.iniongungroups.mobile.android.meetup.di.modules

import com.iniongungroups.mobile.android.meetup.auth.AuthActivity
import com.iniongungroups.mobile.android.meetup.di.scopes.PerActivity
import com.iniongungroups.mobile.android.meetup.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

@Module
abstract class AppActivityBinding {

    @PerActivity
    @ContributesAndroidInjector(modules = [AuthFragmentBinding::class])
    internal abstract fun bindAuthActivity(): AuthActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [HomeFragmentBinding::class])
    internal abstract fun bindHomeActivity(): HomeActivity

}