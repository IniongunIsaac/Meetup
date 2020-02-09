package com.iniongungroups.mobile.android.meetup.di.modules

import com.iniongungroups.mobile.android.meetup.auth.fragments.LoginFragment
import com.iniongungroups.mobile.android.meetup.auth.fragments.RegisterFragment
import com.iniongungroups.mobile.android.meetup.di.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

@Module
abstract class AuthFragmentBinding {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindLoginFragment(): LoginFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindRegisterFragment(): RegisterFragment

}