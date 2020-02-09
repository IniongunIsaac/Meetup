package com.iniongungroups.mobile.android.meetup.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iniongungroups.mobile.android.meetup.auth.utils.isValidEmailAddress
import com.iniongungroups.mobile.android.meetup.common.base.BaseViewModel
import com.iniongungroups.mobile.android.meetup.common.utils.liveDataEvent.LiveDataEvent
import com.iniongungroups.mobile.android.meetup.common.utils.state.AppResult
import com.iniongungroups.mobile.android.meetup.repository.repos.IAuthRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

class AuthActivityViewModel @Inject constructor(
    private val authRepo: IAuthRepo
): BaseViewModel() {

    var email = ""
    var password = ""
    var emailReg = ""
    var passwordReg = ""
    var confirmPassword = ""

    private val _authResultLiveData = MutableLiveData<LiveDataEvent<Boolean>>()
    val authResultLiveData = _authResultLiveData as LiveData<LiveDataEvent<Boolean>>

    fun login() {
        if (!email.isValidEmailAddress()) {
            _notificationLiveData.postValue(LiveDataEvent(AppResult.failed("Please enter a valid email address")))
        } else if (password.isEmpty()) {
            _notificationLiveData.postValue(LiveDataEvent(AppResult.failed("Please enter a valid password")))
        } else {

            _notificationLiveData.postValue(LiveDataEvent(AppResult.loading()))

            authRepo.login(hashMapOf("email" to email, "password" to password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.error != null) {
                        _notificationLiveData.postValue(LiveDataEvent(AppResult.failed(it.error)))
                    } else {
                        _authResultLiveData.postValue(LiveDataEvent(true))
                    }

                }, {
                    _notificationLiveData.postValue(LiveDataEvent(AppResult.failed(it.message ?: "An error occurred while trying to login, please try again.")))
                })
        }
    }

    fun register() {

        if (!emailReg.isValidEmailAddress()) {
            _notificationLiveData.postValue(LiveDataEvent(AppResult.failed("Please enter a valid email address.")))
        } else if (passwordReg.isEmpty()) {
            _notificationLiveData.postValue(LiveDataEvent(AppResult.failed("Please enter a valid password.")))
        } else if (confirmPassword.isEmpty()) {
            _notificationLiveData.postValue(LiveDataEvent(AppResult.failed("Please enter a valid value for confirm password field.")))
        } else if (passwordReg != confirmPassword) {
            _notificationLiveData.postValue(LiveDataEvent(AppResult.failed("Passwords do not match. Please enter matching passwords")))
        } else {

            _notificationLiveData.postValue(LiveDataEvent(AppResult.loading()))

            authRepo.register(hashMapOf("email" to emailReg, "password" to passwordReg))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.error != null) {
                        _notificationLiveData.postValue(LiveDataEvent(AppResult.failed(it.error)))
                    } else {
                        _authResultLiveData.postValue(LiveDataEvent(true))
                    }

                }, {
                    _notificationLiveData.postValue(LiveDataEvent(AppResult.failed(it.message ?: "An error occurred while trying to login, please try again.")))
                })

        }

    }


    override fun handleCoroutineException(throwable: Throwable) {
        _notificationLiveData.postValue(LiveDataEvent(AppResult.failed(throwable.message)))
    }

}