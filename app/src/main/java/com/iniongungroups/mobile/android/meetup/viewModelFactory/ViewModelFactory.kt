package com.iniongungroups.mobile.android.meetup.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iniongungroups.mobile.android.meetup.common.base.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out BaseViewModel>, Provider<BaseViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val found = creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator = found?.value
            ?: throw IllegalArgumentException("Unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}