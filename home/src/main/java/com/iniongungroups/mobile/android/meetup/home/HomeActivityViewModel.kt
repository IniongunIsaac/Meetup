package com.iniongungroups.mobile.android.meetup.home

import com.iniongungroups.mobile.android.meetup.common.base.BaseViewModel
import com.iniongungroups.mobile.android.meetup.common.utils.liveDataEvent.LiveDataEvent
import com.iniongungroups.mobile.android.meetup.common.utils.state.AppResult
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

class HomeActivityViewModel @Inject constructor(): BaseViewModel() {


    override fun handleCoroutineException(throwable: Throwable) {
        _notificationLiveData.postValue(LiveDataEvent(AppResult.failed(throwable.message)))
    }

}