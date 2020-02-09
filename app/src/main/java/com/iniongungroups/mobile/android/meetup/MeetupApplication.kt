package com.iniongungroups.mobile.android.meetup

import com.iniongungroups.mobile.android.meetup.di.components.DaggerMeetupAppComponent
import com.iniongungroups.mobile.android.meetup.di.components.MeetupAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

class MeetupApplication: DaggerApplication() {

    private lateinit var meetupAppComponent: MeetupAppComponent

    override fun onCreate() {
        super.onCreate()

        meetupAppComponent.inject(this)

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        meetupAppComponent = DaggerMeetupAppComponent.builder().bindMeetupAppInstance(this).buildMeetupAppComponent()

        return meetupAppComponent

    }

}