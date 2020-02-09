package com.iniongungroups.mobile.android.meetup.di.components

import com.iniongungroups.mobile.android.meetup.MeetupApplication
import com.iniongungroups.mobile.android.meetup.di.modules.*
import com.iniongungroups.mobile.android.meetup.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        RepoNetModule::class,
        NetworkModule::class,
        ViewModelsModule::class,
        AppActivityBinding::class
    ]
)
@AppScope
interface MeetupAppComponent : AndroidInjector<DaggerApplication> {

    fun inject(meetupApp: MeetupApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindMeetupAppInstance(meetupApp: MeetupApplication): Builder

        fun buildMeetupAppComponent(): MeetupAppComponent
    }
}