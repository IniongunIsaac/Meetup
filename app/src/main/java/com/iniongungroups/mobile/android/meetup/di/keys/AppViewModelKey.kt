package com.iniongungroups.mobile.android.meetup.di.keys

import com.iniongungroups.mobile.android.meetup.common.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class AppViewModelKey (val value: KClass<out BaseViewModel>)