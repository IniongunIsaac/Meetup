package com.iniongungroups.mobile.android.meetup.auth.utils

import android.text.TextUtils

/**
 * Created by Isaac Iniongun on 2020-02-09.
 * For Meetup project.
 */

fun String.isValidEmailAddress(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}