package com.iniongungroups.mobile.android.meetup.di.modules

import android.content.Context
import com.iniongungroups.mobile.android.meetup.MeetupApplication
import com.iniongungroups.mobile.android.meetup.di.scopes.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideContext(meetupApp: MeetupApplication): Context = meetupApp

}