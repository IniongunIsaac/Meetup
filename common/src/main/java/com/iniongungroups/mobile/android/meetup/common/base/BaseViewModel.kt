package com.iniongungroups.mobile.android.meetup.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iniongungroups.mobile.android.meetup.common.utils.liveDataEvent.LiveDataEvent
import com.iniongungroups.mobile.android.meetup.common.utils.state.AppResult
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

abstract class BaseViewModel: ViewModel(), CoroutineScope {

    val _notificationLiveData = MutableLiveData<LiveDataEvent<AppResult<Unit>>>()
    val notificationLiveData = _notificationLiveData as LiveData<LiveDataEvent<AppResult<Unit>>>

    val compositeDisposable = CompositeDisposable()

    abstract fun handleCoroutineException(throwable: Throwable)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable -> handleCoroutineException(throwable) }

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + coroutineExceptionHandler

    override fun onCleared() {
        super.onCleared()

        job.cancel()

        compositeDisposable.clear()
    }

}