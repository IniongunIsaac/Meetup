package com.iniongungroups.mobile.android.meetup.di.modules

import com.iniongungroups.mobile.android.meetup.di.scopes.PerFragment
import com.iniongungroups.mobile.android.meetup.home.fragments.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

@Module
abstract class HomeFragmentBinding {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindHomeFragment(): HomeFragment

}